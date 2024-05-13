package org.example.business.logic.utility;

/**
 * Generic interface that implements the validation of a generic input field.
 * Intended to work mainly with regex.
 * @param <T> The type of data to be validated.
 */
public interface Validator<T> {

    /**
     * Checks if the given data complies a certain format.
     * @param t The data to validate
     * @throws IllegalArgumentException If the data is invalid.
     */
    void validate(T t) throws IllegalArgumentException;
}
