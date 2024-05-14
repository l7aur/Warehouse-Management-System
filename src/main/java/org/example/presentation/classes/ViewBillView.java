package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;

import java.awt.*;

/**
 * The view bill view.
 * @author L7aur
 */
public class ViewBillView extends AbstractView {
    private final String id;

    /**
     * Constructor.
     */
    public ViewBillView() {
        this.id = "VIEW_BILL_VIEW";
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
