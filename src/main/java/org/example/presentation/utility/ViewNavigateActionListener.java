package org.example.presentation.utility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewNavigateActionListener implements ActionListener {
    private final JPanel panel;
    private final CardLayout layout;
    private final String toWhere;
    public ViewNavigateActionListener(JPanel panel, CardLayout layout, String toWhere) {
        this.panel = panel;
        this.layout = layout;
        this.toWhere = toWhere;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.layout.show(this.panel, this.toWhere);
    }
}
