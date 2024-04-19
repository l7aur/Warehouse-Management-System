package org.example.presentation.classes;

import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.NavigateActionListener;
import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

/**
 * The panel that houses the client view
 * @author L7aur
 */
public class ClientPanel extends JPanel implements View {
    private final String id;
    private final MainFrame mainFrame;
    public ClientPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setLayout(new BorderLayout());
         this.id = "CLIENT";
        this.setBackground(new Color(32, 42,68));
        this.createContent();
    }

    @Override
    public void createContent() {
        MyButton buttonElement = new MyButton("BACK");
        buttonElement.addActionListener(new NavigateActionListener(this.mainFrame, "BACK"));
        this.add(buttonElement, BorderLayout.PAGE_END);
        this.add(this.createOperationButtons(), BorderLayout.WEST);
        this.add(this.mainPanel(), BorderLayout.CENTER);
    }

    private JPanel mainPanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setBackground(new Color(100, 42,68));
        return panel;
    }

    private JPanel createOperationButtons() {
        JPanel operationButtons = new JPanel();
        operationButtons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        operationButtons.setBackground(new Color(32, 42,68));
        GridLayout layout = new GridLayout(4, 1, 10, 10);
        operationButtons.setLayout(layout);
        MyButton button1 = new MyButton("CREATE CLIENT");
        MyButton button2 = new MyButton("EDIT CLIENT");
        MyButton button3 = new MyButton("DELETE CLIENT");
        MyButton button4 = new MyButton("VIEW CLIENTS");
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
