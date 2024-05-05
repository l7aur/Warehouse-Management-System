package org.example.data.access.classes;

import org.example.business.logic.classes.OrderT;
import org.example.business.logic.classes.ProductT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO extends AbstractDAO<OrderT> {
    private static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());

    private static final String createStatement = "INSERT INTO \"order\" (client_id, product_id, quantity) VALUES (?, ?, ?)";


    private ProductT getProduct(int id) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getProductById(id);
    }

    private void updateQuantity(ProductT product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.update(product);
    }

    @Override
    public int create(OrderT orderT) {
        ProductT product = this.getProduct(orderT.getProductID());
        if(product.getStock() < orderT.getQuantity())
            return -1;
        product.setStock(product.getStock() - orderT.getQuantity());
        this.updateQuantity(product);
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int insertedId = -1;
        try {
            statement = con.prepareStatement(createStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, orderT.getClientID());
            statement.setInt(2, orderT.getProductID());
            statement.setInt(3, orderT.getQuantity());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(3);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::insert::" + ex.getMessage());
        } finally {
            String successString = "success";
            if(insertedId == -1)
                successString = "fail";
            System.out.println("OrderDAO::insert::" + successString + "::" + insertedId);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return insertedId;
    }
}
