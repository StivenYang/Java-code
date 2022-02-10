package top.hengshare.interview.id;

import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import com.alibaba.nacos.api.naming.pojo.ListView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.PostConstruct;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class IdWorkerInit {


	@Autowired
	private NacosDiscoveryProperties nacosDiscoveryProperties;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Value("${spring.application.name:unDefined}")
	private String serverName;

	private static NamingService namingService ;


	private static final String ID_WORKER_KEY = "base:idworker" ;

	private final CopyOnWriteArrayList<String> serverNames =  new CopyOnWriteArrayList<>();

	/**
	 * workid 最大值
	 */
	private  static  final  long MAX_WORKER_ID = ~(-1L << 11);

	private final AtomicBoolean workingFlag = new AtomicBoolean(false) ;

	private  static final Long WORKING_TIME = 60*5L ;

	@PostConstruct
	public void listener() {
		preChange(false);
	}

	/**
	 * 预处理逻辑，过滤5分钟内重复服务上、下线造成wokerId不连续
	 */
	public void preChange( boolean isWait){
		if(!workingFlag.get()){
			workingFlag.set(true);
			try {
				if(isWait){
					TimeUnit.SECONDS.sleep(WORKING_TIME);
				}
				change();
				workingFlag.set(false);
			} catch (InterruptedException e) {
				log.error("preChange", e);
				Thread.currentThread().interrupt();
			} finally {
				workingFlag.set(false);
			}
		}
	}

	public void change() {
		log.debug("{} changing workerId",serverName);
		Long currentId = stringRedisTemplate.opsForValue().increment(ID_WORKER_KEY) ;
		if(currentId == null){
			currentId = 0L ;
			stringRedisTemplate.opsForValue().set(ID_WORKER_KEY,"0");
		}
		currentId = currentId & MAX_WORKER_ID;
		HSIdWorker.reSetWorkerId(currentId);
		//检测下是否有新的微服务
		addListener();
	}
	public synchronized void  addListener(){
		try {
			ListView<String> currentNames = getNamingService().getServicesOfServer(1,Integer.MAX_VALUE);
			currentNames.getData().forEach(sn->{
				if(!serverNames.contains(sn)){
					serverNames.add(sn);
					subscribeNewServerName(sn);
				}
			});
		} catch (NacosException e) {
			log.error("addListener error", e);
		}
	}



	public void subscribeNewServerName(String serverName){
		try {
			getNamingService().subscribe(serverName, event -> {
						NamingEvent event1 = 	(NamingEvent)event ;
						log.debug("{}server's instance change",event1.getServiceName());
						preChange(true);
					}
			);
		} catch (NacosException e) {
			log.error("subscribeNewServerName error", e);
		}
	}

	private NamingService getNamingService(){
		if(namingService==null){
			try {
				namingService = NacosFactory.createNamingService(nacosDiscoveryProperties.getNacosProperties());
			} catch (NacosException e) {
				log.error("getNamingService error",e);
			}
		}
		return namingService ;
	}


}