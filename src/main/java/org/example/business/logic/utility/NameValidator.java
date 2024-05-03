package org.example.business.logic.utility;

import org.example.model.classes.dto.Client;

import javax.naming.Name;
import java.util.regex.Pattern;

public class NameValidator implements Validator<Client>{
    private static final String NAME_PATTERN = "[A-Z][a-z]+\\ [A-Z][a-z]+$";

    private static final NameValidator nameValidator = new NameValidator();

    public static NameValidator getValidator() {
        return nameValidator;
    }

    @Override
    public void validate(Client client) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        if(!pattern.matcher(client.getName()).matches())
            throw new IllegalArgumentException("Invalid phone number");
        if(client.getName().length() > 200)
            throw new IllegalArgumentException("Name is too long");
    }
}
