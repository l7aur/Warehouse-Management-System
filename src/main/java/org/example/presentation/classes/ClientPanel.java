package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author L7aur
 */
public class ClientPanel extends JPanel implements View {
    private final String id;

    public ClientPanel() {
        this.id = "CLIENT";
        this.setBackground(Color.blue);
    }

    @Override
    public void createContent() {

    }
    @Override
    public String getId() {
        return this.id;
    }
}
