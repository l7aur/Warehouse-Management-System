package org.example.business.logic.utility;

import java.util.regex.Pattern;

public class StockValidator implements Validator<String> {
    private static final String STOCK_PATTERN = "^[0-9]+$";

    private static final StockValidator instance = new StockValidator();

    public static StockValidator getValidator() {
        return instance;
    }

    @Override
    public void validate(String string) throws IllegalArgumentException {
        if (string != null) {
            Pattern pattern = Pattern.compile(STOCK_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid Stock");
            if (string.length() > 15)
                throw new IllegalArgumentException("Stock number is too large");
        }
    }
}
