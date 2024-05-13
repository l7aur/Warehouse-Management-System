package org.example.business.logic.classes;

import org.example.business.logic.utility.IdValidator;
import org.example.business.logic.utility.PriceValidator;
import org.example.business.logic.utility.ProductNameValidator;
import org.example.business.logic.utility.StockValidator;
import org.example.model.classes.dto.ProductT;

/**
 * Represents a possible product with a product name, a stock, a price per unit and an id.
 * @param name The name of the possible product.
 * @param stock The available stock of the possible product.
 * @param price The price per unit of the possible product.
 * @param id The unique identifier of the possible product.
 * @author L7aur
 */
public record Product(String name, String stock, String price, String id) {

    /**
     * Constructor.
     * @param name The name of the possible product.
     * @param stock The available stock of the possible product.
     * @param price The price per unit of the possible product.
     */
    public Product(String name, String stock, String price) {
        this(name, stock, price, null);
    }

    /**
     * Constructor.
     */
    public Product() {
        this(null, null, null, null);
    }

    /**
     * Constructor.
     * @param id The unique identifier of the possible product.
     */
    public Product(String id) {
        this(null, null, null, id);
    }

    /**
     * Checks if the fields are valid data for a product entity by means of validators.
     * @return The product entity model or null.
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
