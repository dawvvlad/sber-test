package com.test.purchase.cli;

import com.test.purchase.model.Purchase;
import com.test.util.AppRunner;
import java.util.Scanner;

/**
 * Абстрактный класс меню CLI,
 * содержит абстрактные методы для реализации в каждом меню;
 * содержит реализованные общие методы для каждого меню.
 **/
public abstract class AbstractMenu {
    protected String name;
    protected AppRunner appRunner;
    protected final Scanner scanner = new Scanner(System.in);

    public AbstractMenu(AppRunner appRunner, String name) {
        this.appRunner = appRunner;
        this.name = name;
    }

    /**
     * Выводит на экран основную информацию, а также элементы управления
     <ul>
     *     <li>{@link #showHeader()} - выводит заголовок меню.</li>
     *     <li>{@link #showOptions()} - отображает доступные опции меню.</li>
     *     <li>{@link #getChoice()} - получает выбор пользователя.</li>
     *     <li>{@link #handleChoice(int)} - обрабатывает выбор пользователя.</li>
     * </ul>
     */
    public void display() {
        showHeader();
        showOptions();
        handleChoice(getChoice());
    };

    public void showHeader(){
        System.out.println("\n-------- " + name + " ----------");
    }

    protected abstract void showOptions();

    /**
     * Абстрактный метод для управления приложением
     **/
    protected abstract void handleChoice(int choice);


    /**
     * Реализует действие через ввод в командной строке
     * @return      Введенное целое число, соответствующее списку действий
     */
    protected int getChoice() {
        System.out.print("Ваш выбор: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    protected Purchase readPurchaseInput() {
        System.out.println("Введите название товара:");
        String name = scanner.next();

        System.out.println("Введите количество товара:");
        int total = scanner.nextInt();

        System.out.println("Введите цену товара:");
        double price = scanner.nextDouble();

        return new Purchase(name, total, price);
    }
}
