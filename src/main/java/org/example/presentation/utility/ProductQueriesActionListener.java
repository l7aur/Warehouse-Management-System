package org.example.presentation.utility;

import org.example.business.logic.classes.ProductT;
import org.example.model.classes.dto.Product;
import org.example.presentation.classes.ViewProductView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductQueriesActionListener implements ActionListener {
    private final ViewProductView panel;
    public ProductQueriesActionListener(ViewProductView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductT pType = getProductT();
        if (pType != null) {
            ArrayList<ProductT> list = pType.convertToDAO().read();
            panel.updateContent(list);
        }
        else
            System.out.println("null");
    }

    private ProductT getProductT() {
        return (new Product()).convertToEntity();
    }
}
