package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;
import java.awt.*;

/**
 * The delete product view.
 * @author L7aur
 */
public class DeleteProductView extends AbstractView {
    private final String id;

    /**
     * Constructor.
     */
    public DeleteProductView() {
        this.id = "DELETE_PRODUCT_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
        this.createContent();
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
