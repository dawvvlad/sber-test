package com.test.cli;

import com.test.util.AppRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MainMenu extends AbstractMenu {

    @Autowired
    public MainMenu(AppRunner appRunner) {
        super(appRunner);
    }

    @Override
    public void display() {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Список покупок");
            System.out.println("1. Показать покупки");
            System.out.println("2. Добавить покупку");
            System.out.println("3. Изменить покупку");
            System.out.println("4. Удалить покупку");
            System.out.println("0. Завершить работу");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println("1");

                case 0 -> {
                    System.out.println("Программа остановлена");
                    appRunner.stop();
                }
                default -> System.out.println("Неверный выбор");
            }
        }
    }
}
