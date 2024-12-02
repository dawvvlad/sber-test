package com.test.util.cli;
import com.test.purchase.service.PurchaseService;
import com.test.util.AppRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AllPurchasesMenu extends AbstractMenu {
    private final PurchaseService purchaseService;

    @Autowired
    public AllPurchasesMenu(AppRunner appRunner, PurchaseService purchaseService) {
        super(appRunner, "Ваши покупки");
        this.purchaseService = purchaseService;
    }

    @Override
    protected void showOptions() {
        System.out.println("Ваши покупки:");
        purchaseService.findAll().forEach(System.out::println);
        System.out.println("0. Назад");
    }

    @Override
    protected void handleChoice(int choice) {
        if (choice == 0) {
            appRunner.goBack();
        } else {
            System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
}
