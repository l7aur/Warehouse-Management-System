package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;
import org.example.presentation.utility.ClientUpdatesActionListener;
import org.example.presentation.utility.MyButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * The create client view.
 * @author L7aur
 */
public class CreateClientView extends AbstractView {

    /**
     * The unique identifier of the view.
     */
    private final String id;

    /**
     * Constructor.
     */
    public CreateClientView() {
        this.id = "CREATE_CLIENT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    /**
     * Creates the GUI of the panel.
     */
    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        String[] textNames = {"Name: ", "Phone Number: ", "Address: "};
        ArrayList<JTextField> textFields = new ArrayList<>();
        this.add(this.createTextFields(textNames, textFields), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE CREATE");
        executeButton.addActionListener(new ClientUpdatesActionListener(textFields, this.getId()));
        this.add(executeButton, BorderLayout.SOUTH);
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
