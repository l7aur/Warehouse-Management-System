package org.example.presentation.classes;

import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ViewClientView extends AbstractView {
    private final String id;

    public ViewClientView() {
        this.id = "VIEW_CLIENT_VIEW";
        this.setBackground(Color.yellow);
//        this.setBackground(new Color(32, 42,68));
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public void createContent() {
        System.out.println("here");
    }

    @Override
    public String getId() {
        return this.id;
    }
}
