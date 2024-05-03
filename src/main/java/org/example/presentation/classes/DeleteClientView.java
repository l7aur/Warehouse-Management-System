package org.example.presentation.classes;

import java.awt.*;

public class DeleteClientView extends AbstractView {
    private final String id;
    public DeleteClientView() {
        this.id = "DELETE_CLIENT_VIEW";
        this.setBackground(new Color(32, 42,68));
        this.setLayout(new BorderLayout());
        this.createContent("DELETE");
    }

    @Override
    public String getId() {
        return this.id;
    }
}
