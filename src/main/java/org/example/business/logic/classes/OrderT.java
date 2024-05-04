package org.example.business.logic.classes;

public class OrderT {
    private int orderID;
    private int clientID;
    private int quantity;
    private int id;

    public OrderT(int orderID, int clientID, int quantity) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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
