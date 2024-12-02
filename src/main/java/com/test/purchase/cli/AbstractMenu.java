package com.test.purchase.cli;

import com.test.util.AppRunner;

import java.util.Scanner;

public abstract class AbstractMenu {
    protected String name;
    protected AppRunner appRunner;
    protected final Scanner scanner = new Scanner(System.in);

    public AbstractMenu(AppRunner appRunner, String name) {
        this.appRunner = appRunner;
        this.name = name;
    }

    public void display() {
        showHeader();
        showOptions();
        handleChoice(getChoice());
    };

    public void showHeader(){
        System.out.println("\n-------- " + name + " ----------");
    }

    protected abstract void showOptions();
    protected abstract void handleChoice(int choice);

    protected int getChoice() {
        System.out.print("Ваш выбор: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: введите число.");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
