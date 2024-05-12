package org.example.model.classes.dto;

import org.example.data.access.classes.BillDAO;

/**
 *  The bill model
 * @author L7aur
 */
public record BillT(OrderT orderT) {

    public BillT(){
        this(null);
    }

    public BillDAO convertToDAO() {
        return new BillDAO();
    }
}
