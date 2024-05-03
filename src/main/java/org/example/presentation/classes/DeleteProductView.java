package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

public class DeleteProductView extends JPanel implements View {
    private final String id;
    public DeleteProductView() {
        this.id = "DELETE_PRODUCT_VIEW";
        this.setBackground(Color.yellow);
    }
    @Override
    public void createContent() {

    }

    @Override
    public String getId() {
        return this.id;
    }
}