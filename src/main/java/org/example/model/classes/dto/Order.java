package org.example.model.classes.dto;

import org.example.business.logic.classes.OrderT;
import org.example.model.utility.IdValidator;
import org.example.model.utility.QuantityValidator;

/**
 *  The order data transfer object
 * @author L7aur
 */
public class Order {
    private final String clientID;
    private final String productID;
    private final String quantity;
    private String id;

    /**
     * Parameterised constructor
     * @param clientID the id of the client (foreign key to the client table)
     * @param productID the id of the product (foreign key to the order table)
     * @param quantity the quantity requested by the order
     */
    public Order(String clientID, String productID, String quantity) {
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }

    /**
     * Checks if the fields are valid data for an Order Entity
     * If they are
     * @return the entity model of the order abstract data type
     * else
     * handles as exception
     */
    public OrderT convertToEntity() {
        try {
            IdValidator.getValidator().validate(this.clientID);
            IdValidator.getValidator().validate(this.productID);
            QuantityValidator.getValidator().validate(this.quantity);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return null;
        }
        return new OrderT(Integer.parseInt(this.clientID), Integer.parseInt(this.productID),
                Integer.parseInt(this.quantity));
    }

    /**
     * Converts the order data transfer object into the printable version of the order.
     * @return the printable version of the order
     */
    @Override
    public String toString() {
        return "Order [clientID=" + clientID + ", productID=" + productID + ", quantity=" + quantity + "id=" + id +"]";
    }
}
