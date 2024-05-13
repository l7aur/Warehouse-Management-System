package org.example.data.access.classes;

import org.example.data.access.utility.ConnectionFactory;
import org.example.model.classes.dto.BillT;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillDAO  {
    private static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());

    private static final String createStatement = "INSERT INTO log (order_id, price) VALUES (?, ?)";
    private static final String selectStatement = "SELECT * FROM log";

    public int create(BillT billT) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int insertedId = -1;
        try {
            statement = con.prepareStatement(createStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, billT.orderID());
            statement.setInt(2, billT.price());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if(rs.next()) {
                insertedId = rs.getInt(3);
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "BillDAO::insert::" + ex.getMessage());
        }
        finally {
            String successString = "success";
            if(insertedId == -1)
                successString = "fail";
            System.out.println("BillDAO::insert::" + successString + "::" + insertedId);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return insertedId;
    }

    private ArrayList<Object> processSelectResultSet(ResultSet rs) throws SQLException {
        if (rs == null)
            return null;
        ArrayList<Object> list = new ArrayList<>();
        while (rs.next()) {
            int orderId = Integer.parseInt(rs.getString("order_id"));
            int price = Integer.parseInt(rs.getString("price"));
            list.add(new BillT(orderId, price));
        }
        return list;
    }

    public ArrayList<Object> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Object> list = null;
        String successString = "success";
        try {
            statement = con.prepareStatement(selectStatement, Statement.RETURN_GENERATED_KEYS);
            rs = statement.executeQuery();
            list = processSelectResultSet(rs);
        }
        catch (SQLException ex) {
            successString = "fail";
            LOGGER.log(Level.WARNING, "BillDAO::select::" + ex.getMessage());
        }
        finally {
            System.out.println("BillDAO::select::"+ successString);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return list;
    }
}
