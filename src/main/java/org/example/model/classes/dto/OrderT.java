package org.example.model.classes.dto;

import org.example.data.access.classes.OrderDAO;

public record OrderT(int clientID, int productID, int quantity, int id) {

    public OrderT(int clientID, int productID, int quantity) {
        this(clientID, productID, quantity, -1);
    }

    public OrderDAO convertToDAO() {
        return new OrderDAO();
    }

    public int getQuantity() {
        return quantity;
    }
}
