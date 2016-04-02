package kr.leocat.test.spring.aop.order.myfirst;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by tuxedocat on 2016. 4. 2.
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class MyFirstAspect {

    @Pointcut("@annotation(kr.leocat.test.spring.aop.order.myfirst.annotation.MyFirstAnnotation)")
    public void myFirstPointcut() {}


    @Around("myFirstPointcut()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        log.info("my - Order(1) start");
        Object result = pjp.proceed();
        log.info("my - Order(1) end");
        return result;
    }

//    @Before("myFirstPointcut()")
    public void logBefore() {
        log.info("my  - Order(1) before");
    }

}
