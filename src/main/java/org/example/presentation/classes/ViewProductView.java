package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;

import java.awt.*;

public class ViewProductView extends AbstractView {
    private final String id;
    public ViewProductView() {
        this.id = "VIEW_PRODUCT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
    }

    @Override
    public String getId() {
        return this.id;
    }
}
