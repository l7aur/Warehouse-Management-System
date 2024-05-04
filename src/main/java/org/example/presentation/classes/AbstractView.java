package org.example.presentation.classes;

import org.example.business.logic.classes.ClientT;
import org.example.presentation.utility.Colors;
import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public abstract class AbstractView extends JPanel implements View {
    protected JPanel createTextFields(String[] names, ArrayList<JTextField> textFields) {
        JPanel panel = new JPanel();
        panel.setBackground(Colors.getInstance().getBackgroundColor());
        panel.setLayout(new GridLayout(names.length, 1, 5,5));
        for (String name : names) {
            JLabel nameLabel = new JLabel(name);
            JTextField nameField = new JTextField();
            textFields.add(nameField);
            nameLabel.setLabelFor(nameField);
            if(name.equals("Id: "))
                nameLabel.setForeground(Colors.getInstance().getHighlightColor());
            else
                nameLabel.setForeground(Colors.getInstance().getForegroundColor());
            panel.add(nameLabel);
            panel.add(nameField);
        }
        return panel;
    }

    @Override
    public void createContent(){};

    @Override
    public String getId() {
        return "";
    }

//    protected void updateContent(ArrayList<Objects> objects) {
//
//    }
}
