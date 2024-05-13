package org.example.data.access.classes;

import org.example.data.access.utility.AbstractDAO;
import org.example.model.classes.dto.OrderT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDAO extends AbstractDAO<OrderT> {
    private static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());

    private static final String selectStatement = "SELECT * FROM \"order\" WHERE id = ?";

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
}
