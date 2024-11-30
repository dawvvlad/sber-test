package com.test;
import com.test.util.config.Config;
import com.test.util.AppRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AppRunner appBuilder = context.getBean(AppRunner.class);
        appBuilder.run();
    }
}
