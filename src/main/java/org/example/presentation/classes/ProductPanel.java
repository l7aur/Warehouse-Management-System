package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author L7aur
 */
public class ProductPanel extends JPanel implements View {
    private final String id;

    public ProductPanel() {
        this.id = "PRODUCT";
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
