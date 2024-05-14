package org.example.presentation.classes;


import org.example.presentation.utility.*;

import javax.swing.*;
import java.awt.*;

/**
 * The bill panel.
 * @author L7aur
 */
public class BillPanel extends AbstractView {
    private final String id;
    private final MainFrame mainFrame;
    private JPanel panel;
    private CardLayout mainPanelCardLayout;
    private ViewBillView viewBillView;

    /**
     * Constructor.
     * @param mainFrame The main frame of the application.
     */
    public BillPanel(MainFrame mainFrame) {
        this.id = "BILL";
        this.mainFrame = mainFrame;
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    /**
     * Creates the GUI of the application.
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
     * Sets the GUI of the panel.
     */
    private void setMainPanel() {
        this.panel = new JPanel();
        this.panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.panel.setBackground(Colors.getInstance().getBackgroundColor());
        this.mainPanelCardLayout = new CardLayout();
        this.panel.setLayout(this.mainPanelCardLayout);

        CreateBillView createBillView = new CreateBillView();
        this.viewBillView = new ViewBillView();
        this.panel.add(createBillView, createBillView.getId());
        this.panel.add(viewBillView, viewBillView.getId());
    }

    /**
     * Creates a panel that houses the operation buttons.
     * @return A panel containing the operation buttons.
     */
    private JPanel createOperationButtons() {
        JPanel operationButtons = new JPanel();
        operationButtons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        operationButtons.setBackground(Colors.getInstance().getBackgroundColor());
        GridLayout layout = new GridLayout(2,1,5,5);
        operationButtons.setLayout(layout);
        MyButton button1 = new MyButton("INSERT BILL");
        MyButton button2 = new MyButton("VIEW BILLS");
        button1.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout, "CREATE_BILL_VIEW"));
        button2.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout, "VIEW_BILL_VIEW"));
        button2.addActionListener(new BillQueriesActionListener(this.viewBillView));
        operationButtons.add(button1);
        operationButtons.add(button2);
        return operationButtons;
    }

    /**
     * Getter.
     * @return The identifier of the panel.
     */
    public String getId() {
        return this.id;
    }
}
