package org.example.data.access.classes;

import org.example.data.access.utility.AbstractDAO;
import org.example.model.classes.dto.OrderT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Class that implements specific order SQL queries.
 * @author L7aur
 */
public class OrderDAO extends AbstractDAO<OrderT> {
    private static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());

    private static final String selectStatement = "SELECT * FROM \"order\" WHERE id = ?";

    /**
     * Returns the order that has the corresponding id if it exists.
     * @param id The id of the order to be searched.
     * @return The order that has the same id as the parameter.
     */
    public OrderT getOrderById(int id) {
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
            LOGGER.log(Level.WARNING, "FAILED ORDER FIND BY ID", ex);
        }
        finally {
            if(successString.equals("success"))
                LOGGER.log(Level.INFO, "SUCCESS ORDER FIND BY ID");
            else
                LOGGER.log(Level.INFO, "ORDER DOES NOT EXIST");
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return orderT;
    }
}
