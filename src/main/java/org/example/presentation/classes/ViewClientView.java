package org.example.presentation.classes;

import org.example.business.logic.classes.ClientT;
import org.example.presentation.utility.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ViewClientView extends AbstractView {
    private final String id;

    public ViewClientView() {
        this.id = "VIEW_CLIENT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    public void updateContent(ArrayList<ClientT> clients) {
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
        JTable table = new JTable(data, columns);
        table.setName("CLIENTS");
        table.setBorder(new EmptyBorder(10, 10, 10, 10));

        table.setBackground(Colors.getInstance().getBackgroundColor());
        table.setSelectionBackground(Colors.getInstance().getForegroundColor());
        table.setForeground(Colors.getInstance().getForegroundColor());

        table.getTableHeader().setBackground(Colors.getInstance().getBackgroundColor());
        table.getTableHeader().setForeground(Colors.getInstance().getForegroundColor());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Colors.getInstance().getBackgroundColor());

        this.add(scrollPane, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
