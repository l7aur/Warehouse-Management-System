package org.example.presentation.utility;

import org.example.model.classes.dto.ClientT;
import org.example.model.classes.dto.OrderT;
import org.example.model.classes.dto.ProductT;
import org.example.data.access.utility.QueryType;
import org.example.business.logic.classes.Order;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderUpdatesActionListener implements ActionListener {
    private final JTextField textField;
    private final JComboBox<ClientT> comboBox1;
    private final JComboBox<ProductT> comboBox2;
    private QueryType type;

    public OrderUpdatesActionListener(JTextField textField, JComboBox<ClientT> comboBox1, JComboBox<ProductT> comboBox2, String operationName) {
        this.textField = textField;
        this.comboBox1 = comboBox1;
        this.comboBox2 = comboBox2;
        switch (operationName) {
            case "INSERT":
                this.type = QueryType.INSERT;
                break;
            case "VIEW":
                break;
            default:
                System.out.println("You should not be here!");
                break;
        }
    }

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
                        JOptionPane.showMessageDialog(null, "Insufficient stock!\nOrder failed!");
                    }
                    System.out.println("Inserted Order ID: " + id);
                    break;
                default:
                    System.out.println("You should not be here!!");
                    break;
            }
    }

    private OrderT getOrderT() {
        if (comboBox1.getSelectedItem() == null || comboBox2.getSelectedItem() == null)
            return null;
        Order order = new Order(String.valueOf( ((ClientT)comboBox1.getSelectedItem()).getId()),
                String.valueOf(((ProductT)comboBox2.getSelectedItem()).getId()),
                textField.getText());
        return order.convertToEntity();
    }
}
