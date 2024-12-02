package com.test.purchase.model;

import java.util.Objects;

/**
 * Класс, представляющий товар для списка товаров
 **/
public class Purchase {
    private Long id;
    private String name;
    private int total;
    private double price;

    public Purchase() {}

    /**
     * Constructs a new Purchase with the specified details.
     *
     * @param name  название товара
     * @param total количество товара
     * @param price цена товара
     */
    public Purchase(String name, int total, double price) {
        this.name = name;
        this.total = total;
        this.price = price;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        if(id < 0) {
            throw new IllegalArgumentException("ID не может быть отрицательным");
        }
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

    /**
     * Устанавливает количество товара
     *
     * @param total                         цена товара
     * @throws IllegalArgumentException     если количество отрицательно
     */
    public void setTotal(int total) {
        if(total < 0) {
            throw new IllegalArgumentException("Количество товара не может быть отрицательным");
        }
        this.total = total;
    }
    public double getPrice() {
        return price;
    }

    /**
     * Устанавливает цену на товар
     *
     * @param price                         цена товара
     * @throws IllegalArgumentException     если цена отрицательна
     */
    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("{ \n\tID: %d, \n\tНазвание: '%s', \n\tКоличество: %d, \n\tЦена: %.2f\n}",
                id, name, total, price);
    }


    // equals and hashcode
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
