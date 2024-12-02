package com.test.purchase.cli;
import com.test.purchase.model.Purchase;
import com.test.purchase.service.PurchaseService;
import com.test.util.AppRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Меню отображения всех существующих покупок
 **/

@Component
public class AllPurchasesMenu extends AbstractMenu {
    private final PurchaseService purchaseService;
    private List<Purchase> purchases;
    private final PurchaseMenu purchaseMenu;

    @Autowired
    public AllPurchasesMenu(AppRunner appRunner, PurchaseService purchaseService, PurchaseMenu purchaseMenu) {
        super(appRunner, "Ваши покупки");
        this.purchaseService = purchaseService;
        this.purchaseMenu = purchaseMenu;
    }

    @Override
    protected void showOptions() {
        System.out.println("Выберите номер покупки для дальнейших действий: ");
        purchases = purchaseService.findAll();
        purchases.forEach(e -> {
            System.out.println(e.getId() + ". " + e);
        });

        if(purchases.isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println("0. Назад");
    }

    @Override
    protected void handleChoice(int choice) {
        boolean found = false; // нахождение верного ответа
        for (Purchase e : purchases) {
            if (choice == e.getId()) {
                purchaseMenu.setId(e.getId());
                appRunner.navigateTo(purchaseMenu);
                found = true;
                break;
            }
        }
        if(choice == 0) {
            found = true;
            appRunner.goBack();
        }
        if (!found) {
            System.out.println("Некорректный выбор. Попробуйте снова.");
        }
    }
}
