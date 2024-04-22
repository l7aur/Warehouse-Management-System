package org.example.presentation.classes;

import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.NavigateActionListener;
import org.example.presentation.utility.View;
import org.example.presentation.utility.ViewNavigateActionListener;

import javax.swing.*;
import java.awt.*;

/**
 * The panel that houses the product view
 * @author L7aur
 */
public class ProductPanel extends JPanel implements View {
    private final String id;
    private final MainFrame mainFrame;
    private JPanel panel;
    private CardLayout mainPanelCardLayout;

    public ProductPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "PRODUCT";
        this.setBackground(new Color(32, 42,68));
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public void createContent() {
        MyButton buttonElement = new MyButton("BACK");
        buttonElement.addActionListener(new NavigateActionListener(this.mainFrame, "BACK"));
        this.setMainPanel();
        this.add(buttonElement, BorderLayout.PAGE_END);
        this.add(this.createOperationButtons(), BorderLayout.WEST);
        this.add(this.panel, BorderLayout.CENTER);
    }

    private void setMainPanel() {
        this.panel = new JPanel();
        this.panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.panel.setBackground(new Color(100, 42,68));
        this.mainPanelCardLayout = new CardLayout();
        this.panel.setLayout(this.mainPanelCardLayout);
        CreateProductView createProductView = new CreateProductView();
        EditProductView editProductView = new EditProductView();
        ViewProductView viewProductView = new ViewProductView();
        DeleteProductView deleteProductView = new DeleteProductView();
        this.panel.add(createProductView, createProductView.getId());
        this.panel.add(editProductView, editProductView.getId());
        this.panel.add(viewProductView, viewProductView.getId());
        this.panel.add(deleteProductView, deleteProductView.getId());
    }

    private JPanel createOperationButtons() {
        JPanel operationButtons = new JPanel();
        operationButtons.setBackground(new Color(32, 42,68));
        operationButtons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        GridLayout layout = new GridLayout(4, 1, 10, 10);
        operationButtons.setLayout(layout);
        MyButton button1 = new MyButton("CREATE PRODUCT");
        button1.addActionListener(new ViewNavigateActionListener(this.panel,this.mainPanelCardLayout,"CREATE_PRODUCT_VIEW"));
        MyButton button2 = new MyButton("EDIT PRODUCT");
        button2.addActionListener(new ViewNavigateActionListener(this.panel,this.mainPanelCardLayout, "EDIT_PRODUCT_VIEW"));
        MyButton button3 = new MyButton("DELETE PRODUCT");
        button3.addActionListener(new ViewNavigateActionListener(this.panel,this.mainPanelCardLayout, "DELETE_PRODUCT_VIEW"));
        MyButton button4 = new MyButton("VIEW PRODUCTS");
        button4.addActionListener(new ViewNavigateActionListener(this.panel,this.mainPanelCardLayout ,"VIEW_PRODUCT_VIEW"));
        operationButtons.add(button1);
        operationButtons.add(button2);
        operationButtons.add(button3);
        operationButtons.add(button4);
        return operationButtons;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
