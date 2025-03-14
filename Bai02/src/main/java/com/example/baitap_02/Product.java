package com.example.baitap_02;

import java.util.Date;

public class Product {
    private String name;
    private String category;
    private int soldQuantity;
    private Date createdAt;

    public Product(String name, String category, int soldQuantity, Date createdAt) {
        this.name = name;
        this.category = category;
        this.soldQuantity = soldQuantity;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}

