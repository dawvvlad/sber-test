package com.test.purchase.config;
import com.test.purchase.aop.AOP;
import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.test.*"})
public class Config {
    @Bean
    public AOP aop() {
        return new AOP();
    }
}
