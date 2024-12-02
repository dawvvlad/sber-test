package com.test.purchase.cli;

import com.test.purchase.model.Purchase;
import com.test.purchase.service.PurchaseService;
import com.test.util.AppRunner;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMenu extends AbstractMenu {
    private Long id;
    private final PurchaseService purchaseService;

    public PurchaseMenu(AppRunner appRunner, PurchaseService purchaseService) {
        super(appRunner, "Покупка");
        this.purchaseService = purchaseService;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    protected void showOptions() {
        if (id == null) {
            System.out.println("Ошибка: ID покупки не установлен.");
            System.out.println("0. Назад");
            return;
        }

        Purchase purchase = purchaseService.find(id);
        if (purchase == null) {
            System.out.println("Ошибка: Покупка с ID " + id + " не найдена.");
            System.out.println("0. Назад");
            return;
        }

        System.out.println("Информация о покупке:");
        System.out.println(purchase); // Выводим полную информацию о покупке

        System.out.println("\nВыберите действие:");
        System.out.println("1. Редактировать покупку");
        System.out.println("2. Удалить покупку");
        System.out.println("0. Назад");
    }

    @Override
    protected void handleChoice(int choice) {
        switch (choice) {
            case 1 -> {
                Purchase purchase = purchaseService.find(id);
                purchase = readPurchaseInput();
                purchaseService.update(id, purchase.getName(), purchase.getTotal(), purchase.getPrice());
            }
            case 2 -> {
                purchaseService.delete(id);
                appRunner.goBack();
            }
            case 0 -> appRunner.goBack();
            default -> System.out.println("Некорректный выбор. Попробуйте снова.");
        }
    }
}
