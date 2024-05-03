package org.example.model.utility;

import org.example.data.access.classes.dto.Client;

import java.util.regex.Pattern;

public class NameValidator implements Validator<Client>{
    private static final String NAME_PATTERN = "[A-Z][a-z]+\\ [A-Z][a-z]+$";

    @Override
    public void validate(Client client) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if(!pattern.matcher(client.getName()).matches())
            throw new IllegalArgumentException("Invalid phone number");
        if(client.getName().length() > 200)
            throw new IllegalArgumentException("Name is too long");
    }
}
