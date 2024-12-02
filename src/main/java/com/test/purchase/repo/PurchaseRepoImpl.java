package com.test.purchase.repo;

import com.test.purchase.model.Purchase;
import com.test.util.storage.PurchaseStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Реализация репозитория для работы с данными
 * В качестве хранилища (базы данных) выступает {@link PurchaseStorage}
 **/

@Repository
public class PurchaseRepoImpl implements PurchaseRepo {

    private final PurchaseStorage purchaseStorage;
    private final AtomicLong countId = new AtomicLong(0);

    @Autowired
    public PurchaseRepoImpl(PurchaseStorage purchaseStorage) {
        this.purchaseStorage = purchaseStorage;
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseStorage.getAllPurchases();
    }

    @Override
    public Optional<Purchase> find(Long id) {
        return Optional.ofNullable(purchaseStorage.getPurchase(id));
    }

    @Override
    public List<Purchase> findByName(String name) {
        return purchaseStorage.removePurchasesByName(name);
    }

    @Override
    public Purchase save(Purchase purchase) {
        purchase.setId(countId.incrementAndGet());
        purchaseStorage.addPurchase(purchase);
        return purchase;
    }

    @Override
    public boolean delete(Long id) {
        return purchaseStorage.removePurchase(id);
    }

    /**
     * Обновление данных в {@link PurchaseStorage}
     * @param id        id покупки, которую нужно обновить
     * @param name      название
     * @param total     количество
     * @param price     цена
     **/
    @Override
    public Purchase update(Long id, String name, int total, double price) {
        Purchase purchase = purchaseStorage.getPurchase(id);
        if(purchase == null) {
            purchase = new Purchase(name, total, price);
            purchaseStorage.addPurchase(purchase);
        } else {
            purchase.setName(name);
            purchase.setTotal(total);
            purchase.setPrice(price);
            purchaseStorage.addPurchase(purchase);
        }
        return purchase;
    }
}
