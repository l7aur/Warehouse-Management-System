package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;

/**
 *
 * @author L7aur
 */
public class StartPanel extends JPanel implements View {
    private final String id;

    public StartPanel() {
        this.id = "START";
    }

    @Override
    public void createContent() {

    }
    @Override
    public String getId() {
        return this.id;
    }
}
