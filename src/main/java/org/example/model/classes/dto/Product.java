package org.example.model.classes.dto;

import org.example.business.logic.classes.ProductT;
import org.example.model.utility.*;

/**
 * The product data transfer object
 * @author L7aur
 */
public class Product {
    private String name;
    private String stock;
    private String price;
    private String id;

    /**
     * Parameterised constructor
     * @param name the name of the product
     * @param stock the available stock
     * @param price the price per unit
     */
    public Product(String name, String stock, String price) {
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    /**
     * Parameterised constructor
     * @param name the name of the product
     * @param stock the available stock
     * @param price the price per unit
     * @param id the id of the product
     */
    public Product(String name, String stock, String price, String id) {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.id = id;
    }

    /**
     * Empty constructor
     */
    public Product() {
    }

    /**
     * Parameterised constructor
     * @param id the id of the product
     */
    public Product(String id) {
        this.id = id;
    }

    /**
     * Checks if the fields are valid data for a Product Entity
     * If they are
     * @return the entity model of the product abstract data type
     * else
     * handles as exception
     */
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

    /**
     * Getter
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Getter
     * @return the available stock
     */
    public String getStock() {
        return stock;
    }

    /**
     * Getter
     * @return the price per unit of the product
     */
    public String getPrice() {
        return price;
    }

    /**
     * Getter
     * @return the id of the product
     */
    public String getId() {
        return id;
    }
}
