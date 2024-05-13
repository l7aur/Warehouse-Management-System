package org.example.presentation.utility;

import org.example.model.classes.dto.ProductT;
import org.example.data.access.utility.QueryType;
import org.example.business.logic.classes.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProductUpdatesActionListener implements ActionListener {
    private final ArrayList<JTextField> textFields;
    private QueryType type;

    public ProductUpdatesActionListener(ArrayList<JTextField> textFields, String operationName) {
        this.textFields = textFields;
        switch (operationName) {
            case "EDIT_PRODUCT_VIEW":
                this.type = QueryType.UPDATE;
                break;
            case "CREATE_PRODUCT_VIEW":
                this.type = QueryType.INSERT;
                break;
            case "DELETE_PRODUCT_VIEW":
                this.type = QueryType.DELETE;
                break;
            default:
                System.out.println("You should not be here !!" + operationName);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProductT pType = getProductT();
        for (JTextField textField : textFields) {
            textField.setText("");
        }
        if (pType != null) {
            switch (this.type) {
                case INSERT:
                    int id = pType.convertToDAO().create(pType);
                    System.out.println("Inserted product with ID " + id);
                    break;
                case UPDATE:
                    pType.convertToDAO().update(pType);
                    break;
                case DELETE:
                    pType.convertToDAO().delete(pType);
                    break;
                default:
                    System.out.println("You should not be here !");
                    break;
            }
        }
        else
            System.out.println("null");
    }

    private ProductT getProductT() {
        Product newProduct;
        if(textFields == null)
            return (new Product()).convertToEntity();
        if (textFields.size() == 3) { //create
            newProduct = new Product(textFields.getFirst().getText(),
                    textFields.get(1).getText(),
                    textFields.get(2).getText());
        }
        else if(textFields.size() == 4) { //edit
            newProduct = new Product(textFields.getFirst().getText(),
                    textFields.get(1).getText(),
                    textFields.get(2).getText(),
                    textFields.get(3).getText());
        }
        else //delete
            newProduct = new Product(textFields.getFirst().getText());

        return newProduct.convertToEntity();
    }
}
