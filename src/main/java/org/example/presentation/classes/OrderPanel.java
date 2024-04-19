package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author L7aur
 */
public class OrderPanel extends JPanel implements View {
    private final String id;
    public OrderPanel() {
        this.id = "ORDER";
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
