package com.test.purchase.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import java.util.logging.Logger;

@Aspect
public final class AOP {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Before("execution(* com.test.util.AppRunner.run(..))")
    public void beforeConstructor() {
        logger.info("Инициализация приложения");
    }

    @After("execution(* com.test.purchase.service.PurchaseService.save(..))")
    public void afterSave(JoinPoint joinPoint) {
        logger.info("[Метод " + joinPoint.getSignature().getName() + "]" + " покупка создана!");
    }

    @After("execution(* com.test.purchase.service.PurchaseService.delete(..))")
    public void afterDelete(JoinPoint joinPoint) {
        logger.info("[Метод " + joinPoint.getSignature().getName() + "]" + " покупка удалена!");
    }

    @After("execution(* com.test.purchase.service.PurchaseService.update(..))")
    public void afterUpdate(JoinPoint joinPoint) {
        logger.info("[Метод " + joinPoint.getSignature().getName() + "]" + " покупка обновлена!");
    }
}
