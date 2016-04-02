package kr.leocat.test.spring.aop.order.your;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by tuxedocat on 2016. 4. 2.
 */
@Slf4j
@Aspect
@Component
public class YourAspect {

    @Pointcut("@annotation(kr.leocat.test.spring.aop.order.your.annotation.YourAnnotation)")
    public void yourPointcut() {}


    @Around("yourPointcut()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        log.info("your - not ordered start");
        Object result = pjp.proceed();
        log.info("your - not ordered end");
        return result;
    }

}
