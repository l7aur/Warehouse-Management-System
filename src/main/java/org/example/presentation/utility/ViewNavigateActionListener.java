package org.example.presentation.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implementation of the ActionListener interface associated to the navigation through the specific input views of a panel.
 * @author L7aur
 */
public class ViewNavigateActionListener implements ActionListener {
    private final JPanel panel;
    private final CardLayout layout;
    private final String toWhere;

    /**
     * Constructor.
     * @param panel The parent container.
     * @param layout The CardLayout housed by the main frame.
     * @param toWhere The id of the view to which we are going.
     */
    public ViewNavigateActionListener(JPanel panel, CardLayout layout, String toWhere) {
        this.panel = panel;
        this.layout = layout;
        this.toWhere = toWhere;
    }

    /**
     * Changes the view on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.layout.show(this.panel, this.toWhere);
    }
}
