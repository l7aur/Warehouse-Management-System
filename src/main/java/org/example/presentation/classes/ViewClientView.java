package org.example.presentation.classes;

import org.example.business.logic.classes.ClientT;
import org.example.presentation.utility.Colors;

import java.awt.*;
import java.util.ArrayList;

public class ViewClientView extends AbstractView {
    private final String id;

    public ViewClientView() {
        this.id = "VIEW_CLIENT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
    }

    public void updateContent(ArrayList<ClientT> clients) {
        if(clients != null) {
            this.removeAll();
            String[][] data = new String[clients.size()][4];
            String[] columns = {"Name", "Address", "Phone Number", "Id"};
            int i = 0;
            for (ClientT client : clients) {
                data[i][0] = client.getName();
                data[i][1] = client.getAddress();
                data[i][2] = client.getPhoneNumber();
                data[i][3] = client.getId().toString();
                i++;
            }
            addScrollPane(data, columns, "CLIENTS");
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
