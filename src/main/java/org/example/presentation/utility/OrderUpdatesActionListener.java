package org.example.presentation.utility;

import org.example.data.access.classes.BillDAO;
import org.example.data.access.classes.ProductDAO;
import org.example.model.classes.dto.BillT;
import org.example.model.classes.dto.ClientT;
import org.example.model.classes.dto.OrderT;
import org.example.model.classes.dto.ProductT;
import org.example.data.access.utility.QueryType;
import org.example.business.logic.classes.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implementation of the ActionListener interface associated to the create SQL query in the order panel.
 * @author L7aur
 */
public class OrderUpdatesActionListener implements ActionListener {

    /**
     * The array of text fields reference.
     */
    private final JTextField textField;

    /**
     * The client selector reference.
     */
    private final JComboBox<ClientT> comboBox1;

    /**
     * The product selector reference.
     */
    private final JComboBox<ProductT> comboBox2;

    /**
     * The query type.
     */
    private QueryType type;

    /**
     * Constructor.
     * @param textField A reference to the text field that is displayed in the GUI.
     * @param comboBox1 A reference to the combo box that selects between clients.
     * @param comboBox2 A reference to the combo box that selects between products.
     * @param operationName The name of the operation that should be executed.
     */
    public OrderUpdatesActionListener(JTextField textField, JComboBox<ClientT> comboBox1, JComboBox<ProductT> comboBox2, String operationName) {
        this.textField = textField;
        this.comboBox1 = comboBox1;
        this.comboBox2 = comboBox2;
        switch (operationName) {
            case "INSERT":
                this.type = QueryType.INSERT;
                break;
            case "VIEW":
                //not requested
                break;
            default:
                System.out.println("You should not be here!");
                break;
        }
    }

    /**
     * Queries the database on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        OrderT oType = getOrderT();
        if (oType == null) {
            JOptionPane.showMessageDialog(null, "Invalid input data.\n Please try again!");
        } else
            switch (type) {
                case UPDATE:
                    break;
                case INSERT:
                    int id = oType.convertToDAO().create(oType);
                    if (id == -1) {
                        JOptionPane.showMessageDialog(null, "Insufficient stock!\nOrder failed!",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        ProductDAO productDAO = new ProductDAO();
                        ProductT productT = productDAO.getProductById(oType.productID());

                        (new BillDAO()).create(new BillT(id, oType.quantity() * productT.price()));
                    }
                    break;
                default:
                    System.out.println("You should not be here!!");
                    break;
            }
    }

    /**
     * Creates an order data transfer object based on what is selected/filled in the GUI fields.
     * @return The order data transfer object.
     */
    private OrderT getOrderT() {
        if (comboBox1.getSelectedItem() == null || comboBox2.getSelectedItem() == null)
            return null;
        Order order = new Order(String.valueOf( ((ClientT)comboBox1.getSelectedItem()).id()),
                String.valueOf(((ProductT)comboBox2.getSelectedItem()).id()),
                textField.getText());
        return order.convertToEntity();
    }
}
