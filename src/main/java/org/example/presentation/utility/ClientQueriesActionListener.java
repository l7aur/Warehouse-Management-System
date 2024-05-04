package org.example.presentation.utility;

import org.example.business.logic.classes.ClientT;
import org.example.model.classes.dto.Client;
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
            System.out.println(cType);
            ArrayList<ClientT> list = cType.convertToDAO().read();
            panel.updateContent(list);
        }
        else
            System.out.println("null");
    }

    private ClientT getClientT() {
        return (new Client()).convertToEntity();
    }
}
