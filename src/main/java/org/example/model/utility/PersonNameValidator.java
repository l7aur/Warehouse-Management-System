package org.example.model.utility;

import org.example.model.classes.dto.Client;

import java.util.regex.Pattern;

public class PersonNameValidator implements Validator<Client>{
    private static final String NAME_PATTERN = "^[A-Z][a-z]+\\ [A-Z][a-z]+$";

    private static final PersonNameValidator PERSON_NAME_VALIDATOR = new PersonNameValidator();

    public static PersonNameValidator getValidator() {
        return PERSON_NAME_VALIDATOR;
    }

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
