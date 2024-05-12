package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton pattern
 * Implements the validation of an id field based on regex
 */
public class IdValidator implements Validator<String> {
    private static final String ID_PATTERN = "^[1-9]\\d*$";

    private static final IdValidator instance = new IdValidator();

    /**
     * Getter
     * @return the singleton instance
     */
    public static IdValidator getValidator() {
        return instance;
    }

    /**
     * Checks if the id attribute of an order data transfer object is valid
     * @param integer the id value to be checked
     * @throws IllegalArgumentException if the attribute does not comply with the regex
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
