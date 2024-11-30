package com.test.cli;

import com.test.util.AppRunner;

public abstract class AbstractMenu {
    protected AppRunner appRunner;
    public AbstractMenu(AppRunner appRunner) {
        this.appRunner = appRunner;
    }

    public abstract void display();
}
