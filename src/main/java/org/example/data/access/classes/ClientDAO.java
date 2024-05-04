package org.example.data.access.classes;

import org.example.business.logic.classes.ClientT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends AbstractDAO<ClientT> {
    private static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String createStatement = "INSERT INTO client (name, phone_number, address) VALUES (?, ?, ?)";
    private static final String updateStatement = "UPDATE client SET name = ?, phone_number = ?, address = ? WHERE id = ?";
    private static final String deleteStatement = "DELETE FROM client WHERE id = ?";
    private static final String selectStatement = "SELECT * FROM client";

    @Override
    public int create(ClientT client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int insertedId = -1;
        try {
            statement = con.prepareStatement(createStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, client.getName());
            statement.setString(2, client.getPhoneNumber());
            statement.setString(3, client.getAddress());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if(rs.next()) {
                insertedId = rs.getInt(4);
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::insert::" + ex.getMessage());
        }
        finally {
            System.out.println("ClientDAO::insert::" + insertedId);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return insertedId;
    }

    private ArrayList<ClientT> processSelectResultSet(ResultSet rs)  {
        if(rs == null)
            return null;
        ArrayList<ClientT> list = new ArrayList<ClientT>();
        try {
            while (rs.next()) {
                int id = Integer.parseInt(rs.getString("id"));
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phone_number");
                String address = rs.getString("address");
                list.add(new ClientT(name, phoneNumber, address, id));
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::processing select::" + ex.getMessage());
        }
        return list;
    }
    @Override
    public ArrayList<ClientT> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<ClientT> list = null;
        try {
            statement = con.prepareStatement(selectStatement, Statement.RETURN_GENERATED_KEYS);
            rs = statement.executeQuery();
            list = processSelectResultSet(rs);
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::select::" + ex.getMessage());
        }
        finally {
            System.out.println("ClientDAO::select::0");
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return list;
    }

    @Override
    public void update(ClientT client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int success = -1;
        try {
            statement = con.prepareStatement(updateStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, client.getName());
            statement.setString(2, client.getPhoneNumber());
            statement.setString(3, client.getAddress());
            statement.setInt(4, client.getId());
            success = statement.executeUpdate();
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::update::" + ex.getMessage());
        }
        finally {
            System.out.println("ClientDAO::update::" + success);
            ConnectionFactory.closeAll(con, statement, null);
        }
    }

    @Override
    public void delete(ClientT client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int success = -1;
        try {
            statement = con.prepareStatement(deleteStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, client.getId());
            success = statement.executeUpdate();
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::delete::" + ex.getMessage());
        }
        finally {
            System.out.println("ClientDAO::delete::" + success);
            ConnectionFactory.closeAll(con, statement, null);
        }
    }
}
