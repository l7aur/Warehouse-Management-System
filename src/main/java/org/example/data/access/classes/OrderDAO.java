package org.example.data.access.classes;

import org.example.data.access.utility.AbstractDAO;
import org.example.model.classes.dto.OrderT;
import org.example.model.classes.dto.ProductT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO extends AbstractDAO<OrderT> {
    private static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());

    private static final String createStatement = "INSERT INTO \"order\" (client_id, product_id, quantity) VALUES (?, ?, ?)";
    private static final String selectStatement = "SELECT * FROM \"order\" WHERE id = ?";


    private ProductT getProduct(int id) {
        ProductDAO productDAO = new ProductDAO();
        return productDAO.getProductById(id);
    }

    private void updateQuantity(ProductT product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.update(product);
    }

    public OrderT getOrder(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String successString = "fail";
        OrderT orderT = null;
        try {
            statement = con.prepareStatement(selectStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                successString = "success";
                orderT = new OrderT(rs.getInt(1), rs.getInt(2),
                        rs.getInt(4), rs.getInt(3));
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "Can't find the order", ex);
        }
        finally {
            System.out.println("OrderDAO::select::" + successString);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return orderT;
    }

    @Override
    public int create(OrderT orderT) {
        ProductT product = this.getProduct(orderT.getProductID());
        if(product.stock() < orderT.getQuantity())
            return -1;
        ProductT newProduct = new ProductT(product.name(), product.stock() - orderT.getQuantity(),
                product.price(), product.id());
        this.updateQuantity(newProduct);
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
