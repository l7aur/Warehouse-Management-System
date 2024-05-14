package org.example.presentation.utility;

import org.example.model.classes.dto.ClientT;
import org.example.business.logic.classes.Client;
import org.example.presentation.classes.ViewClientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Implementation of the ActionListener interface associated to the read SQL query.
 * @author L7aur
 */
public class ClientQueriesActionListener implements ActionListener {

    /**
     * The view client view reference.
     */
    private final ViewClientView panel;

    /**
     * Constructor.
     * @param panel A reference to the panel where the read SQL query results are displayed.
     */
    public ClientQueriesActionListener(ViewClientView panel) {
        this.panel = panel;
    }

    /**
     * Queries the database on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ClientT cType = getClientT();
        if (cType != null) {
            ArrayList<Object> list = cType.convertToDAO().read(cType);
            panel.updateContent(list);
        }
        else
            System.out.println("NULL PRODUCT OBJECT WHEN BUTTON PRESSED!");
    }

    /**
     * Creates an instance of a client data transfer object.
     * @return A new instance of the client data transfer object.
     */
    private ClientT getClientT() {
        return (new Client()).convertToEntity();
    }
}
