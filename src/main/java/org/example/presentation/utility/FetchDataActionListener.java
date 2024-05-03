package org.example.presentation.utility;

import org.example.business.logic.classes.ClientT;
import org.example.data.access.utility.QueryType;
import org.example.model.classes.dto.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FetchDataActionListener implements ActionListener {
    private final ArrayList<JTextField> textFields;
    private QueryType type;

    public FetchDataActionListener(ArrayList<JTextField> textFields, String operationName) {
        this.textFields = textFields;
        switch (operationName) {
            case "EDIT_CLIENT_VIEW":
                this.type = QueryType.UPDATE;
                break;
            case "CREATE_CLIENT_VIEW":
                this.type = QueryType.INSERT;
                break;
            case "DELETE_CLIENT_VIEW":
                this.type = QueryType.DELETE;
                break;
            case "VIEW_CLIENT_VIEW":
                this.type = QueryType.SELECT;
                break;
            default:
                System.out.println("You should not be here");
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClientT cType = getClientT();
//        for (JTextField textField : textFields) {
//            textField.setText("");
//        }
        if (cType != null) {
            System.out.println(cType.toString());
            switch (this.type) {
                case INSERT:
                    int id = cType.convertToDAO().create(cType);
                    break;
                case UPDATE:
                    cType.convertToDAO().update(cType);
                    break;
                case DELETE:
                    cType.convertToDAO().delete(cType);
                    break;
                case SELECT:
                    cType.convertToDAO().read(cType);
                    break;
                default:
                    System.out.println("You should not be here");
                    break;
            }
        }
        else
            System.out.println("null");
    }

    private ClientT getClientT() {
        Client newClient;
        if (textFields.size() == 3) {
            newClient = new Client(textFields.getFirst().getText(),
                    textFields.get(1).getText(),
                    textFields.get(2).getText());
        }
        else if(textFields.size() == 4){
            newClient = new Client(textFields.getFirst().getText(),
                    textFields.get(1).getText(),
                    textFields.get(2).getText(),
                    Integer.parseInt(textFields.get(3).getText()));
        }
        else
            newClient = new Client(Integer.parseInt(textFields.getFirst().getText()));
        return newClient.convertToEntity();
    }
}
