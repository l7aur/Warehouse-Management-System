package org.example.presentation.classes;

import org.example.business.logic.classes.ClientT;
import org.example.business.logic.classes.ProductT;
import org.example.presentation.utility.Colors;
import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.NavigateActionListener;
import org.example.presentation.utility.OrderUpdatesActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The panel that houses the order view
 * @author L7aur
 */
public class OrderPanel extends AbstractView {
    private final String id;
    private final MainFrame mainFrame;
    private final JPanel selectorPanel;
    private JComboBox<ClientT> clientComboBox;
    private JComboBox<ProductT> productComboBox;
    private JTextField textField;

    private static final String SELECTOR_NAME_1 = "CLIENT";
    private static final String SELECTOR_NAME_2 = "PRODUCT";
    private static final String SELECTOR_NAME_3 = "QUANTITY";

    public OrderPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "ORDER";
        this.selectorPanel = new JPanel();
        this.selectorPanel.setLayout(new BoxLayout(selectorPanel, BoxLayout.Y_AXIS));
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.add(selectorPanel, BorderLayout.PAGE_START);
    }

    private void setSelectorPanels(JPanel panel) {
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(Colors.getInstance().getBackgroundColor());
    }

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

    public void updateContent(ArrayList<ClientT> clients, ArrayList<ProductT> products) {
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

    private <T> JComboBox<T> createSelector(ArrayList<T> list) {
        T[] fields = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            fields[i] = list.get(i);
        }
        return new JComboBox<>(fields);
    }

    private JTextField createTextField(String name) {
        JTextField field = new JTextField();
        JLabel label = new JLabel(name);
        label.setLabelFor(field);
        label.setForeground(Colors.getInstance().getForegroundColor());
        field.setForeground(Colors.getInstance().getForegroundColor());
        field.setBackground(Colors.getInstance().getBackgroundColor());
        return field;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
