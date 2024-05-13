package org.example.presentation.utility;

import org.example.model.classes.dto.BillT;
import org.example.presentation.classes.ViewBillView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BillQueriesActionListener implements ActionListener {
    private final ViewBillView panel;

    public BillQueriesActionListener(ViewBillView view) {
        this.panel = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BillT bType = new BillT();
        ArrayList<Object> list = bType.convertToDAO().read(bType);
        panel.updateContent(list);
    }

}
