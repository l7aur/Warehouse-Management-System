package org.example.presentation.utility;

import org.example.business.logic.classes.Bill;
import org.example.model.classes.dto.BillT;
import org.example.model.classes.dto.ClientT;
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
        BillT bType = getBillT();
        if (bType != null) {
            ArrayList<Object> list = bType.convertToDAO().read();
            panel.updateContent(list);
        }
        else
            System.out.println("null");
    }

    private BillT getBillT() {
        return (new Bill()).convertToEntity();
    }

}
