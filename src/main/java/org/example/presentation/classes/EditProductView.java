package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;
import org.example.presentation.utility.MyButton;
import org.example.presentation.utility.ProductUpdatesActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * The edit product view.
 * @author L7aur
 */
public class EditProductView extends AbstractView {

    /**
     * The unique identifier of the view.
     */
    private final String id;

    /**
     * Constructor.
     */
    public EditProductView() {
        this.id = "EDIT_PRODUCT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
    }

    /**
     * Creates the GUI of the panel.
     */
    @Override
    public void createContent() {
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
        ArrayList<JTextField> fields = new ArrayList<>();
        String[] names = {"Name: ", "Stock: ", "Price: ", "Id: "};
        this.add(this.createTextFields(names, fields), BorderLayout.NORTH);
        MyButton executeButton = new MyButton("EXECUTE EDIT");
        executeButton.addActionListener(new ProductUpdatesActionListener(fields, this.getId()));
        this.add(executeButton, BorderLayout.SOUTH);
    }

    /**
     * Getter.
     * @return The identifier of the panel.
     */
    @Override
    public String getId() {
        return this.id;
    }
}
