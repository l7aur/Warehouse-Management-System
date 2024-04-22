package org.example.presentation.classes;

import org.example.presentation.utility.View;

import javax.swing.*;
import java.awt.*;

public class DeleteClientView extends JPanel implements View {
    private final String id;
    public DeleteClientView() {
        this.id = "DELETE_CLIENT_VIEW";
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
