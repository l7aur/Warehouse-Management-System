package org.example.business.logic.utility;

import java.util.regex.Pattern;

/**
 * Singleton pattern
 * Implements the validation of an address field based on regex
 */
public class AddressValidator implements Validator<String> {
    private static final String ADDRESS_PATTERN = "^Str\\. [A-Z][A-Za-z]+ Nr\\. [0-9]+[A-Z]?$";

    private static final AddressValidator addressValidator = new AddressValidator();

    /**
     * getter
     * @return the singleton instance
     */
    public static AddressValidator getValidator() {
        return addressValidator;
    }

    /**
     * Checks if the address attribute of a client data transfer object is valid
     * @param string the Client data transfer object to be checked
     * @throws IllegalArgumentException if the attribute does not comply with the regex
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
