package org.example.model.utility;

import org.example.model.classes.dto.Product;

import java.util.regex.Pattern;

public class StockValidator implements Validator<Product> {
    private static final String STOCK_PATTERN = "^[0-9]+$";

    private static final StockValidator instance = new StockValidator();

    public static StockValidator getValidator() {
        return instance;
    }

    @Override
    public void validate(Product product) throws IllegalArgumentException {
        if (product != null && product.getStock() != null) {
            Pattern pattern = Pattern.compile(STOCK_PATTERN);
            if (!pattern.matcher(product.getStock()).matches())
                throw new IllegalArgumentException("Invalid Stock");
            if (product.getPrice().length() > 15)
                throw new IllegalArgumentException("Stock number is too large");
        }
    }
}
