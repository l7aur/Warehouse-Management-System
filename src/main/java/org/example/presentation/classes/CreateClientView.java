package org.example.presentation.classes;

import org.example.presentation.utility.MyButton;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CreateClientView extends AbstractView {
    private final String id;
    public CreateClientView() {
        this.id = "CREATE_CLIENT_VIEW";
        this.setBackground(new Color(32, 42,68));
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        String[] textNames = {"Name", "Phone number", "Address"};
        this.add(this.createTextFields(textNames), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE CREATE" );
        this.add(executeButton, BorderLayout.SOUTH);
    }

//    private JPanel createTextFields(String[] names) {
//        JPanel panel = new JPanel();
//        panel.setBackground(new Color(32, 42,68));
//        panel.setLayout(new GridLayout(names.length, 1, 5,5));
//        for (String name : names) {
//            JLabel nameLabel = new JLabel(name);
//            JTextField nameField = new JTextField();
//            nameLabel.setLabelFor(nameField);
//            nameLabel.setForeground(Color.WHITE);
//            panel.add(nameLabel);
//            panel.add(nameField);
//        }
//        return panel;
//    }

    @Override
    public String getId() {
        return this.id;
    }
}
