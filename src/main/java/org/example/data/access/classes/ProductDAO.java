package org.example.data.access.classes;

import org.example.data.access.utility.AbstractDAO;
import org.example.model.classes.dto.ProductT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that implements specific product SQL queries.
 * @author L7aur
 */
public class ProductDAO extends AbstractDAO<ProductT> {
    private static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

    private static final String selectByIdStatement = "SELECT * FROM product WHERE id = ?";

    /**
     * Returns the product that has the corresponding id if it exists.
     * @param id The id of the product to be searched.
     * @return The product that has the same id as the parameter.
     */
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
