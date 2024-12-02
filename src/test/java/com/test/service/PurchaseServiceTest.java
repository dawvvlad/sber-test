package com.test.service;

import com.test.purchase.model.Purchase;
import com.test.purchase.repo.PurchaseRepo;
import com.test.purchase.repo.PurchaseRepoImpl;
import com.test.purchase.service.PurchaseService;
import com.test.purchase.service.PurchaseServiceImpl;
import com.test.util.storage.PurchaseStorage;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Import(PurchaseServiceImpl.class)
public class PurchaseServiceTest {

    private final PurchaseStorage purchaseStorage = new PurchaseStorage();
    private final PurchaseRepo purchaseRepo = new PurchaseRepoImpl(purchaseStorage);
    private final PurchaseService purchaseService = new PurchaseServiceImpl(purchaseRepo);


    @Test
    public void testSavePurchase() {
        Purchase purchase = new Purchase();
        purchase.setName("Purchase");
        purchase.setPrice(1000.0);
        purchase.setTotal(1);
        Purchase savedPurchase = purchaseService.save(purchase);
        assertEquals("Purchase", savedPurchase.getName());
        assertEquals(1000.0, savedPurchase.getPrice());
        assertEquals(1, savedPurchase.getTotal());
        assertEquals(1L, savedPurchase.getId());
    }

    @Test
    public void testFindPurchaseById() {
        Purchase purchase = new Purchase();
        purchase.setName("Purchase");
        purchase.setPrice(1000.0);
        purchase.setTotal(1);
        purchase.setId(1L);

        Purchase savedPurchase = purchaseService.save(purchase);
        Purchase foundPurchase = purchaseService.find(savedPurchase.getId());

        assertNotNull(foundPurchase, "Покупка не найдена!");
        assertEquals(savedPurchase.getId(), foundPurchase.getId(), "ID не совпадает");
        assertEquals(savedPurchase.getName(), foundPurchase.getName(), "Название не совпадает");
        assertEquals(savedPurchase.getPrice(), foundPurchase.getPrice(), "Цена не совпадает");
        assertEquals(savedPurchase.getTotal(), foundPurchase.getTotal(), "Количество не совпадает");
    }

    @Test
    public void testDeletePurchase() {
        // Создаем покупку
        Purchase purchase = new Purchase();
        purchase.setName("Purchase");
        purchase.setPrice(1000.0);
        purchase.setTotal(1);
        purchase.setId(1L);

        purchaseService.save(purchase);

        Purchase foundPurchase = purchaseService.find(purchase.getId());
        assertNotNull(foundPurchase, "Покупка должна быть найдена перед удалением");

        boolean isDeleted = purchaseService.delete(purchase.getId());

        assertTrue(isDeleted, "Удаление покупки не удалось");

        Purchase deletedPurchase = purchaseService.find(purchase.getId());
        assertNull(deletedPurchase, "Покупка должна быть удалена");
    }


    @Test
    public void testUpdatePurchase() {
        // Создаем покупку
        Purchase purchase = new Purchase();
        purchase.setName("Purchase");
        purchase.setPrice(1000.0);
        purchase.setTotal(1);
        purchase.setId(1L);

        purchaseService.save(purchase);

        Purchase foundPurchase = purchaseService.find(purchase.getId());
        assertNotNull(foundPurchase, "Покупка должна быть найдена перед обновлением");

        foundPurchase.setName("Updated Purchase");
        foundPurchase.setPrice(1200.0);
        foundPurchase.setTotal(2);

        Purchase updatedPurchase = purchaseService.update(foundPurchase.getId(), "Updated Purchase", 2, 1200.0);

        assertNotNull(updatedPurchase, "Обновленная покупка не найдена");
        assertEquals("Updated Purchase", updatedPurchase.getName(), "Название не обновлено");
        assertEquals(updatedPurchase.getPrice(), 1200.0, "Цена не обновлена");
        assertEquals(updatedPurchase.getTotal(), 2, "Количество не обновлено");
    }

}
