package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton implementation of the Validator interface.
 * Regex-based validation.
 * @author L7aur
 */
public class IdValidator implements Validator<String> {
    private static final String ID_PATTERN = "^[1-9]\\d*$";

    private static final IdValidator instance = new IdValidator();

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static IdValidator getValidator() {
        return instance;
    }

    /**
     * Checks if the given parameter complies with the regex expression.
     * @param integer The data to be validated.
     * @throws IllegalArgumentException If the data is invalid.
     */
    @Override
    public void validate(String integer) throws IllegalArgumentException {
        if(integer != null) {
            Pattern pattern = Pattern.compile(ID_PATTERN);
            if (!pattern.matcher(integer).matches())
                throw new IllegalArgumentException("Invalid id");
            if (integer.length() > 15)
                throw new IllegalArgumentException("Id is too long");
        }
    }
}
