package top.hengshare.interview.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.hengshare.interview.annotation.log.LogRecord;
import top.hengshare.interview.constant.LogActionEnum;
import top.hengshare.interview.mysql.mapper.ArgRecordLogMapper;
import top.hengshare.interview.mysql.model.ArgRecordLog;
import top.hengshare.interview.utils.RequestUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @author dxm
 */
@Aspect
@Component
public class LogAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

	@Autowired
	private ArgRecordLogMapper argRecordLogMapper;

	@Pointcut("@annotation(top.hengshare.interview.annotation.log.LogRecord)")
	public void mapper() {
	}

	@Around(value = "mapper()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		Method method = ((MethodSignature) pjp.getSignature()).getMethod();
		LogRecord logRecord = method.getAnnotation(LogRecord.class);
		LogActionEnum action = logRecord.action();
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		assert requestAttributes != null;
		HttpServletRequest request = requestAttributes.getRequest();
		String url = request.getRequestURL().toString();
		String ipFromRequest = RequestUtil.getIpFromRequest(request);
		ArgRecordLog argRecordLog = new ArgRecordLog();
		argRecordLog.setOperator("admin");
		argRecordLog.setAccessUrl(url);
		argRecordLog.setIpAddress(ipFromRequest);
		argRecordLog.setActionCode(action.getActionCode());
		argRecordLog.setActionName(action.getActionDescription());
		argRecordLog.setOperateTime(new Date());
		argRecordLog.setContent(JSON.toJSONString(pjp.getArgs()));
		LOGGER.info(pjp.getKind());
		LOGGER.info(Arrays.toString(pjp.getArgs()));
		LOGGER.info(pjp.getThis().toString());
		LOGGER.info(pjp.getSignature().toString());
		LOGGER.info(pjp.getSourceLocation().toString());
		LOGGER.info(pjp.getStaticPart().toString());
		LOGGER.info(pjp.getTarget().toString());
		try {
			argRecordLog.setSuccessFlag((byte) 0);
			try {
				argRecordLogMapper.insert(argRecordLog);
			} catch (Exception e) {
				LOGGER.error("insert arg_record_log failed. argRecordLog={}", argRecordLog);
			}
			return pjp.proceed();
		} catch (Throwable throwable) {
			argRecordLog.setSuccessFlag((byte) 1);
			try {
				argRecordLogMapper.insert(argRecordLog);
			} catch (Exception e) {
				LOGGER.error("insert arg_record_log failed. argRecordLog={}", argRecordLog);
			}
			throw throwable;
		}
	}
}
