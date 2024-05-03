package org.example.model.utility;

import org.example.data.access.classes.Client;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements Validator<Client> {
    private static final String PHONE_NUMBER_PATTERN = "\\+407[0-9]{8}$";
    @Override
    public void validate(Client client) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        if(!pattern.matcher(client.getPhoneNumber()).matches())
            throw new IllegalArgumentException("Invalid phone number");
    }
}
