package org.example.data.access.classes;

import org.example.business.logic.classes.ProductT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO extends AbstractDAO<ProductT> {
    private static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

    private static final String createStatement = "INSERT INTO product (name, stock, price ) VALUES (?, ?, ?)";
    private static final String updateStatement = "UPDATE product SET name = ?, stock = ?, price = ? WHERE id = ?";
    private static final String deleteStatement = "DELETE FROM product WHERE id = ?";
    private static final String selectStatement = "SELECT * FROM product";

    private static final int ID_COLUMN = 3;
    private static final int NAME_COLUMN = 1;
    private static final int STOCK_COLUMN = 2;
    private static final int PRICE_COLUMN = 4;

    @Override
    public int create(ProductT product) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int insertedId = -1;
        try {
            statement = con.prepareStatement(createStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(NAME_COLUMN, product.getName());
            statement.setInt(STOCK_COLUMN, product.getStock());
            statement.setInt(PRICE_COLUMN, product.getPrice());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if(rs.next()) {
                insertedId = rs.getInt(ID_COLUMN);
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ProductDAO::insert::" + ex.getMessage());
        }
        finally {
            String successString = "success";
            if(insertedId != -1)
                successString = "fail";
            System.out.println("ProductDAO::insert::" + successString + "::" + insertedId);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return insertedId;
    }

    private ArrayList<ProductT> processSelectResultSet(ResultSet rs) throws SQLException {
        if (rs == null)
            return null;
        ArrayList<ProductT> list = new ArrayList<>();

        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("id"));
            String name = rs.getString("name");
            Integer stock = Integer.valueOf(rs.getString("stock"));
            Integer price = Integer.valueOf(rs.getString("price"));
            list.add(new ProductT(name, stock, price, id));
        }

        return list;
    }
    @Override
    public ArrayList<ProductT> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<ProductT> list = null;
        String successString = "success";
        try {
            statement = con.prepareStatement(selectStatement, Statement.RETURN_GENERATED_KEYS);
            rs = statement.executeQuery();
            list = processSelectResultSet(rs);
        }
        catch (SQLException ex) {
            successString = "fail";
            LOGGER.log(Level.WARNING, "ProductDAO::select::" + ex.getMessage());
        }
        finally {
            System.out.println("ProductDAO::select::"+ successString);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return list;
    }

    @Override
    public void update(ProductT product) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int success = -1;
        try {
            statement = con.prepareStatement(updateStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(NAME_COLUMN, product.getName());
            statement.setInt(STOCK_COLUMN, product.getStock());
            statement.setInt(PRICE_COLUMN, product.getPrice());
            statement.setInt(ID_COLUMN, product.getId());
            System.out.println(product.getId() + " " + product.getName() + " " + product.getStock() + " " + product.getPrice());
            success = statement.executeUpdate();
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ProductDAO::update::" + ex.getMessage());
        }
        finally {
            String successString = "success";
            if(success == -1)
                successString = "fail";
            System.out.println("ProductDAO::update::" + successString);
            ConnectionFactory.closeAll(con, statement, null);
        }
    }

    @Override
    public void delete(ProductT product) {
        System.out.println(product.getId());
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int success = -1;
        try {
            statement = con.prepareStatement(deleteStatement, Statement.RETURN_GENERATED_KEYS);
            System.out.println(product.getId());
            statement.setInt(ID_COLUMN, product.getId());
            success = statement.executeUpdate();
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ProductDAO::delete::" + ex.getMessage());
        }
        finally {
            String successString = "success";
            if(success == -1)
                successString = "fail";
            System.out.println("ProductDAO::delete::" + successString);
            ConnectionFactory.closeAll(con, statement, null);
        }
    }
}
