package org.example.business.logic.utility;

import java.util.regex.Pattern;

public class PriceValidator implements Validator<String>{
    private static final String PRICE_PATTERN = "^[1-9]\\d*$";

    private static final PriceValidator instance = new PriceValidator();

    public static PriceValidator getValidator() {
        return instance;
    }

    @Override
    public void validate(String string) throws IllegalArgumentException {
        if (string != null) {
            Pattern pattern = Pattern.compile(PRICE_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid Price");
            if (string.length() > 15)
                throw new IllegalArgumentException("Stock number is too large");
        }
    }
}
