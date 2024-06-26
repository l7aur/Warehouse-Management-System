package org.example.presentation.utility;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract class that implements the view panel model.
 * @author L7aur
 */
public abstract class AbstractView extends JPanel implements View {

    /**
     * Constructor.
     */
    public AbstractView() {}

    /**
     * Creates a number of labeled text fields that are placed in a JPanel.
     * @param names the labels that are going to be used for the text fields.
     * @param textFields empty array list so that some reference to the text fields is stored.
     * @return the JPanel where the above-mentioned are placed.
     */
    protected JPanel createTextFields(String[] names, ArrayList<JTextField> textFields) {
        JPanel panel = new JPanel();
        panel.setBackground(Colors.getInstance().getBackgroundColor());
        panel.setLayout(new GridLayout(names.length, 1, 5,5));
        for (String name : names) {
            JLabel nameLabel = new JLabel(name);
            JTextField nameField = new JTextField();
            textFields.add(nameField);
            nameLabel.setLabelFor(nameField);
            if(name.equals("Id: ") || name.equals("Order ID: "))
                nameLabel.setForeground(Colors.getInstance().getHighlightColor());
            else
                nameLabel.setForeground(Colors.getInstance().getForegroundColor());
            panel.add(nameLabel);
            panel.add(nameField);
        }
        return panel;
    }

    /**
     * The method of the abstract class creates the content of the delete view for
     * the Client and Product Views.
     */
    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        ArrayList<JTextField> fields = new ArrayList<>();
        String[] names = {"Id: "};
        this.add(this.createTextFields(names, fields), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE DELETE");
        if(this.getId().equals("DELETE_CLIENT_VIEW"))
            executeButton.addActionListener(new ClientUpdatesActionListener(fields, this.getId()));
        else //DELETE_PRODUCT_VIEW
            executeButton.addActionListener(new ProductUpdatesActionListener(fields, this.getId()));
        this.add(executeButton, BorderLayout.SOUTH);
    }

    /**
     * Getter.
     * @return The identifier of the View.
     */
    @Override
    public String getId() {
        return "ABSTRACT";
    }

    /**
     * Creates and adds a JScrollPane to the current object. Used for the OrderPanel View.
     * @param data Matrix that stores the data that is going to fill the table in String format.
     * @param columns The name of the columns.
     */
    protected void addScrollPane(String[][] data, String[] columns) {
        JTable table = constructTable(data, columns);
        table.getTableHeader().setBackground(Colors.getInstance().getBackgroundColor());
        table.getTableHeader().setForeground(Colors.getInstance().getForegroundColor());
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.getViewport().setBackground(Colors.getInstance().getBackgroundColor());
        this.add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Refreshes the content of a table inside a view type view.
     * @param objects The array of objects that represent the entries in the table.
     */
    public void updateContent(List<Object> objects) {
        if (objects == null)
            return;
        this.removeAll();
        String[] columns = getTableHeader(objects.getFirst());
        String[][] data = getTableEntries(objects, columns.length);
        addScrollPane(data, columns);
    }

    /**
     * Converts a list of objects into a matrix of strings representing the table entries.
     * @param objects The array of objects.
     * @param cols The name of the columns.
     * @return A matrix of strings where a row represents an entry in the table.
     */
    private static String[][] getTableEntries(List<Object> objects, int cols) {
        String[][] data = new String[objects.size()][cols];
        for (int i = 0; i < objects.size(); i++) {
            Class<?> clazz = objects.getFirst().getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                try {
                    data[i][j] = fields[j].get(objects.get(i)).toString();
                }
                catch (IllegalAccessException e) {
                    Logger.getLogger(AbstractView.class.getSimpleName()).log(Level.WARNING, "ILLEGAL ACCESS", e);
                }
            }
        }
        return data;
    }

    /**
     * Generates through reflection the names of the columns of the table.
     * @param object The abstract data object whose field names will become the header of the table.
     * @return An array of strings representing the header of the table.
     */
    private static String[] getTableHeader(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[] columns = new String[fields.length];
        for(int i = 0; i < fields.length; i++) {
            columns[i] = fields[i].getName();
        }
        return columns;
    }

    /**
     * Constructs a JTable with non-editable cells.
     * @param data A matrix of strings where a row represents a table entry.
     * @param columns An array of strings representing the names of the columns.
     * @return A table with the above-mentioned characteristics.
     */
    private JTable constructTable(String[][] data, String[] columns) {
        JTable table = new JTable(data, columns);
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
