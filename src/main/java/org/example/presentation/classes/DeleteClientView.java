package org.example.presentation.classes;

import org.example.presentation.utility.Colors;

import java.awt.*;

public class DeleteClientView extends AbstractView {
    private final String id;
    public DeleteClientView() {
        this.id = "DELETE_CLIENT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
