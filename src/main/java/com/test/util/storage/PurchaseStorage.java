package com.test.util.storage;

import com.test.purchase.model.Purchase;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс, имитирующий базу данных/хранилище
 **/

@Component
@Lazy
public final class PurchaseStorage {
    private final Map<Long, Purchase> purchases = new HashMap<>();
    private long countOfPurchases = 0;
    public PurchaseStorage() {}

    private void incrementCountOfPurchases() {
        countOfPurchases++;
    }

    private void decrementCountOfPurchases() {
        countOfPurchases--;
    }

    public long getCountOfPurchases() {
        return countOfPurchases;
    }

    public void addPurchase(Purchase purchase) {
        purchases.put(purchase.getId(), purchase);
        incrementCountOfPurchases();
    }
    public List<Purchase> getAllPurchases() {
        return new ArrayList<>(this.purchases.values());
    }

    public Purchase getPurchase(Long id) {
        if(purchases.containsKey(id)) {
            return purchases.get(id);
        }
        return null;
    }

    public List<Purchase> removePurchasesByName(String name) {
        return this.purchases.values()
                .stream()
                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList());
    }

    public boolean removePurchase(Long id) {
        boolean res = false;
        if(this.purchases.remove(id) != null) {
            res = true;
            decrementCountOfPurchases();
        };
        return res;
    }

}
