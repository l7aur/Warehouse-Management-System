package org.example.presentation.classes;

import org.example.presentation.utility.ButtonElement;
import org.example.presentation.utility.MyActionListener;
import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author L7aur
 */
public class ProductPanel extends JPanel implements View {
    private final String id;
    private final MainFrame mainFrame;
    public ProductPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "PRODUCT";
        this.setBackground(Color.red);
        this.createContent();
    }

    @Override
    public void createContent() {
        ButtonElement buttonElement = new ButtonElement("BACK");
        buttonElement.addActionListener(new MyActionListener(this.mainFrame, "BACK"));
        this.add(buttonElement);
    }
    @Override
    public String getId() {
        return this.id;
    }
}
