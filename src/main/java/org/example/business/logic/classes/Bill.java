package org.example.business.logic.classes;

import org.example.model.classes.dto.BillT;

public record Bill(String orderId, String price, String id) {
    public Bill() {
        this(null, null, null);
    }

    public BillT convertToEntity() {
        return null;
    }
}
