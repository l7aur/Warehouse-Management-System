package org.example.model.utility;

import org.example.model.classes.dto.Client;

import java.util.regex.Pattern;

public class AddressValidator implements Validator<Client> {
    private static final String ADDRESS_PATTERN = "^Str\\.\\ [A-Z][A-Za-z]+\\ Nr\\.\\ [0-9]+[A-Z]?$";

    private static final AddressValidator addressValidator = new AddressValidator();

    public static AddressValidator getValidator() {
        return addressValidator;
    }

    @Override
    public void validate(Client client) throws IllegalArgumentException {
        if (client != null && client.getAddress() != null) {
            Pattern pattern = Pattern.compile(ADDRESS_PATTERN);
            if (!pattern.matcher(client.getAddress()).matches())
                throw new IllegalArgumentException("Invalid Address");
            if (client.getAddress().length() > 200)
                throw new IllegalArgumentException("Address is too long");
        }
    }
}
