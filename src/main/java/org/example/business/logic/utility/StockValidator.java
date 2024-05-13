package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton implementation of the Validator interface.
 * Regex-based validation.
 */
public class StockValidator implements Validator<String> {
    private static final String STOCK_PATTERN = "^[0-9]+$";

    private static final StockValidator instance = new StockValidator();

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static StockValidator getValidator() {
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
            Pattern pattern = Pattern.compile(STOCK_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid Stock");
            if (string.length() > 15)
                throw new IllegalArgumentException("Stock number is too large");
        }
    }
}
