package org.example.presentation.utility;

import org.example.model.classes.dto.ClientT;
import org.example.business.logic.classes.Client;
import org.example.presentation.classes.ViewClientView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientQueriesActionListener implements ActionListener {
    private final ViewClientView panel;
    public ClientQueriesActionListener(ViewClientView panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClientT cType = getClientT();
        if (cType != null) {
            ArrayList<Object> list = cType.convertToDAO().read(cType);
            panel.updateContent(list);
        }
        else
            System.out.println("null");
    }

    private ClientT getClientT() {
        return (new Client()).convertToEntity();
    }
}
