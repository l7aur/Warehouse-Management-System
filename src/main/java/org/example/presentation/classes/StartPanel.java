package org.example.presentation.classes;

import org.example.presentation.utility.*;

import java.awt.*;

/**
 * The initial panel that is displayed when the application is run.
 * @author L7aur
 */
public class StartPanel extends AbstractView {
    private final String id;
    private final MainFrame mainFrame;

    /**
     * Constructor.
     * @param mainFrame The main frame of the application.
     */
    public StartPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "START";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.createContent();
    }

    /**
     * Creates the GUI of the panel.
     */
    @Override
    public void createContent() {
        MyButton goToClient = new MyButton("CLIENT OPERATIONS");
        MyButton goToOrders = new MyButton("CREATE ORDER");
        MyButton goToProducts = new MyButton("PRODUCT OPERATIONS");
        MyButton goToBills = new MyButton("BILL OPERATIONS");
        goToClient.addActionListener(new NavigateActionListener(this.mainFrame, "CLIENT"));
        goToProducts.addActionListener(new NavigateActionListener(this.mainFrame, "PRODUCT"));
        goToOrders.addActionListener(new NavigateActionListener(this.mainFrame, "ORDER"));
        goToBills.addActionListener(new NavigateActionListener(this.mainFrame, "BILL"));
        OrderPanel panel = null;
        for (Component component : this.mainFrame.getContentPane().getComponents()) {
            if(component instanceof OrderPanel)
                panel = (OrderPanel) component;
        }
        goToOrders.addActionListener(new OrderPageActionListener(panel));
        this.add(goToClient);
        this.add(goToOrders);
        this.add(goToProducts);
        this.add(goToBills);
    }

    /**
     * Getter.
     * @return The identifier of the panel.
     */
    @Override
    public String getId() {
        return this.id;
    }
}
