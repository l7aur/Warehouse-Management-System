package org.example.model.utility;

public interface Validator<T> {
    public void validate(T t) throws IllegalArgumentException;
}
