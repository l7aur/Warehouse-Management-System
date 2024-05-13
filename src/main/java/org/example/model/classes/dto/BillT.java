package org.example.model.classes.dto;

import org.example.data.access.classes.BillDAO;

/**
 * Bill data transfer object.
 * @param orderID The unique identifier of the order for which the bill is generated.
 * @param price The computed price of the order.
 * @param id The unique identifier of the bill.
 * @author L7aur
 */
public record BillT(int orderID, int price, int id) {

    /**
     * Constructor.
     */
    public BillT(){
        this(-1, -1, -1);
    }

    /**
     * Constructor.
     * @param orderID The unique identifier of the order.
     * @param price The price of the product that is contained in the order.
     */
    public BillT(int orderID, int price){
        this(orderID, price, -1);
    }

    /**
     * Creates a bill data abstract object.
     * @return A bill data abstract object.
     */
    public BillDAO convertToDAO() {
        return new BillDAO();
    }

}
