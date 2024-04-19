package org.example.presentation.classes;

import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.NavigateActionListener;
import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author L7aur
 */
public class OrderPanel extends JPanel implements View {
    private final String id;
    private final MainFrame mainFrame;
    public OrderPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.id = "ORDER";
        this.setBackground(new Color(32, 42,68));
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public void createContent() {
        this.add(this.createSelectors(), BorderLayout.PAGE_START);
        this.add(this.createButtonMenu(), BorderLayout.PAGE_END);
    }

    private JPanel createButtonMenu() {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(32, 42,68));
        MyButton backButton = new MyButton("BACK");
        backButton.addActionListener(new NavigateActionListener(this.mainFrame, "BACK"));
        MyButton placeOrderButton = new MyButton("PLACE ORDER");
        panel.add(placeOrderButton);
        panel.add(backButton);
        return panel;
    }

    private JPanel createSelectors() {
        JPanel selectorPanel = new JPanel();
        selectorPanel.setBackground(new Color(32, 42,68));
        selectorPanel.add(this.createSelectorType("CLIENTS"));
        selectorPanel.add(this.createSelectorType("PRODUCTS"));
        selectorPanel.add(this.createSelectorType("QUANTITY"));
        return selectorPanel;
    }

    private JPanel createSelectorType(String selectorName) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(2, 1));
        panel.setBackground(new Color(32, 42,68));
        String[] fields = {"aaa", "bbb", "ccc", "ddd"};
        JLabel label1 = new JLabel(selectorName);
        label1.setForeground(new Color(255, 255,255));
        JComboBox<String> comboBox1 = new JComboBox<>(fields);
        panel.add(label1);
        panel.add(comboBox1);
        return panel;

    }

    @Override
    public String getId() {
        return this.id;
    }
}
