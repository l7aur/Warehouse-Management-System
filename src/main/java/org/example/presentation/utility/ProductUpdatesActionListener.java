package org.example.presentation.utility;

import org.example.model.classes.dto.ProductT;
import org.example.data.access.utility.QueryType;
import org.example.business.logic.classes.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Implementation of the ActionListener interface associated to the creation, update and deletion in the product panel.
 * @author L7aur
 */
public class ProductUpdatesActionListener implements ActionListener {

    /**
     * The array of text fields reference.
     */
    private final ArrayList<JTextField> textFields;

    /**
     * The query type.
     */
    private QueryType type;

    /**
     * Constructor.
     * @param textFields An array of references to the text fields that are displayed in the GUI.
     * @param operationName The name of the operation that should be executed.
     */
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

    /**
     * Queries the database on action event.
     * @param e The event to be processed (button press).
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ProductT pType = getProductT();
        for (JTextField textField : textFields) {
            textField.setText("");
        }
        if (pType != null) {
            switch (this.type) {
                case INSERT:
                    pType.convertToDAO().create(pType);
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

    /**
     * Creates a product data transfer object based on how many fields are in the GUI view.
     * @return The product data transfer object.
     */
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
