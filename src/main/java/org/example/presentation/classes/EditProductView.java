package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

public class EditProductView extends JPanel implements View {
    private final String id;
    public EditProductView() {
        this.id = "EDIT_PRODUCT_VIEW";
        this.setBackground(Color.blue);
    }

    @Override
    public void createContent() {

    }

    @Override
    public String getId() {
        return this.id;
    }
}
