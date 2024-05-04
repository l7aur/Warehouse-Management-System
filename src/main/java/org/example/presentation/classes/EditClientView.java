package org.example.presentation.classes;

import org.example.presentation.utility.Colors;
import org.example.presentation.utility.ClientUpdatesActionListener;
import org.example.presentation.utility.MyButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class EditClientView extends AbstractView {
    private final String id;
    public EditClientView() {
        this.id = "EDIT_CLIENT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        String[] textNames = {"Name: ", "Phone Number: ", "Address:", "Id: "};
        ArrayList<JTextField> textFields = new ArrayList<>();
        this.add(this.createTextFields(textNames, textFields), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE EDIT");
        executeButton.addActionListener(new ClientUpdatesActionListener(textFields, this.getId()));
        this.add(executeButton, BorderLayout.SOUTH);
    }

    @Override
    public String getId() {
        return this.id;
    }
}
