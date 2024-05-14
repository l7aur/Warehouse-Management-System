package org.example.presentation.utility;

import java.awt.*;

/**
 * Singleton implementation of the colour palette of the application.
 * Instantiates the colors that are used throughout the whole GUI for easier management.
 * @author L7aur
 */
public class Colors {
    private static final Color backgroundColor = new Color(32, 42,68);
    private static final Color foregroundColor = Color.white;
    private static final Color selectionColor = new Color(137, 143, 16);
    private static final Color highlightColor = Color.red;

    private static final Colors colorInstance = new Colors();

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static Colors getInstance() {
        return colorInstance;
    }

    /**
     * Getter.
     * @return The background color.
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Getter.
     * @return The foreground color.
     */
    public Color getForegroundColor() {
        return foregroundColor;
    }

    /**
     * Getter.
     * @return The color used for highlighting.
     */
    public Color getHighlightColor() {
        return highlightColor;
    }

    /**
     * Getter.
     * @return The color used for selecting.
     */
    public Color getSelectionColor() {
        return selectionColor;
    }
}
