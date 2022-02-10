package top.hengshare.interview.id;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "enable", prefix = "hs.id.worker.auto" ,havingValue = "true")
public class IdWorkerAutoConfiguration {
	@Bean
	public IdWorkerInit IdWorkerInit(){
		return  new IdWorkerInit();
	}
}