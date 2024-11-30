package com.test.util;

import com.test.purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Строитель App
 * Вынос логики инициализации приложения в отдельный метод
 **/

@Component
@Lazy
public class AppRunner {
    private final PurchaseService purchaseService;

    @Autowired
    public AppRunner(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    public void run() {
    }
}
