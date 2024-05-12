package org.example.business.logic.classes;

import org.example.business.logic.utility.IdValidator;
import org.example.business.logic.utility.PriceValidator;
import org.example.business.logic.utility.ProductNameValidator;
import org.example.business.logic.utility.StockValidator;
import org.example.model.classes.dto.ProductT;

/**
 * The product data transfer object
 * @author L7aur
 */
public record Product(String name, String stock, String price, String id) {

    /**
     * Parameterised constructor
     * @param name the name of the product
     * @param stock the available stock
     * @param price the price per unit
     */
    public Product(String name, String stock, String price) {
        this(name, stock, price, null);
    }

    /**
     * Empty constructor
     */
    public Product() {
        this(null, null, null, null);
    }

    /**
     * Parameterised constructor
     * @param id the id of the product
     */
    public Product(String id) {
        this(null, null, null, id);
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
            ProductNameValidator.getValidator().validate(this.name);
            StockValidator.getValidator().validate(this.stock);
            PriceValidator.getValidator().validate(this.price);
            IdValidator.getValidator().validate(this.id);
        } catch (IllegalArgumentException e) {
            System.out.println("<EXCEPTION> Product.java");
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
}
