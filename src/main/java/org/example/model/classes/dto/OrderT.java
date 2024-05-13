package org.example.model.classes.dto;

import org.example.data.access.classes.OrderDAO;

/**
 * The order data transfer object.
 * One order can request only one type of product.
 * @param clientID The unique identifier of the client.
 * @param productID The unique identifier of the product.
 * @param quantity The quantity of the product requested in the order.
 * @param id The unique identifier of the order.
 */
public record OrderT(int clientID, int productID, int quantity, int id) {

    /**
     * Constructor.
     * @param clientID The unique identifier of the client.
     * @param productID The unique identifier of the product.
     * @param quantity The quantity of the product requested in the order.
     */
    public OrderT(int clientID, int productID, int quantity) {
        this(clientID, productID, quantity, -1);
    }

    /**
     * Creates an order data abstract object.
     * @return An order data abstract object.
     */
    public OrderDAO convertToDAO() {
        return new OrderDAO();
    }
}
