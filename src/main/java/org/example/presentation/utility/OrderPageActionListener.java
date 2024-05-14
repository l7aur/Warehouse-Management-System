package org.example.presentation.utility;

import org.example.model.classes.dto.ClientT;
import org.example.model.classes.dto.ProductT;
import org.example.business.logic.classes.Client;
import org.example.business.logic.classes.Product;
import org.example.presentation.classes.OrderPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Implementation of the ActionListener interface associated to the read SQL query for the order panel.
 * @author L7aur
 */
public class OrderPageActionListener implements ActionListener {
    private final OrderPanel panel;

    /**
     * Constructor.
     * @param panel A reference to the panel where the read SQL query results are displayed.
     */
    public OrderPageActionListener(OrderPanel panel) {
        this.panel = panel;
    }

    /**
     * Queries the database on action event to fetch the clients and the products.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ProductT pType = getProductT();
        ClientT cType = getClientT();

        ArrayList<Object> productList = null;
        ArrayList<Object> clientList = null;

        if(pType != null)
            productList = pType.convertToDAO().read(pType);
        if(cType != null)
            clientList = cType.convertToDAO().read(cType);
        this.panel.updateContent(clientList, productList);
    }

    /**
     * Creates an empty client data transfer object based on how many fields are in the GUI view.
     * @return The empty client data transfer object.
     */
    private ClientT getClientT() {
        return (new Client()).convertToEntity();
    }

    /**
     * Creates an empty product data transfer object based on how many fields are in the GUI view.
     * @return The empty product data transfer object.
     */
    private ProductT getProductT() {
        return (new Product()).convertToEntity();
    }
}
