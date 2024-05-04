package org.example.model.utility;

import org.example.model.classes.dto.Client;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements Validator<Client> {
    private static final String PHONE_NUMBER_PATTERN = "^\\+407[0-9]{8}$";

    private static final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();

    public static PhoneNumberValidator getValidator() {
        return phoneNumberValidator;
    }

    @Override
    public void validate(Client client) throws IllegalArgumentException {
        if(client != null && client.getPhoneNumber() != null) {
            Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
            if (!pattern.matcher(client.getPhoneNumber()).matches())
                throw new IllegalArgumentException("Invalid phone number");
        }
    }
}
