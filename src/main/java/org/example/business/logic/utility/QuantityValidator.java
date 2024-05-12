package org.example.business.logic.utility;

import java.util.regex.Pattern;

public class QuantityValidator implements Validator<String>{
    private final static String INTEGER_PATTERN = "^[1-9]\\d*$";

    private static final QuantityValidator instance = new QuantityValidator();

    public static QuantityValidator getValidator(){
        return instance;
    }

    @Override
    public void validate(String integer) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(INTEGER_PATTERN);
        if (!pattern.matcher(integer).matches())
            throw new IllegalArgumentException("Invalid Quantity");
        if (integer.length() > 15)
            throw new IllegalArgumentException("Quantity number is too large");
    }
}
