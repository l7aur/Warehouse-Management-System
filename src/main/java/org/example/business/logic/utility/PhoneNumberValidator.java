package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton implementation of the Validator interface.
 * Regex-based validation.
 */
public class PhoneNumberValidator implements Validator<String> {
    private static final String PHONE_NUMBER_PATTERN = "^\\+407[0-9]{8}$";

    private static final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static PhoneNumberValidator getValidator() {
        return phoneNumberValidator;
    }

    /**
     * Checks if the given parameter complies with the regex expression.
     * @param string The data to be validated.
     * @throws IllegalArgumentException If the data is invalid.
     */
    @Override
    public void validate(String string) throws IllegalArgumentException {
        if(string != null) {
            Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid phone number");
        }
    }
}
