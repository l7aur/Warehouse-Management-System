package org.example.business.logic.utility;

/**
 * Interface that implements the validation of an input field
 * @param <T> type of field to be validated by some certain implementation of the interface
 */
public interface Validator<T> {
    void validate(T t) throws IllegalArgumentException;
}
