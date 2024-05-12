package org.example.presentation.utility;

import org.example.Main;
import org.example.presentation.classes.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action listener that keeps track of what panel is displayed
 * @author L7aur
 */
public class NavigateActionListener implements ActionListener {
    private final MainFrame mainFrame;
    private final JPanel currentPanel;
    private final String toWhere;

    public NavigateActionListener(MainFrame mainFrame, String toWhere, JPanel currentPanel) {
        this.mainFrame = mainFrame;
        this.currentPanel = currentPanel;
        if(toWhere.equals("BACK"))
            this.toWhere = "START";
        else
            this.toWhere = toWhere;
    }

    public NavigateActionListener(MainFrame mainFrame, String toWhere) {
        this.mainFrame = mainFrame;
        this.currentPanel = null;
        if(toWhere.equals("BACK"))
            this.toWhere = "START";
        else
            this.toWhere = toWhere;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.mainFrame.showPanel(this.toWhere);
        if (this.currentPanel != null) {
            CardLayout layout = (CardLayout) this.currentPanel.getLayout();
            layout.first(this.currentPanel);
        }
    }
}
