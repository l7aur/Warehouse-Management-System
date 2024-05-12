package org.example.business.logic.utility;

import java.util.regex.Pattern;

public class PhoneNumberValidator implements Validator<String> {
    private static final String PHONE_NUMBER_PATTERN = "^\\+407[0-9]{8}$";

    private static final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();

    public static PhoneNumberValidator getValidator() {
        return phoneNumberValidator;
    }

    @Override
    public void validate(String string) throws IllegalArgumentException {
        if(string != null) {
            Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid phone number");
        }
    }
}
