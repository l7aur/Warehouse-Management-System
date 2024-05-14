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

/**
 * Implementation of the ActionListener interface associated to the create SQL query in the order panel.
 * @author L7aur
 */
public class BillUpdatesActionListener implements ActionListener {

    /**
     * The array of text fields reference.
     */
    private final ArrayList<JTextField> textFields;

    /**
     * Constructor.
     * @param textFields An array of references to the fields that are displayed in the GUI.
     */
    public BillUpdatesActionListener(ArrayList<JTextField> textFields) {
        this.textFields = textFields;
    }

    /**
     * Queries the database on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int orderID = getOrderID();
        for (JTextField textField : textFields) {
            textField.setText("");
        }
        OrderDAO orderDAO = new OrderDAO();
        OrderT orderT = orderDAO.getOrderById(orderID);

        ProductDAO productDAO = new ProductDAO();
        ProductT productT = productDAO.getProductById(orderT.productID());

        int price = productT.price() * orderT.quantity();
        BillT billT = new BillT(orderT.id(), price);
        BillDAO billDAO = new BillDAO();
        int id = billDAO.create(billT);
        if(id == -1)
            JOptionPane.showMessageDialog(null, "Bill could not be created");
    }

    /**
     * Finds the id of the order whose id is in the first text field displayed in the GUI.
     * @return The id of the order.
     */
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
