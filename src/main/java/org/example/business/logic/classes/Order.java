package org.example.business.logic.classes;

import org.example.model.classes.dto.OrderT;
import org.example.business.logic.utility.IdValidator;
import org.example.business.logic.utility.QuantityValidator;

/**
 * Represents a possible order with a client id, a product id, a quantity and an id.
 * @param clientID The unique client identifier of the possible order.
 * @param productID The unique product identifier of the possible order.
 * @param quantity The quantity of the product in the possible order.
 * @param id The unique identifier of the possible order.
 * @author L7aur
 */
public record Order(String clientID, String productID, String quantity, String id) {

    /**
     * Constructor.
     * @param clientID The ID of the client that placed the possible order.
     * @param productID The ID of the product that the client has bought in the possible order.
     * @param quantity The amount of the product the client has to pay in the possible order.
     */
    public Order(String clientID, String productID, String quantity) {
        this(clientID, productID, quantity, null);
    }

    /**
     * Checks if the fields are valid data for an order entity by means of validators.
     * @return The order entity model or null.
     */
    public OrderT convertToEntity() {
        try {
            IdValidator.getValidator().validate(this.clientID);
            IdValidator.getValidator().validate(this.productID);
            QuantityValidator.getValidator().validate(this.quantity);
        }
        catch (IllegalArgumentException e) {
            System.out.println("<EXCEPTION> Order.java" + e.getMessage());
            return null;
        }
        return new OrderT(Integer.parseInt(this.clientID), Integer.parseInt(this.productID),
                Integer.parseInt(this.quantity));
    }

    /**
     * Creates the printable version of the order.
     * @return The printable version of the order.
     */
    @Override
    public String toString() {
        return "Order [clientID=" + clientID + ", productID=" + productID + ", quantity=" + quantity + "id=" + id +"]";
    }
}
