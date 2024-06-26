package org.example.presentation.classes;

import org.example.model.classes.dto.ClientT;
import org.example.model.classes.dto.ProductT;
import org.example.presentation.utility.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The order panel.
 * @author L7aur
 */
public class OrderPanel extends AbstractView {

    /**
     * The unique identifier of the view.
     */
    private final String id;

    /**
     * The main frame of the application reference.
     */
    private final MainFrame mainFrame;

    /**
     * The selector panel reference.
     */
    private final JPanel selectorPanel;

    /**
     * The client selector reference.
     */
    private JComboBox<ClientT> clientComboBox;

    /**
     * The product selector reference.
     */
    private JComboBox<ProductT> productComboBox;

    /**
     * The text field reference.
     */
    private JTextField textField;

    /**
     * The name of the first selector.
     */
    private static final String SELECTOR_NAME_1 = "CLIENT";

    /**
     * The name of the second selector.
     */
    private static final String SELECTOR_NAME_2 = "PRODUCT";

    /**
     * The name of the selector.
     */
    private static final String SELECTOR_NAME_3 = "QUANTITY";

    /**
     * Constructor.
     * @param mainFrame The main frame of the application.
     */
    public OrderPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "ORDER";
        this.selectorPanel = new JPanel();
        this.selectorPanel.setLayout(new BoxLayout(selectorPanel, BoxLayout.Y_AXIS));
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.add(selectorPanel, BorderLayout.PAGE_START);
    }

    /**
     * Creates the selectors inside a panel.
     * @param panel The panel that houses the selectors.
     */
    private void setSelectorPanels(JPanel panel) {
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(Colors.getInstance().getBackgroundColor());
    }

    /**
     * Creates a panel that contains the GUI selector elements.
     * @return The panel that houses the selectors.
     */
    private JPanel createButtonMenu() {
        JPanel panel = new JPanel();
        panel.setBackground(Colors.getInstance().getBackgroundColor());
        MyButton backButton = new MyButton("BACK");
        backButton.addActionListener(new NavigateActionListener(this.mainFrame, "BACK"));
        MyButton placeOrderButton = new MyButton("PLACE ORDER");
        placeOrderButton.addActionListener(new OrderUpdatesActionListener(this.textField, this.clientComboBox,
                this.productComboBox, "INSERT"));
        panel.add(placeOrderButton);
        panel.add(backButton);
        return panel;
    }

    /**
     * Fetches the contents of the selectors and sets them in the order panel.
     * @param clients The array of clients that populate the selector.
     * @param products The array of products that populate the selector.
     */
    public void updateContent(ArrayList<Object> clients, ArrayList<Object> products) {
        JPanel selectorPanel1 = new JPanel();
        JPanel selectorPanel2 = new JPanel();
        JPanel selectorPanel3 = new JPanel();
        this.setSelectorPanels(selectorPanel1);
        this.setSelectorPanels(selectorPanel2);
        this.setSelectorPanels(selectorPanel3);

        JLabel label1 = new JLabel(SELECTOR_NAME_1);
        JLabel label2 = new JLabel(SELECTOR_NAME_2);
        JLabel label3 = new JLabel(SELECTOR_NAME_3);
        label1.setForeground(Colors.getInstance().getForegroundColor());
        label2.setForeground(Colors.getInstance().getForegroundColor());
        label3.setForeground(Colors.getInstance().getForegroundColor());

        selectorPanel1.add(label1);
        selectorPanel2.add(label2);
        selectorPanel3.add(label3);

        this.clientComboBox = this.createSelector(clients);
        this.productComboBox = this.createSelector(products);
        this.textField = this.createTextField(SELECTOR_NAME_3);

        selectorPanel1.add(this.clientComboBox);
        selectorPanel2.add(this.productComboBox);
        selectorPanel3.add(this.textField);

        this.selectorPanel.removeAll();
        this.selectorPanel.add(selectorPanel1);
        this.selectorPanel.add(selectorPanel2);
        this.selectorPanel.add(selectorPanel3);

        this.add(this.createButtonMenu(), BorderLayout.PAGE_END);

        this.revalidate();
        this.repaint();
    }

    /**
     * Generic method that creates a selector based on reflection.
     * @param list The list of objects that are going to populate the selector.
     * @return A selector object.
     * @param <T> The data type the selector has to work with.
     */
    private <T> JComboBox<T> createSelector(ArrayList<Object> list) {
        Class<?> clazz = list.getFirst().getClass();
        switch (clazz.getSimpleName()) {
            case "ClientT":
                ClientT[] fields = new ClientT[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    fields[i] = (ClientT) list.get(i);
                }
                return (JComboBox<T>) new JComboBox<>(fields);
            case "ProductT":
                ProductT[] fields1 = new ProductT[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    fields1[i] = (ProductT) list.get(i);
                }
                return (JComboBox<T>) new JComboBox<>(fields1);
            default:
                System.out.println("Why are you here??");
        }
        return null;
    }

    /**
     * Creates a text field with a label.
     * @param name The label of the text field.
     * @return The reference to the created text field.
     */
    private JTextField createTextField(String name) {
        JTextField field = new JTextField();
        JLabel label = new JLabel(name);
        label.setLabelFor(field);
        label.setForeground(Colors.getInstance().getForegroundColor());
        field.setForeground(Colors.getInstance().getForegroundColor());
        field.setBackground(Colors.getInstance().getBackgroundColor());
        return field;
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
