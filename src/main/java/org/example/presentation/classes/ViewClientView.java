package org.example.presentation.classes;

import org.example.model.classes.dto.ClientT;
import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;

import java.awt.*;
import java.util.ArrayList;

public class ViewClientView extends AbstractView {
    private final String id;

    public ViewClientView() {
        this.id = "VIEW_CLIENT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
    }

    @Override
    public String getId() {
        return this.id;
    }
}
