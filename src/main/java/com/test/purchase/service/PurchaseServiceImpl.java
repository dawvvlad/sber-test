package com.test.purchase.service;

import com.test.purchase.model.Purchase;
import com.test.purchase.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepo purchaseRepo;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseRepo.findAll();
    }

    @Override
    public Purchase find(Long id) {
        return purchaseRepo.find(id).orElse(null);
    }

    @Override
    public List<Purchase> findByName(String name) {
        return purchaseRepo.findByName(name);
    }

    @Override
    public Purchase save(Purchase purchase) {
        return purchaseRepo.save(purchase);
    }

    @Override
    public boolean delete(Long id) {
        return purchaseRepo.delete(id);
    }

    @Override
    public Purchase update(Long id, String name, int total, double price) {
        return purchaseRepo.update(id, name, total, price);
    }
}
