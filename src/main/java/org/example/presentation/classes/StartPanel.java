package org.example.presentation.classes;

import org.example.presentation.utility.Colors;
import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.NavigateActionListener;
import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

/**
 * The initial panel that is displayed when the application is run
 * @author L7aur
 */
public class StartPanel extends JPanel implements View {
    private final String id;
    private final MainFrame mainFrame;
    public StartPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "START";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.createContent();
    }

    @Override
    public void createContent() {
        MyButton goToClient = new MyButton("CLIENT OPERATIONS");
        MyButton goToOrders = new MyButton("CREATE ORDER");
        MyButton goToProducts = new MyButton("PRODUCT OPERATIONS");
        goToClient.addActionListener(new NavigateActionListener(this.mainFrame, "CLIENT"));
        goToOrders.addActionListener(new NavigateActionListener(this.mainFrame, "ORDER"));
        goToProducts.addActionListener(new NavigateActionListener(this.mainFrame, "PRODUCT"));
        this.add(goToClient);
        this.add(goToOrders);
        this.add(goToProducts);
    }
    @Override
    public String getId() {
        return this.id;
    }
}
