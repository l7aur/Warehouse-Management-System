package org.example.presentation.classes;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author L7aur
 */
public class MainFrame extends JFrame {
    private final Container contentPane;
    private final CardLayout layout;
    private ArrayList<String> panels;

    public MainFrame() {
        super("Warehouse Orders Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(screenSize.width / 4, screenSize.height / 4, screenSize.width / 2, screenSize.height / 2);
        this.contentPane = this.getContentPane();
        this.layout = new CardLayout();
        contentPane.setLayout(this.layout);
        this.initializePanelArray();
        this.addPanels();
        this.showPanel("START");
        this.setVisible(true);
    }

    public void initializePanelArray() {
        this.panels = new ArrayList<>();
        this.panels.add("START");
        this.panels.add("CLIENT");
        this.panels.add("PRODUCT");
        this.panels.add("ORDER");
        this.panels.add("BACK");
    }
    public void addPanels() {
        OrderPanel orderPanel = new OrderPanel(this);
        ClientPanel clientPanel = new ClientPanel(this);
        ProductPanel productPanel = new ProductPanel(this);
        StartPanel startPanel = new StartPanel(this);
        contentPane.add(startPanel, startPanel.getId());
        contentPane.add(clientPanel, clientPanel.getId());
        contentPane.add(productPanel, productPanel.getId());
        contentPane.add(orderPanel, orderPanel.getId());
    }

    public void showPanel(String index) {
        boolean exists = false;
        for (String string : panels) {
            if(string.equals(index)) {
                exists = true;
                break;
            }
        }
        if(!exists) {
            System.out.println("<ERROR> PANEL NOT FOUND");
            System.exit(-1);
        }
        this.layout.show(this.contentPane, index);
    }
}
