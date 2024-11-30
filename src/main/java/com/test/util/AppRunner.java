package com.test.util;

import com.test.cli.AbstractMenu;
import com.test.cli.MainMenu;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Вынос логики инициализации приложения в отдельный метод
 * Используется стек вызовов menuStack
 **/
@Component
@Lazy
public class AppRunner {

    // Стек вызовов
    private final Deque<AbstractMenu> menuStack = new ArrayDeque<>();
    private volatile boolean running = false;

    public void run() {
        running = !menuStack.isEmpty();
        menuStack.push(new MainMenu(this));
        while(running){
            AbstractMenu currentMenu = menuStack.peek();
            if(currentMenu != null){
                currentMenu.display();
            }
        }
    }

    public void navigateTo(AbstractMenu menu) {
        menuStack.push(menu); // Переход к новому меню
    }

    public void goBack() {
        menuStack.pop(); // Возврат к предыдущему меню
    }

    public void stop() {
        running = false;
    }
}
