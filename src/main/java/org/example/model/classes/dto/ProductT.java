package org.example.model.classes.dto;

import org.example.data.access.classes.ProductDAO;

public class ProductT {
    private String name;
    private int stock;
    private int price;
    private int id;

    public ProductT(int id) {
        this.id = id;
    }
    public ProductT() {
    }

    public ProductT(String name, Integer stock, Integer price, Integer id) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.id = id;
    }

    public ProductT(String name, Integer stock, Integer price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public ProductDAO convertToDAO() {
        return new ProductDAO();
    }

    public void setAll(String name, Integer stock, Integer price, Integer id) {
        this.name = name;
        this.id = id;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
