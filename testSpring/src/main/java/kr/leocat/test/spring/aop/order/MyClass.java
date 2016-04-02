package kr.leocat.test.spring.aop.order;

import kr.leocat.test.spring.aop.order.my.annotation.MyAnnotation;
import kr.leocat.test.spring.aop.order.myfirst.annotation.MyFirstAnnotation;
import kr.leocat.test.spring.aop.order.your.annotation.YourAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by tuxedocat on 2016. 4. 2.
 */
@Slf4j
@Component
public class MyClass {

    @MyFirstAnnotation
    @MyAnnotation
    @YourAnnotation
    public void myMethod() {
        log.info("잇힝~");
    }

}
