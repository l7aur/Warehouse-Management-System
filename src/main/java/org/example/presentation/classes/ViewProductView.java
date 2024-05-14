package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;

import java.awt.*;

/**
 * The view product view.
 * @author L7aur
 */
public class ViewProductView extends AbstractView {

    /**
     * The unique identifier of the view.
     */
    private final String id;

    /**
     * Constructor.
     */
    public ViewProductView() {
        this.id = "VIEW_PRODUCT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
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
