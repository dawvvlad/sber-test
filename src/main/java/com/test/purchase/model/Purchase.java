package com.test.purchase.model;

import java.util.Objects;

/**
 * Класс, представляющий товар (телефон) для корзины
 **/
public class Purchase {
    private Long id;
    private String name;
    private int total;
    private double price;

    public Purchase() {}
    public Purchase(Long id, String name, int total, double price) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.price = price;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Purchase{id=%d, name='%s', total='%d', price=%.2f}",
                id, name, total, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        if (total != purchase.total) return false;
        return Objects.equals(this.id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, total, price);
    }
}
