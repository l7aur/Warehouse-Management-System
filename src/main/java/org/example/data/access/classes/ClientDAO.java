package org.example.data.access.classes;

import org.example.data.access.utility.AbstractDAO;
import org.example.model.classes.dto.ClientT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends AbstractDAO<ClientT> {
    private static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());

    private static final String selectStatement = "SELECT * FROM client";

    private ArrayList<Object> processSelectResultSet(ResultSet rs) throws SQLException {
        if (rs == null)
            return null;
        ArrayList<Object> list = new ArrayList<>();
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("id"));
            String name = rs.getString("name");
            String phoneNumber = rs.getString("phone_number");
            String address = rs.getString("address");
            list.add(new ClientT(name, phoneNumber, address, id));
        }
        return list;
    }

    @Override
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
            LOGGER.log(Level.WARNING, "ClientDAO::select::" + ex.getMessage());
        }
        finally {
            System.out.println("ClientDAO::select::" + successString);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return list;
    }
}
