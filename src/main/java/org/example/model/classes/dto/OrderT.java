package org.example.model.classes.dto;

import org.example.data.access.classes.OrderDAO;

public class OrderT {
    private int productID;
    private int clientID;
    private int quantity;
    private int id;

    public OrderT(int clientID, int productID, int quantity) {
        this.productID = productID;
        this.clientID = clientID;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public OrderDAO convertToDAO() {
        return new OrderDAO();
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
