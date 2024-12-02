package com.test.purchase.cli;

import com.test.purchase.model.Purchase;
import com.test.util.AppRunner;

import java.util.InputMismatchException;
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

    /**
     * Метод для получения покупки, данные для которой взяты на основе ввода в командной строке
     * <ul>
     *     <li>
     *          {@link String name} - получено из метода {@link #readNameInput()}
     *     </li>
     *     <li>
     *          {@link Integer total} - получено из метода {@link #readTotalInput()} ()}
     *      </li>
     *      <li>
     *          {@link Double price} - получено из метода {@link #readPriceInput()} ()}
     *      </li>
     * </ul>
     *
     * @return  Новую покупку
     */
    protected Purchase readPurchaseInput() {
        String name = readNameInput();
        int total = readTotalInput();
        double price = readPriceInput();

        return new Purchase(name, total, price);
    }

    private String readNameInput() {
        System.out.println("Введите название товара:");
        return scanner.nextLine();
    }

    /**
     * Валидация ввода количества
     */
    private int readTotalInput() {
        int total = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Введите количество товара:");
                total = scanner.nextInt();
                scanner.nextLine();
                if(total < 0) {
                    System.out.println("Количество не может быть меньше 0!");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите целое число для количества товара.");
                scanner.next();
            }
        }
        return total;
    }

    /**
     * Валидация ввода цены
     */
    private double readPriceInput() {
        double price = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Введите цену товара:");
                price = scanner.nextDouble();
                scanner.nextLine();
                if(price < 0) {
                    System.out.println("Цена не может быть меньше 0!");
                }
                else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите число для цены товара.");
                scanner.next();
            }
        }
        return price;
    }


}
