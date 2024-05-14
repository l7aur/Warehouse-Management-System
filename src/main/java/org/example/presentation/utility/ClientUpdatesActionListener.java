package org.example.presentation.utility;

import org.example.model.classes.dto.ClientT;
import org.example.data.access.utility.QueryType;
import org.example.business.logic.classes.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Implementation of the ActionListener interface associated to the creation, update and deletion in the client panel.
 * @author L7aur
 */
public class ClientUpdatesActionListener implements ActionListener {

    /**
     * The array of text fields reference.
     */
    private final ArrayList<JTextField> textFields;

    /**
     * The query type.
     */
    private QueryType type;

    /**
     * Constructor.
     * @param textFields An array of references to the text fields that are displayed in the GUI.
     * @param operationName The name of the operation that should be executed.
     */
    public ClientUpdatesActionListener(ArrayList<JTextField> textFields, String operationName) {
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
            default:
                System.out.println("You should not be here!!!");
                break;
        }
    }

    /**
     * Queries the database on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ClientT cType = getClientT();
        for (JTextField textField : textFields) {
            textField.setText("");
        }
        if (cType != null) {
            switch (this.type) {
                case INSERT:
                    cType.convertToDAO().create(cType);
                    break;
                case UPDATE:
                    cType.convertToDAO().update(cType);
                    break;
                case DELETE:
                    cType.convertToDAO().delete(cType);
                    break;
                default:
                    System.out.println("You should not be here!!!!");
                    break;
            }
        }
        else
            System.out.println("Client is null");
    }

    /**
     * Creates a client data transfer object based on how many fields are in the GUI view.
     * @return The client data transfer object.
     */
    private ClientT getClientT() {
        Client newClient;
        if(textFields == null)
            return (new Client()).convertToEntity();
        if (textFields.size() == 3) {
            newClient = new Client(textFields.getFirst().getText(),
                    textFields.get(1).getText(),
                    textFields.get(2).getText());
        }
        else if(textFields.size() == 4){
            newClient = new Client(textFields.getFirst().getText(),
                    textFields.get(1).getText(),
                    textFields.get(2).getText(),
                    textFields.get(3).getText());
        }
        else
            newClient = new Client(textFields.getFirst().getText());
        return newClient.convertToEntity();
    }
}
