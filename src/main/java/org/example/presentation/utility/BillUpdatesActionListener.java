package org.example.presentation.utility;

import org.example.business.logic.utility.IdValidator;
import org.example.data.access.classes.BillDAO;
import org.example.data.access.classes.OrderDAO;
import org.example.data.access.classes.ProductDAO;
import org.example.model.classes.dto.BillT;
import org.example.model.classes.dto.OrderT;
import org.example.model.classes.dto.ProductT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BillUpdatesActionListener implements ActionListener {
    private final ArrayList<JTextField> textFields;

    public BillUpdatesActionListener(ArrayList<JTextField> textFields) {
        this.textFields = textFields;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int orderID = getOrderID();
        OrderDAO orderDAO = new OrderDAO();
        OrderT orderT = orderDAO.getOrder(orderID);

        ProductDAO productDAO = new ProductDAO();
        ProductT productT = productDAO.getProductById(orderT.productID());

        int price = productT.price() * orderT.getQuantity();
        BillT billT = new BillT(orderT.id(), price);
        BillDAO billDAO = new BillDAO();
        int id = billDAO.create(billT);
    }

    private int getOrderID() {
        String fieldData = textFields.getFirst().getText();
        try{
            IdValidator.getValidator().validate(fieldData);
        }
        catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Please enter a valid order ID!");
        }
        return Integer.parseInt(fieldData);
    }
}
