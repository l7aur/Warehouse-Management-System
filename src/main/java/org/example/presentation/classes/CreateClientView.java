package org.example.presentation.classes;

import org.example.presentation.utility.Colors;
import org.example.presentation.utility.UpdatesActionListener;
import org.example.presentation.utility.MyButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class CreateClientView extends AbstractView {
    private final String id;
    public CreateClientView() {
        this.id = "CREATE_CLIENT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        String[] textNames = {"Name: ", "Phone Number: ", "Address: "};
        ArrayList<JTextField> textFields = new ArrayList<>();
        this.add(this.createTextFields(textNames, textFields), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE CREATE");
        executeButton.addActionListener(new UpdatesActionListener(textFields, this.getId()));
        this.add(executeButton, BorderLayout.SOUTH);
    }

    @Override
    public String getId() {
        return this.id;
    }
}
