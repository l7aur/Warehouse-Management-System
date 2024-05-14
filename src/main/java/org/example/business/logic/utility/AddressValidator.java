package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton implementation of the Validator interface.
 * Regex-based validation.
 * @author L7aur
 */
public class AddressValidator implements Validator<String> {

    /**
     * Address regex.
     */
    private static final String ADDRESS_PATTERN = "^Str\\. [A-Z][A-Za-z]+ Nr\\. [0-9]+[A-Z]?$";

    /**
     * Constructor.
     */
    private AddressValidator() {}

    /**
     * Singleton instance.
     */
    private static final AddressValidator addressValidator = new AddressValidator();

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static AddressValidator getValidator() {
        return addressValidator;
    }

    /**
     * Checks if the given parameter complies with the regex expression.
     * @param string The data to be validated.
     * @throws IllegalArgumentException If the data is invalid.
     */
    @Override
    public void validate(String string) throws IllegalArgumentException {
        if (string != null) {
            Pattern pattern = Pattern.compile(ADDRESS_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid Address");
            if (string.length() > 200)
                throw new IllegalArgumentException("Address is too long");
        }
    }
}
