package org.example.presentation.utility;

/**
 * Generic interface that implements the standardization of a view.
 * All views of the application implement this interface.
 * @author L7aur
 */
public interface View {
    /**
     * Creates and places the GUI inside a view.
     */
    void createContent();

    /**
     * Getter.
     * @return the unique identifier of a view.
     */
    String getId();
}
