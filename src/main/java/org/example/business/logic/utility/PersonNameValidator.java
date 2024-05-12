package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton pattern
 * Implements the validation of a name field based on regex
 */
public class PersonNameValidator implements Validator<String>{
    private static final String NAME_PATTERN = "^[A-Z][a-z]+ [A-Z][a-z]+$";

    private static final PersonNameValidator PERSON_NAME_VALIDATOR = new PersonNameValidator();

    /**
     * Getter
     * @return the singleton instance
     */
    public static PersonNameValidator getValidator() {
        return PERSON_NAME_VALIDATOR;
    }

    /**
     * Checks if the name attribute of the client data transfer object is valid
     * @param string the Client data transfer object to be checked
     * @throws IllegalArgumentException if the name does not comply the regex pattern
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
