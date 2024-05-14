package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;

import java.awt.*;

/**
 * The delete client view.
 * @author L7aur
 */
public class DeleteClientView extends AbstractView {
    private final String id;

    /**
     * Constructor.
     */
    public DeleteClientView() {
        this.id = "DELETE_CLIENT_VIEW";
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
