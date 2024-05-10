package org.example.presentation.utility;

import java.awt.*;

/**
 * Singleton pattern
 * Instantiates the colors that are used throughout the whole GUI
 * @author L7aur
 */
public class Colors {
    private static final Color backgroundColor = new Color(32, 42,68);
    private static final Color foregroundColor = Color.white;
    private static final Color selectionColor = new Color(137, 143, 16);
    private static final Color highlightColor = Color.red;

    private static final Colors colorInstance = new Colors();

    private Colors() {

    }

    /**
     * Getter
     * @return the singleton instance
     */
    public static Colors getInstance() {
        return colorInstance;
    }

    /**
     * Getter
     * @return the background color
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Getter
     * @return the foreground color
     */
    public Color getForegroundColor() {
        return foregroundColor;
    }

    /**
     * Getter
     * @return the color used for highlighting
     */
    public Color getHighlightColor() {
        return highlightColor;
    }

    /**
     * Getter
     * @return the color used for selecting
     */
    public Color getSelectionColor() {
        return selectionColor;
    }
}
