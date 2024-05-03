package org.example.presentation.utility;

import org.example.business.logic.classes.ClientT;
import org.example.data.access.classes.AbstractDAO;
import org.example.data.access.classes.ClientDAO;
import org.example.model.classes.dto.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FetchDataActionListener implements ActionListener {
    private final ArrayList<JTextField> textFields;

    public FetchDataActionListener(ArrayList<JTextField> textFields) {
        this.textFields = textFields;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Client newClient = new Client(textFields.getFirst().getText(),
                textFields.get(1).getText(),
                textFields.get(2).getText());
        ClientT cType = newClient.convertToEntity();
//        for (JTextField textField : textFields) {
//            textField.setText("");
//        }
        System.out.println(cType.toString());
        int id = cType.convertToDAO().create(cType);
        System.out.println("ID: " + id);
    }
}
