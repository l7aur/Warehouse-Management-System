package org.example.data.access.classes;

import org.example.data.access.utility.AbstractDAO;
import org.example.model.classes.dto.ProductT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO extends AbstractDAO<ProductT> {
    private static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

    private static final String selectByIdStatement = "SELECT * FROM product WHERE id = ?";

    public ProductT getProductById(int id) {
        ProductT productT = null;
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = con.prepareStatement(selectByIdStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            if(rs.next()) {
                productT = new ProductT(rs.getString(1), rs.getInt(2),
                        rs.getInt(4), rs.getInt(3));
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ProductDAO::selectById::" + ex.getMessage());
        }
        finally {
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return productT;
    }
}
