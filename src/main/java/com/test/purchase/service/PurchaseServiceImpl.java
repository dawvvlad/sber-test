package com.test.purchase.service;

import com.test.purchase.model.Purchase;
import com.test.purchase.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepo purchaseRepo;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @Override
    public List<Purchase> findAll() {
        return List.of();
    }

    @Override
    public Optional<Purchase> find(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Purchase> findByName(String name) {
        return List.of();
    }

    @Override
    public Purchase save(Purchase purchase) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Purchase update(Long id) {
        return null;
    }
}
