package org.example.model.utility;

import java.util.regex.Pattern;

public class IdValidator implements Validator<String> {
    private static final String ID_PATTERN = "^[1-9]\\d*$";

    private static final IdValidator instance = new IdValidator();

    public static IdValidator getValidator() {
        return instance;
    }
    @Override
    public void validate(String integer) throws IllegalArgumentException {
        if(integer != null) {
            Pattern pattern = Pattern.compile(ID_PATTERN);
            if (!pattern.matcher(integer).matches())
                throw new IllegalArgumentException("Invalid id");
            if (integer.length() > 15)
                throw new IllegalArgumentException("Id is too long");
        }
    }
}
