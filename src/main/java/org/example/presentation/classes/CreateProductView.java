package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

public class CreateProductView extends JPanel implements View {
    private final String id;
    public CreateProductView() {
        this.id = "CREATE_PRODUCT_VIEW";
        this.setBackground(Color.white);
    }

    @Override
    public void createContent() {

    }

    @Override
    public String getId() {
        return this.id;
    }
}
