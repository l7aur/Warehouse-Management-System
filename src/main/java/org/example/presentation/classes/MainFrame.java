package org.example.presentation.classes;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The application frame where all GUI components are housed.
 * @author L7aur
 */
public class MainFrame extends JFrame {
    private final Container contentPane;
    private final CardLayout layout;
    private ArrayList<String> panels;

    /**
     * Constructor.
     */
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

    /**
     * Initializes the array of panel identifiers.
     */
    public void initializePanelArray() {
        this.panels = new ArrayList<>();
        this.panels.add("START");
        this.panels.add("CLIENT");
        this.panels.add("PRODUCT");
        this.panels.add("ORDER");
        this.panels.add("BILL");
        this.panels.add("BACK");
    }

    /**
     * Adds the panels to the card layout.
     */
    public void addPanels() {

        BillPanel billPanel = new BillPanel(this);
        contentPane.add(billPanel, billPanel.getId());

        OrderPanel orderPanel = new OrderPanel(this);
        contentPane.add(orderPanel, orderPanel.getId());

        ClientPanel clientPanel = new ClientPanel(this);
        contentPane.add(clientPanel, clientPanel.getId());

        ProductPanel productPanel = new ProductPanel(this);
        contentPane.add(productPanel, productPanel.getId());

        StartPanel startPanel = new StartPanel(this);
        contentPane.add(startPanel, startPanel.getId());
    }

    /**
     * Shows the panel specified by the provided identifier.
     * @param index The identifier of the panel.
     */
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
