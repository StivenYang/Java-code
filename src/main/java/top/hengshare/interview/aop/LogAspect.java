package top.hengshare.interview.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author dxm
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* top.hengshare.interview.mysql.mapper.UserMapper.*(..))")
    public void mapper(){}

    @Around(value = "mapper()")
    public Object around(ProceedingJoinPoint pjp){
        try {
            LOGGER.info(pjp.getKind());
            LOGGER.info(pjp.getArgs().toString());
            LOGGER.info(pjp.getThis().toString());
            LOGGER.info(pjp.getSignature().toString());
            LOGGER.info(pjp.getSourceLocation().toString());
            LOGGER.info(pjp.getStaticPart().toString());
            LOGGER.info(pjp.getTarget().toString());
            Object proceed = pjp.proceed(pjp.getArgs());
            return proceed;
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            return throwable;
        }
    }
}
