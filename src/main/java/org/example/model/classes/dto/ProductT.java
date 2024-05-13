package org.example.model.classes.dto;

import org.example.data.access.classes.ProductDAO;

public record ProductT(String name, int stock, int price, int id) {

    public ProductT(int id) {
        this(null, -1,-1,id);
    }
    public ProductT() {
        this(null,-1,-1,-1);
    }

    public ProductT(String name, Integer stock, Integer price) {
        this(name, stock, price, -1);
    }

    public ProductDAO convertToDAO() {
        return new ProductDAO();
    }

    @Override
    public String toString() {
        return name;
    }
}
