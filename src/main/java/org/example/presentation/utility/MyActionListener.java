package org.example.presentation.utility;

import org.example.presentation.classes.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
    private final MainFrame mainFrame;
    private final String toWhere;
    public MyActionListener(MainFrame mainFrame, String toWhere) {
        this.mainFrame = mainFrame;
        if(toWhere.equals("BACK"))
            this.toWhere = "START";
        else
            this.toWhere = toWhere;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.mainFrame.showPanel(this.toWhere);
    }
}
