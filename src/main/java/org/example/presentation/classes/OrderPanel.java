package org.example.presentation.classes;

import org.example.business.logic.classes.ClientT;
import org.example.business.logic.classes.ProductT;
import org.example.presentation.utility.Colors;
import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.NavigateActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.function.Function;

/**
 * The panel that houses the order view
 * @author L7aur
 */
public class OrderPanel extends AbstractView {
    private final String id;
    private final MainFrame mainFrame;
    private final JPanel selectorPanel;
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
        this.createContent();
    }

    @Override
    public void createContent() {
        this.add(selectorPanel, BorderLayout.PAGE_START);
        this.add(this.createButtonMenu(), BorderLayout.PAGE_END);
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

        selectorPanel1.add(this.createSelector(clients, ClientT::getName));
        selectorPanel2.add(this.createSelector(products, ProductT::getName));
        selectorPanel3.add(this.createTextField(SELECTOR_NAME_3));

        this.selectorPanel.removeAll();
        this.selectorPanel.add(selectorPanel1);
        this.selectorPanel.add(selectorPanel2);
        this.selectorPanel.add(selectorPanel3);

        this.revalidate();
        this.repaint();
    }

    private <T> JComboBox<String> createSelector(ArrayList<T> list, Function<T, String> getName) {
        String[] fields = new String[list.size() + 1];
        fields[0] = "---";
        for (int i = 0; i < list.size(); i++) {
            fields[i + 1] = getName.apply(list.get(i));
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
