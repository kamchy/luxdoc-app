package pl.chyla.luxdoc.infrastructure.aspect;

import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
class LoggingAspect {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(LoggingAspect.class);
    private StopWatch stopWatch = new StopWatch();

    @Around("logPoint()")
    private Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        logger.info("[KC] {} took {}", joinPoint.getSignature().toString(), stopWatch.getLastTaskTimeMillis());
        return  result;
    }

    @Pointcut("execution (* pl.chyla.luxdoc.application.docflow.DocflowService.*(..))")
    private void logPoint(){}
}
