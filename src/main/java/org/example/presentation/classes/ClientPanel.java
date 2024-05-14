package org.example.presentation.classes;

import org.example.presentation.utility.*;

import javax.swing.*;
import java.awt.*;

/**
 * The client panel.
 * @author L7aur
 */
public class ClientPanel extends AbstractView {

    /**
     * The unique identifier of the view.
     */
    private final String id;

    /**
     * The main frame of the application.
     */
    private final MainFrame mainFrame;

    /**
     * The main panel reference.
     */
    private JPanel panel;

    /**
     * The card layout of the panel reference.
     */
    private CardLayout mainPanelCardLayout;

    /**
     * The view client view reference
     */
    private ViewClientView viewClientView;

    /**
     * Constructor.
     * @param mainFrame The main frame of the application.
     */
    public ClientPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setLayout(new BorderLayout());
        this.id = "CLIENT";
        this.setBackground(Colors.getInstance().getBackgroundColor());
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
     * Sets the GUI of the main panel.
     */
    private void setMainPanel() {
        this.panel = new JPanel();
        this.panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.panel.setBackground(Colors.getInstance().getBackgroundColor());
        this.mainPanelCardLayout = new CardLayout();
        this.panel.setLayout(this.mainPanelCardLayout);
        CreateClientView clientView = new CreateClientView();
        EditClientView editClientView = new EditClientView();
        this.viewClientView = new ViewClientView();
        DeleteClientView deleteClientView = new DeleteClientView();
        this.panel.add(clientView, clientView.getId());
        this.panel.add(editClientView, editClientView.getId());
        this.panel.add(deleteClientView, deleteClientView.getId());
        this.panel.add(this.viewClientView, this.viewClientView.getId());
    }

    /**
     * Creates a panel that houses the operation buttons.
     * @return A panel containing the operation buttons.
     */
    private JPanel createOperationButtons() {
        JPanel operationButtons = new JPanel();
        operationButtons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        operationButtons.setBackground(Colors.getInstance().getBackgroundColor());
        GridLayout layout = new GridLayout(4, 1, 10, 10);
        operationButtons.setLayout(layout);
        MyButton button1 = new MyButton("CREATE CLIENT");
        button1.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout, "CREATE_CLIENT_VIEW"));
        MyButton button2 = new MyButton("EDIT CLIENT");
        button2.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout, "EDIT_CLIENT_VIEW"));
        MyButton button3 = new MyButton("DELETE CLIENT");
        button3.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout, "DELETE_CLIENT_VIEW"));
        MyButton button4 = new MyButton("VIEW CLIENTS");
        button4.addActionListener(new ViewNavigateActionListener(this.panel, this.mainPanelCardLayout, "VIEW_CLIENT_VIEW"));
        button4.addActionListener(new ClientQueriesActionListener(this.viewClientView));
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
