package com.test.util;

import com.test.util.cli.AbstractMenu;
import com.test.util.cli.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Вынос логики инициализации приложения в отдельный метод
 * Используется стек вызовов menuStack
 **/
@Component
public class AppRunner {
    // Стек вызовов
    private final Deque<AbstractMenu> menuStack = new ArrayDeque<>();
    MainMenu mainMenu;

    @Autowired
    public AppRunner(@Lazy MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }



    public void run() {
        menuStack.push(mainMenu);
        while(!menuStack.isEmpty()){
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
        this.menuStack.clear();
    }
}
