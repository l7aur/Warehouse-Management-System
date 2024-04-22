package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

public class ViewProductView extends JPanel implements View {
    private final String id;
    public ViewProductView() {
        this.id = "VIEW_PRODUCT_VIEW";
        this.setBackground(Color.red);
    }

    @Override
    public void createContent() {

    }

    @Override
    public String getId() {
        return this.id;
    }
}
