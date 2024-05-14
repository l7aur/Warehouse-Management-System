package org.example.presentation.classes;

import org.example.presentation.utility.*;

import javax.swing.*;
import java.awt.*;

/**
 * The product panel.
 * @author L7aur
 */
public class ProductPanel extends AbstractView {
    private final String id;
    private final MainFrame mainFrame;
    private JPanel panel;
    private CardLayout mainPanelCardLayout;
    private ViewProductView viewProductView;

    /**
     * Constructor.
     * @param mainFrame The main frame of the application.
     */
    public ProductPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "PRODUCT";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    /**
     * Creates the GUI of the panel.
     */
    @Override
    public void createContent() {
        this.setMainPanel();
        MyButton buttonElement = new MyButton("BACK");
        buttonElement.addActionListener(new NavigateActionListener(this.mainFrame, "BACK", this.panel));
        this.add(buttonElement, BorderLayout.PAGE_END);
        this.add(this.createOperationButtons(), BorderLayout.WEST);
        this.add(this.panel, BorderLayout.CENTER);
    }

    /**
     * Sets the views in the card layout.
     */
    private void setMainPanel() {
        this.panel = new JPanel();
        this.panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.panel.setBackground(Colors.getInstance().getBackgroundColor());
        this.mainPanelCardLayout = new CardLayout();
        this.panel.setLayout(this.mainPanelCardLayout);

        CreateProductView createProductView = new CreateProductView();
        EditProductView editProductView = new EditProductView();
        DeleteProductView deleteProductView = new DeleteProductView();
        this.viewProductView = new ViewProductView();

        this.panel.add(createProductView, createProductView.getId());
        this.panel.add(editProductView, editProductView.getId());
        this.panel.add(this.viewProductView, this.viewProductView.getId());
        this.panel.add(deleteProductView, deleteProductView.getId());
    }

    /**
     * Sets the buttons inside a panel.
     * @return The panel that houses the buttons.
     */
    private JPanel createOperationButtons() {
        JPanel operationButtons = new JPanel();
        operationButtons.setBackground(Colors.getInstance().getBackgroundColor());
        operationButtons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        GridLayout layout = new GridLayout(4, 1, 10, 10);
        operationButtons.setLayout(layout);
        MyButton button1 = new MyButton("CREATE PRODUCT");
        button1.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout,"CREATE_PRODUCT_VIEW"));
        MyButton button2 = new MyButton("EDIT PRODUCT");
        button2.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout, "EDIT_PRODUCT_VIEW"));
        MyButton button3 = new MyButton("DELETE PRODUCT");
        button3.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout, "DELETE_PRODUCT_VIEW"));
        MyButton button4 = new MyButton("VIEW PRODUCTS");
        button4.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout ,"VIEW_PRODUCT_VIEW"));
        button4.addActionListener(new ProductQueriesActionListener(this.viewProductView));
        operationButtons.add(button1);
        operationButtons.add(button2);
        operationButtons.add(button3);
        operationButtons.add(button4);
        return operationButtons;
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
