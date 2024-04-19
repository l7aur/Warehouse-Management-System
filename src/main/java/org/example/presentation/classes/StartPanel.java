package org.example.presentation.classes;

import org.example.Main;
import org.example.presentation.utility.ButtonElement;
import org.example.presentation.utility.MyActionListener;
import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author L7aur
 */
public class StartPanel extends JPanel implements View {
    private final String id;
    private final MainFrame mainFrame;
    public StartPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "START";
        this.setBackground(new Color(32, 42,68));
        this.createContent();
    }

    @Override
    public void createContent() {
        ButtonElement goToClient = new ButtonElement("CLIENT OPERATIONS");
        ButtonElement goToOrders = new ButtonElement("CREATE ORDER");
        ButtonElement goToProducts = new ButtonElement("PRODUCT OPERATIONS");
        goToClient.addActionListener(new MyActionListener(this.mainFrame, "CLIENT"));
        goToOrders.addActionListener(new MyActionListener(this.mainFrame, "ORDER"));
        goToProducts.addActionListener(new MyActionListener(this.mainFrame, "PRODUCT"));
        this.add(goToClient);
        this.add(goToOrders);
        this.add(goToProducts);
    }
    @Override
    public String getId() {
        return this.id;
    }
}
