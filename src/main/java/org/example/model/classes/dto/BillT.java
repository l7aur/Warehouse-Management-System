package org.example.model.classes.dto;

import org.example.data.access.classes.BillDAO;

/**
 *  The bill model
 * @author L7aur
 */
public record BillT(int orderID, int price) {

    public BillT(){
        this(-1, -1);
    }

    public BillT(int OrderID) {
        this(OrderID, -1);
    }

    public BillDAO convertToDAO() {
        return new BillDAO();
    }
}
