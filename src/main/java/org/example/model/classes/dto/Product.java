package org.example.model.classes.dto;

import org.example.business.logic.classes.ProductT;
import org.example.model.utility.*;

/**
 * The product model
 * @author L7aur
 */
public class Product {
    private String name;
    private String stock;
    private String price;
    private String id;

    public Product(String name, String stock, String price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public Product(String name, String stock, String price, String id) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.id = id;
    }

    public Product() {
    }

    public Product(String id) {
        this.id = id;
        this.name = null;
    }

    public ProductT convertToEntity() {
        try {
            ProductNameValidator.getValidator().validate(this);
            StockValidator.getValidator().validate(this);
            PriceValidator.getValidator().validate(this);
            IdValidator.getValidator().validate(this.id);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            return null;
        }
        if(this.id == null && this.name == null)
            return new ProductT();
        if(this.name == null)
            return new ProductT(Integer.parseInt(this.id));
        if(this.id == null)
            return new ProductT(this.name, Integer.parseInt(this.stock), Integer.parseInt(this.price));
        return new ProductT(this.name, Integer.parseInt(this.stock), Integer.parseInt(this.price), Integer.parseInt(this.id));
    }

    public String getName() {
        return name;
    }

    public String getStock() {
        return stock;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}
