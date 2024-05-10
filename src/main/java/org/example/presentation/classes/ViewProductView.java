package org.example.presentation.classes;

import org.example.business.logic.classes.ProductT;
import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;

import java.awt.*;
import java.util.ArrayList;

public class ViewProductView extends AbstractView {
    private final String id;
    public ViewProductView() {
        this.id = "VIEW_PRODUCT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
    }

    public void updateContent(ArrayList<ProductT> products) {
        if (products != null) {
            this.removeAll();
            String[][] data = new String[products.size()][4];
            String[] columns = {"Name", "Stock", "Price", "Id"};
            int i = 0;
            for (ProductT product : products) {
                data[i][0] = product.getName();
                data[i][1] = product.getStock().toString();
                data[i][2] = product.getPrice().toString();
                data[i][3] = product.getId().toString();
                i++;
            }
            addScrollPane(data, columns, "PRODUCTS");
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
