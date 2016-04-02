package kr.leocat.test.spring.aop.order;

import kr.leocat.test.spring.SpringTestContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


/**
 * Created by tuxedocat on 2016. 4. 2.
 */
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = SpringTestContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyClassTest {

    @Autowired
    private MyClass dut;


    @Test
    public void test() {
        dut.myMethod();
    }

}
