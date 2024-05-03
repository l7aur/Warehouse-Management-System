package org.example.presentation.classes;

import java.awt.*;

public class EditClientView extends AbstractView {
    private final String id;
    public EditClientView() {
        this.id = "EDIT_CLIENT_VIEW";
        this.setBackground(new Color(32, 42,68));
        this.setLayout(new BorderLayout());
        this.createContent("EDIT");
    }

    @Override
    public String getId() {
        return this.id;
    }
}
