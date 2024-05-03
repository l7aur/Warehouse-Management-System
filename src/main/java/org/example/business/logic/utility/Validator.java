package org.example.business.logic.utility;

public interface Validator<T> {
    public void validate(T t) throws IllegalArgumentException;
}
