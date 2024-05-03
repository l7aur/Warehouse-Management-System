package org.example.model.utility;

import org.example.data.access.classes.dto.Client;

import java.util.regex.Pattern;

public class AddressValidator implements Validator<Client> {
    private static final String ADDRESS_PATTERN = "Str\\.\\ [A-Z][a-z]+\\ Nr\\.\\ [0-9]+[A-Z]?$";
    @Override
    public void validate(Client client) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(ADDRESS_PATTERN);
        if(!pattern.matcher(client.getAddress()).matches())
            throw new IllegalArgumentException("Invalid Address");
        if(client.getAddress().length() > 200)
            throw new IllegalArgumentException("Address is too long");
    }
}
