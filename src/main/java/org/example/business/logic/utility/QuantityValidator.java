package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton implementation of the Validator interface.
 * Regex-based validation.
 * @author L7aur
 */
public class QuantityValidator implements Validator<String>{

    /**
     * Positive integer regex.
     */
    private final static String INTEGER_PATTERN = "^[1-9]\\d*$";

    /**
     * Singleton instance.
     */
    private static final QuantityValidator instance = new QuantityValidator();

    /**
     * Constructor.
     */
    private QuantityValidator() {}

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static QuantityValidator getValidator(){
        return instance;
    }

    /**
     * Checks if the given parameter complies with the regex expression.
     * @param integer The data to be validated.
     * @throws IllegalArgumentException If the data is invalid.
     */
    @Override
    public void validate(String integer) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(INTEGER_PATTERN);
        if (!pattern.matcher(integer).matches())
            throw new IllegalArgumentException("Invalid Quantity");
        if (integer.length() > 15)
            throw new IllegalArgumentException("Quantity number is too large");
    }
}
