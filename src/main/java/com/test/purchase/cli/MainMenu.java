package com.test.purchase.cli;

import com.test.util.AppRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainMenu extends AbstractMenu {
    private final AllPurchasesMenu allPurchasesMenu;
    private final CreatePurchaseMenu createPurchaseMenu;

    @Autowired
    public MainMenu(AppRunner appRunner, AllPurchasesMenu allPurchasesMenu, CreatePurchaseMenu createPurchaseMenu) {
        super(appRunner, "Главное меню");
        this.allPurchasesMenu = allPurchasesMenu;
        this.createPurchaseMenu = createPurchaseMenu;
    }

    @Override
    protected void showOptions() {
        System.out.println("1. Ваши покупки");
        System.out.println("2. Создать покупку");
        System.out.println("0. Завершить работу");
    }

    @Override
    protected void handleChoice(int choice) {
        switch (choice) {
            case 1 -> appRunner.navigateTo(allPurchasesMenu);
            case 2 -> appRunner.navigateTo(createPurchaseMenu);
            case 0 -> appRunner.stop();
            default -> System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
}
