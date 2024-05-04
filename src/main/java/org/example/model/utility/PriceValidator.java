package org.example.model.utility;

import org.example.model.classes.dto.Product;

import java.util.regex.Pattern;

public class PriceValidator implements Validator<Product>{
    private static final String PRICE_PATTERN = "^[1-9]\\d*$";

    private static final PriceValidator instance = new PriceValidator();

    public static PriceValidator getValidator() {
        return instance;
    }

    @Override
    public void validate(Product product) throws IllegalArgumentException {
        if (product != null && product.getPrice() != null) {
            Pattern pattern = Pattern.compile(PRICE_PATTERN);
            if (!pattern.matcher(product.getPrice()).matches())
                throw new IllegalArgumentException("Invalid Price");
            if (product.getPrice().length() > 15)
                throw new IllegalArgumentException("Stock number is too large");
        }
    }
}
