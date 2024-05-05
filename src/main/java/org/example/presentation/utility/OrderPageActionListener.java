package org.example.presentation.utility;

import org.example.business.logic.classes.ClientT;
import org.example.business.logic.classes.ProductT;
import org.example.model.classes.dto.Client;
import org.example.model.classes.dto.Product;
import org.example.presentation.classes.OrderPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderPageActionListener implements ActionListener {
    private final OrderPanel panel;

    public OrderPageActionListener(OrderPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductT pType = getProductT();
        ClientT cType = getClientT();

        ArrayList<ProductT> productList = null;
        ArrayList<ClientT> clientList = null;

        if(pType != null)
            productList = pType.convertToDAO().read();
        if(cType != null)
            clientList = cType.convertToDAO().read();
        this.panel.updateContent(clientList, productList);
    }

    private ClientT getClientT() {
        return (new Client()).convertToEntity();
    }

    private ProductT getProductT() {
        return (new Product()).convertToEntity();
    }
}
