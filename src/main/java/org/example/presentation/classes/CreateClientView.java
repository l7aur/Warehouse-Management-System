package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

public class CreateClientView extends JPanel implements View {
    private final String id;
    public CreateClientView() {
        this.id = "CREATE_CLIENT_VIEW";
        this.setBackground(Color.red);

    }
    @Override
    public void createContent() {
    }

    @Override
    public String getId() {
        return this.id;
    }
}
