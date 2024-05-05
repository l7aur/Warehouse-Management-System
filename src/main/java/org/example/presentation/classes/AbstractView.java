package org.example.presentation.classes;

import org.example.presentation.utility.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractView extends JPanel implements View {
    protected JPanel createTextFields(String[] names, ArrayList<JTextField> textFields) {
        JPanel panel = new JPanel();
        panel.setBackground(Colors.getInstance().getBackgroundColor());
        panel.setLayout(new GridLayout(names.length, 1, 5,5));
        for (String name : names) {
            JLabel nameLabel = new JLabel(name);
            JTextField nameField = new JTextField();
            textFields.add(nameField);
            nameLabel.setLabelFor(nameField);
            if(name.equals("Id: "))
                nameLabel.setForeground(Colors.getInstance().getHighlightColor());
            else
                nameLabel.setForeground(Colors.getInstance().getForegroundColor());
            panel.add(nameLabel);
            panel.add(nameField);
        }
        return panel;
    }

    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        ArrayList<JTextField> fields = new ArrayList<>();
        String[] names = {"Id: "};
        this.add(this.createTextFields(names, fields), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE DELETE");
        if(this.getId().equals("DELETE_CLIENT_VIEW"))
            executeButton.addActionListener(new ClientUpdatesActionListener(fields, this.getId()));
        else
            executeButton.addActionListener(new ProductUpdatesActionListener(fields, this.getId()));
        this.add(executeButton, BorderLayout.SOUTH);
    }

    @Override
    public String getId() {
        return "";
    }

    protected void addScrollPane(String[][] data, String[] columns, String tableName) {
        JTable table = constructTable(data, columns, tableName);
        table.getTableHeader().setBackground(Colors.getInstance().getBackgroundColor());
        table.getTableHeader().setForeground(Colors.getInstance().getForegroundColor());
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Colors.getInstance().getBackgroundColor());
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private static JTable constructTable(String[][] data, String[] columns, String tableName) {
        JTable table = new JTable(data, columns);
        table.setName(tableName);
        table.setModel(new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        table.setBorder(new EmptyBorder(10, 10, 10, 10));
        table.setBackground(Colors.getInstance().getBackgroundColor());
        table.setSelectionBackground(Colors.getInstance().getSelectionColor());
        table.setForeground(Colors.getInstance().getForegroundColor());
        return table;
    }

}
