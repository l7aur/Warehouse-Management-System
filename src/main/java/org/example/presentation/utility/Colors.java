package org.example.presentation.utility;

import java.awt.*;

public class Colors {
    private static final Color backgroundColor = new Color(32, 42,68);
    private static final Color foregroundColor = Color.white;
    private static final Color selectionColor = new Color(137, 143, 16);
    private static final Color highlightColor = Color.red;

    private static final Colors colorInstance = new Colors();

    private Colors() {

    }

    public static Colors getInstance() {
        return colorInstance;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public Color getHighlightColor() {
        return highlightColor;
    }

    public Color getSelectionColor() {
        return selectionColor;
    }
}
