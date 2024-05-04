package org.example.model.utility;

import org.example.model.classes.dto.Product;

import java.util.regex.Pattern;

public class ProductNameValidator implements Validator<Product>{
    private static final String PRODUCT_NAME_PATTERN = "^[A-Za-z-]+$";

    private static final ProductNameValidator instance = new ProductNameValidator();

    public static ProductNameValidator getValidator() {
        return instance;
    }

    @Override
    public void validate(Product product) throws IllegalArgumentException {
        if (product != null && product.getName() != null) {
            Pattern pattern = Pattern.compile(PRODUCT_NAME_PATTERN);
            if (!pattern.matcher(product.getName()).matches())
                throw new IllegalArgumentException("Invalid Product Name");
            if (product.getPrice().length() > 200)
                throw new IllegalArgumentException("Product Name is too large");
        }
    }
}
