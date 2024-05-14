package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton implementation of the Validator interface.
 * Regex-based validation.
 * @author L7aur
 */
public class PriceValidator implements Validator<String>{

    /**
     * Price regex.
     */
    private static final String PRICE_PATTERN = "^[1-9]\\d*$";

    /**
     * Singleton instance.
     */
    private static final PriceValidator instance = new PriceValidator();

    /**
     * Constructor.
     */
    private PriceValidator() {}

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static PriceValidator getValidator() {
        return instance;
    }

    /**
     * Checks if the given parameter complies with the regex expression.
     * @param string The data to be validated.
     * @throws IllegalArgumentException If the data is invalid.
     */
    @Override
    public void validate(String string) throws IllegalArgumentException {
        if (string != null) {
            Pattern pattern = Pattern.compile(PRICE_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid Price");
            if (string.length() > 15)
                throw new IllegalArgumentException("Stock number is too large");
        }
    }
}
