package com.test.purchase.service;

import com.test.purchase.model.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseService {
    List<Purchase> findAll();
    Optional<Purchase> find(Long id);
    List<Purchase> findByName(String name);
    Purchase save(Purchase purchase);
    void delete(Long id);
    Purchase update(Long id);
}
