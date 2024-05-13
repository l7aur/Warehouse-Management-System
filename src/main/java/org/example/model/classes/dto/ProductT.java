package org.example.model.classes.dto;

import org.example.data.access.classes.ProductDAO;

/**
 * The product data transfer object.
 * @param name The name of the product.
 * @param stock The available stock of the product.
 * @param price The price per unit of the product.
 * @param id The unique identifier of the product.
 * @author L7aur
 */
public record ProductT(String name, int stock, int price, int id) {

    /**
     * Constructor.
     * @param id The unique identifier of the product.
     */
    public ProductT(int id) {
        this(null, -1,-1,id);
    }

    /**
     * Constructor.
     */
    public ProductT() {
        this(null,-1,-1,-1);
    }

    /**
     * Constructor.
     * @param name The name of the product.
     * @param stock The available stock of the product.
     * @param price The price per unit of the product.
     */
    public ProductT(String name, Integer stock, Integer price) {
        this(name, stock, price, -1);
    }

    /**
     * Creates a product data abstract object.
     * @return A product data abstract object.
     */
    public ProductDAO convertToDAO() {
        return new ProductDAO();
    }

    /**
     * Creates the printable version of the product data transfer object.
     * @return A string representing the printable version of the product data transfer object.
     */
    @Override
    public String toString() {
        return name;
    }
}
