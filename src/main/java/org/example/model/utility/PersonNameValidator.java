package org.example.model.utility;

import org.example.model.classes.dto.Client;
import java.util.regex.Pattern;

/**
 * Singleton pattern
 * Implements the validation of a name field based on regex
 */
public class PersonNameValidator implements Validator<Client>{
    private static final String NAME_PATTERN = "^[A-Z][a-z]+\\ [A-Z][a-z]+$";

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
     * @param client the Client data transfer object to be checked
     * @throws IllegalArgumentException if the name does not comply the regex pattern
     */
    @Override
    public void validate(Client client) throws IllegalArgumentException {
        if (client != null && client.getName() != null) {
            Pattern pattern = Pattern.compile(NAME_PATTERN);
            if (!pattern.matcher(client.getName()).matches())
                throw new IllegalArgumentException("Invalid phone number");
            if (client.getName().length() > 200)
                throw new IllegalArgumentException("Name is too long");
        }
    }
}
