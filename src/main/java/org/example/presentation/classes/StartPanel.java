package org.example.presentation.classes;

import org.example.presentation.utility.*;

import java.awt.*;

/**
 * The initial panel that is displayed when the application is run
 * @author L7aur
 */
public class StartPanel extends AbstractView {
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
        goToProducts.addActionListener(new NavigateActionListener(this.mainFrame, "PRODUCT"));
        goToOrders.addActionListener(new NavigateActionListener(this.mainFrame, "ORDER"));
        OrderPanel panel = null;
        for (Component component : this.mainFrame.getContentPane().getComponents()) {
            if(component instanceof OrderPanel)
                panel = (OrderPanel) component;
        }
        goToOrders.addActionListener(new OrderPageActionListener(panel));
        this.add(goToClient);
        this.add(goToOrders);
        this.add(goToProducts);
    }
    @Override
    public String getId() {
        return this.id;
    }
}
