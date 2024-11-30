package com.test.purchase.service;

import com.test.purchase.model.Purchase;
import java.util.List;

public interface PurchaseService {
    List<Purchase> findAll();
    Purchase find(Long id);
    List<Purchase> findByName(String name);
    Purchase save(Purchase purchase);
    boolean delete(Long id);
    Purchase update(Long id, String name, int total, double price);
}
