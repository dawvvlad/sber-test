package com.test.purchase.cli;

import com.test.purchase.model.Purchase;
import com.test.purchase.service.PurchaseService;
import com.test.util.AppRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePurchaseMenu extends AbstractMenu {
    private final PurchaseService purchaseService;

    @Autowired
    public CreatePurchaseMenu(AppRunner appRunner, PurchaseService purchaseService) {
        super(appRunner, "Создать покупку");
        this.purchaseService = purchaseService;
    }

    @Override
    protected void showOptions() {
        System.out.println("Создание новой покупки");
    }

    @Override
    protected int getChoice() {

        return 0;
    }

    @Override
    protected void handleChoice(int choice) {
        Purchase purchase = readPurchaseInput();
        Purchase savedPurchase = purchaseService.save(purchase);

        if(savedPurchase != null) {
            appRunner.goBack();
        } else {
            System.out.println("Ошибка, попробуйте снова");
        }
    }
}

