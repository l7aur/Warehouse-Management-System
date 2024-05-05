package org.example.presentation.classes;

import org.example.presentation.utility.Colors;
import java.awt.*;

public class DeleteProductView extends AbstractView {
    private final String id;
    public DeleteProductView() {
        this.id = "DELETE_PRODUCT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
