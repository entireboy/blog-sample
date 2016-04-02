package kr.leocat.test.spring.aop.order.my;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by tuxedocat on 2016. 4. 2.
 */
@Slf4j
@Aspect
@Order(2)
@Component
public class MyAspect {

    @Pointcut("@annotation(kr.leocat.test.spring.aop.order.my.annotation.MyAnnotation)")
    public void myPointcut() {}


    @Around("myPointcut()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        log.info("my - Order(2) start");
        Object result = pjp.proceed();
        log.info("my - Order(2) end");
        return result;
    }

}
