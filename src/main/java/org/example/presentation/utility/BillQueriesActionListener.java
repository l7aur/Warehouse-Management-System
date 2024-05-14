package org.example.presentation.utility;

import org.example.model.classes.dto.BillT;
import org.example.presentation.classes.ViewBillView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Implementation of the ActionListener interface associated to the read SQL query.
 * @author L7aur
 */
public class BillQueriesActionListener implements ActionListener {
    private final ViewBillView panel;

    /**
     * Constructor.
     * @param view A reference to the panel where the read SQL query results are displayed.
     */
    public BillQueriesActionListener(ViewBillView view) {
        this.panel = view;
    }

    /**
     * Queries the database on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        BillT bType = new BillT();
        ArrayList<Object> list = bType.convertToDAO().read(bType);
        panel.updateContent(list);
    }

}
