package org.example.presentation.utility;

import org.example.model.classes.dto.ProductT;
import org.example.business.logic.classes.Product;
import org.example.presentation.classes.ViewProductView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Implementation of the ActionListener interface associated to the read SQL query.
 * @author L7aur
 */
public class ProductQueriesActionListener implements ActionListener {

    /**
     * The view product view reference.
     */
    private final ViewProductView panel;

    /**
     * Constructor.
     * @param panel A reference to the panel where the read SQL query results are displayed.
     */
    public ProductQueriesActionListener(ViewProductView panel) {
        this.panel = panel;
    }

    /**
     * Queries the database on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ProductT pType = getProductT();
        if (pType != null) {
            ArrayList<Object> list = pType.convertToDAO().read(pType);
            panel.updateContent(list);
        }
        else
            System.out.println("NULL PRODUCT OBJECT WHEN BUTTON PRESSED!");
    }

    /**
     * Creates an instance of a product data transfer object.
     * @return A new instance of the product data transfer object.
     */
    private ProductT getProductT() {
        return (new Product()).convertToEntity();
    }
}
