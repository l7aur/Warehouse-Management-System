package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton implementation of the Validator interface.
 * Regex-based validation.
 * @author L7aur
 */
public class ProductNameValidator implements Validator<String>{

    /**
     * Product name regex.
     */
    private static final String PRODUCT_NAME_PATTERN = "^[A-Za-z-]+$";

    /**
     * Singleton instance.
     */
    private static final ProductNameValidator instance = new ProductNameValidator();

    /**
     * Constructor.
     */
    private ProductNameValidator() {}

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static ProductNameValidator getValidator() {
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
            Pattern pattern = Pattern.compile(PRODUCT_NAME_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid Product Name");
            if (string.length() > 200)
                throw new IllegalArgumentException("Product Name is too large");
        }
    }
}
