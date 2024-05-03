package org.example.presentation.classes;

import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public abstract class AbstractView extends JPanel implements View {
    protected JPanel createTextFields(String[] names) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(32, 42,68));
        panel.setLayout(new GridLayout(names.length, 1, 5,5));
        for (String name : names) {
            JLabel nameLabel = new JLabel(name);
            JTextField nameField = new JTextField();
            nameLabel.setLabelFor(nameField);
            nameLabel.setForeground(Color.WHITE);
            panel.add(nameLabel);
            panel.add(nameField);
        }
        return panel;
    }

    @Override
    public void createContent(){};

    public void createContent(String operationName) {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        String[] textNames = {"Name", "Phone number", "Address", "Id"};
        this.add(this.createTextFields(textNames), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE " + operationName);
        this.add(executeButton, BorderLayout.SOUTH);
    }

    @Override
    public String getId() {
        return "";
    }
}
