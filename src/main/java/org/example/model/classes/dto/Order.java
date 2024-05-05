package org.example.model.classes.dto;

import org.example.business.logic.classes.OrderT;
import org.example.model.utility.IdValidator;
import org.example.model.utility.QuantityValidator;

/**
 *  The order model
 * @author L7aur
 */
public class Order {
    private final String clientID;
    private final String productID;
    private final String quantity;
    private String id;

    public Order(String clientID, String productID, String quantity) {
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }

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

    @Override
    public String toString() {
        return "Order [clientID=" + clientID + ", productID=" + productID + ", quantity=" + quantity + "id=" + id +"]";
    }
}
