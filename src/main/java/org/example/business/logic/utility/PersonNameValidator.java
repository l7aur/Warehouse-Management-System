package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton implementation of the Validator interface.
 * Regex-based validation.
 * @author L7aur
 */
public class PersonNameValidator implements Validator<String>{

    /**
     * Name regex.
     */
    private static final String NAME_PATTERN = "^[A-Z][a-z]+ [A-Z][a-z]+$";

    /**
     * Singleton instance.
     */
    private static final PersonNameValidator PERSON_NAME_VALIDATOR = new PersonNameValidator();

    /**
     * Constructor.
     */
    private PersonNameValidator() {}

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static PersonNameValidator getValidator() {
        return PERSON_NAME_VALIDATOR;
    }

    /**
     * Checks if the given parameter complies with the regex expression.
     * @param string The data to be validated.
     * @throws IllegalArgumentException If the data is invalid.
     */
    @Override
    public void validate(String string) throws IllegalArgumentException {
        if (string != null) {
            Pattern pattern = Pattern.compile(NAME_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid phone number");
            if (string.length() > 200)
                throw new IllegalArgumentException("Name is too long");
        }
    }
}
