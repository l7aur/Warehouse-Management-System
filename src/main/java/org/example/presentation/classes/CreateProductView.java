package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;
import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.ProductUpdatesActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class CreateProductView extends AbstractView {
    private final String id;
    public CreateProductView() {
        this.id = "CREATE_PRODUCT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        ArrayList<JTextField> fields = new ArrayList<>();
        String[] names = {"Name: ", "Stock: ", "Price: "};
        this.add(this.createTextFields(names, fields), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE CREATE");
        executeButton.addActionListener(new ProductUpdatesActionListener(fields, this.getId()));
        this.add(executeButton, BorderLayout.SOUTH);

    }

    @Override
    public String getId() {
        return this.id;
    }
}
