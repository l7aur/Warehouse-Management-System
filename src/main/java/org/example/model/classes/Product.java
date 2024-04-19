package org.example.model.classes;

/**
 * The product model
 * @author L7aur
 */
public class Product {
    private String name;
    private Integer stock;
    private Integer price;
    private Integer id;

    public Product(String name, Integer stock, Integer price, Integer id) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.id = id;
    }
}
