package com.test.util;

import com.test.purchase.cli.AbstractMenu;
import com.test.purchase.cli.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Вынос логики инициализации приложения в отдельный метод.
 * <br/>
 * Используется стек вызовов menuStack
 **/

@Component
public class AppRunner {
    // Стек вызовов
    private final Deque<AbstractMenu> menuStack = new ArrayDeque<>();
    private final MainMenu mainMenu;

    @Autowired
    public AppRunner(@Lazy MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     * Запуск приложения
     * <ul>
     *     <li>
     *          В стек вызовов {@link #menuStack} добавляется главное меню
     *     </li>
     *     <li>
     *          Пока стек не пуст - актуальное меню - вершина стека;
     *          <br/>
     *          Отображается актуальное меню.
     *      </li>
     * </ul>
     **/
    public void run() {
        menuStack.push(mainMenu);
        while(!menuStack.isEmpty()){
            AbstractMenu currentMenu = menuStack.peek();
            if(currentMenu != null){
                currentMenu.display();
            }
        }
    }

    /**
     * Навигация в конкретное меню
     */
    public void navigateTo(AbstractMenu menu) {
        menuStack.push(menu); // Переход к новому меню
    }

    /**
     * Возврат назад
     */
    public void goBack() {
        menuStack.pop(); // Возврат к предыдущему меню
    }


    /**
     * Очистка стека - остановка приложения (при выборе варианта)
     */
    public void stop() {
        this.menuStack.clear();
    }
}
