package org.example.data.access.classes;

import org.example.business.logic.classes.OrderT;

import java.util.ArrayList;

public class OrderDAO extends AbstractDAO<OrderT> {
    @Override
    public int create(OrderT orderT) {
        return super.create(orderT);
    }

    @Override
    public ArrayList<OrderT> read() {
        return super.read();
    }

    @Override
    public void update(OrderT orderT) {
        super.update(orderT);
    }

    @Override
    public void delete(OrderT orderT) {
        super.delete(orderT);
    }
}
