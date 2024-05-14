package org.example.presentation.utility;

import java.awt.*;

/**
 * Singleton implementation of the colour palette of the application.
 * Instantiates the colors that are used throughout the whole GUI for easier management.
 * @author L7aur
 */
public class Colors {

    /**
     * The background color of the whole application.
     */
    private static final Color backgroundColor = new Color(32, 42,68);

    /**
     * The text color of some special GUI elements such as tables or labels.
     */
    private static final Color foregroundColor = Color.white;

    /**
     * The selection color of some special GUI elements such as tables.
     */
    private static final Color selectionColor = new Color(137, 143, 16);

    /**
     * The highlight color of some special GUI elements such as important/key labels.
     */
    private static final Color highlightColor = Color.red;

    /**
     * The singleton instance.
     */
    private static final Colors colorInstance = new Colors();

    /**
     * Constructor.
     */
    private Colors() {}

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
