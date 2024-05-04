package org.example.presentation.classes;

import org.example.presentation.utility.*;

import javax.swing.*;
import java.awt.*;

/**
 * The panel that houses the client view
 * @author L7aur
 */
public class ClientPanel extends JPanel {
    private final String id;
    private final MainFrame mainFrame;
    private JPanel panel;
    private CardLayout mainPanelCardLayout;
    private ViewClientView viewClientView;

    public ClientPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.setLayout(new BorderLayout());
        this.id = "CLIENT";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.createContent();
    }

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
        button4.addActionListener(new QueriesActionListener(this.viewClientView));
        operationButtons.add(button1);
        operationButtons.add(button2);
        operationButtons.add(button3);
        operationButtons.add(button4);
        return operationButtons;
    }

    public String getId() {
        return this.id;
    }
}
