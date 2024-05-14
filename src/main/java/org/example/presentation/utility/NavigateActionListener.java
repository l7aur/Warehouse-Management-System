package org.example.presentation.utility;

import org.example.presentation.classes.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implementation of the ActionListener interface associated to the navigation through the main panels of the GUI.
 * @author L7aur
 */
public class NavigateActionListener implements ActionListener {

    /**
     * The main frame of the application reference.
     */
    private final MainFrame mainFrame;

    /**
     * The current panel reference.
     */
    private final JPanel currentPanel;

    /**
     * The target panel unique identifier.
     */
    private final String toWhere;

    /**
     * Constructor.
     * @param mainFrame The frame of the application.
     * @param toWhere The id of the panel we are going to.
     * @param currentPanel The panel we are currently seeing.
     */
    public NavigateActionListener(MainFrame mainFrame, String toWhere, JPanel currentPanel) {
        this.mainFrame = mainFrame;
        this.currentPanel = currentPanel;
        if(toWhere.equals("BACK"))
            this.toWhere = "START";
        else
            this.toWhere = toWhere;
    }

    /**
     * Constructor.
     * @param mainFrame The frame of the application.
     * @param toWhere The id of the panel we are going to.
     */
    public NavigateActionListener(MainFrame mainFrame, String toWhere) {
        this.mainFrame = mainFrame;
        this.currentPanel = null;
        if(toWhere.equals("BACK"))
            this.toWhere = "START";
        else
            this.toWhere = toWhere;
    }

    /**
     * Changes the panel that is displayed on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.mainFrame.showPanel(this.toWhere);
        if (this.currentPanel != null) {
            CardLayout layout = (CardLayout) this.currentPanel.getLayout();
            layout.first(this.currentPanel);
        }
    }
}
