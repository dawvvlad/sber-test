package com.test.cli;
import com.test.util.AppRunner;
import org.springframework.stereotype.Component;

@Component
public class AllPurchasesMenu extends AbstractMenu {
    public AllPurchasesMenu(AppRunner appRunner) {
        super(appRunner);
    }

    @Override
    public void display() {
    }
}
