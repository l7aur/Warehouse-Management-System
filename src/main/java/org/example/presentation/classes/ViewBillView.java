package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;

import java.awt.*;

public class ViewBillView extends AbstractView {
    private final String id;

    public ViewBillView() {
        this.id = "VIEW_BILL_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
        this.setLayout(new BorderLayout());
    }

    @Override
    public String getId() {
        return this.id;
    }
}
