package org.example.business.logic.utility;

import java.util.regex.Pattern;

public class ProductNameValidator implements Validator<String>{
    private static final String PRODUCT_NAME_PATTERN = "^[A-Za-z-]+$";

    private static final ProductNameValidator instance = new ProductNameValidator();

    public static ProductNameValidator getValidator() {
        return instance;
    }

    @Override
    public void validate(String string) throws IllegalArgumentException {
        if (string != null) {
            Pattern pattern = Pattern.compile(PRODUCT_NAME_PATTERN);
            if (!pattern.matcher(string).matches())
                throw new IllegalArgumentException("Invalid Product Name");
            if (string.length() > 200)
                throw new IllegalArgumentException("Product Name is too large");
        }
    }
}
