package com.test;
import com.test.purchase.model.Purchase;
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

        Purchase p1 = new Purchase(1L, "телефон", 1, 200.0);
        System.out.println(p1);
    }
}
