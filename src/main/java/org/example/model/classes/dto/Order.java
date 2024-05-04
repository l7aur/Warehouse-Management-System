package org.example.model.classes.dto;

import org.example.business.logic.classes.OrderT;
import org.example.model.utility.IdValidator;
import org.example.model.utility.QuantityValidator;

/**
 *  The order model
 * @author L7aur
 */
public class Order {
    private String clientID;
    private String orderID;
    private String quantity;
    private String id;

    public Order(String clientID, String orderID, String quantity) {
        this.clientID = clientID;
        this.orderID = orderID;
        this.quantity = quantity;
    }

    public OrderT convertToEntity() {
        try {
            IdValidator.getValidator().validate(this.clientID);
            IdValidator.getValidator().validate(this.orderID);
            QuantityValidator.getValidator().validate(this.quantity);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
            return null;
        }
        return new OrderT(Integer.parseInt(this.clientID), Integer.parseInt(this.orderID), Integer.parseInt(this.quantity));
    }
}
