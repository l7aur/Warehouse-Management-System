package org.example.presentation.classes;

import org.example.presentation.utility.AbstractView;
import org.example.presentation.utility.Colors;

import java.awt.*;

public class CreateBillView extends AbstractView {
    private final String id;

    public CreateBillView() {
        this.id = "CREATE_BILL_VIEW";
        this.setBackground(Colors.getInstance().getBackgroundColor());
    }

    @Override
    public String getId() {
        return id;
    }
}
