package org.example.data.access.utility;

public enum Statement {

    SELECT_ALL_CLIENTS_QUERY("SELECT * FROM client"),
    SELECT_ALL_ORDERS_QUERY("SELECT * FROM order"),
    SELECT_ALL_PRODUCTS_QUERY("SELECT * FROM product"),
    SELECT_ALL_LOGS_QUERY("SELECT * FROM logs");

    private String query;
    Statement(String string) {
        this.query = string;
    }
    public String getQuery() {
        return this.query;
    }
}
