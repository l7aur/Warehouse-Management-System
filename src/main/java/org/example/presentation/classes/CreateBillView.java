package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.BillUpdatesActionListener;
import org.example.presentation.utility.Colors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class CreateBillView extends AbstractView {
    private final String id;

    public CreateBillView() {
        this.id = "CREATE_BILL_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        String[] textNames = {"Order ID: "};
        ArrayList<JTextField> textFields = new ArrayList<>();
        this.add(this.createTextFields(textNames, textFields), BorderLayout.NORTH);
        Button executeButton = new Button("EXECUTE CREATE");
        executeButton.addActionListener(new BillUpdatesActionListener(textFields));
        this.add(executeButton, BorderLayout.SOUTH);
    }

    @Override
    public String getId() {
        return id;
    }
}
