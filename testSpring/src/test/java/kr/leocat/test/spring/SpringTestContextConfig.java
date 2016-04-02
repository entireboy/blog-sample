package kr.leocat.test.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by tuxedocat on 2016. 4. 2.
 */
@EnableAspectJAutoProxy
@ComponentScan("kr.leocat.test.spring")
@Configuration
public class SpringTestContextConfig {
}
