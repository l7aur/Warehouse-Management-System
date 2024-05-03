package org.example.data.access.classes;

import org.example.business.logic.classes.ClientT;
import org.example.data.access.utility.ConnectionFactory;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends AbstractDAO<ClientT> {
    private static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String createStatement = "INSERT INTO client (name, phone_number, address) VALUES (?, ?, ?)";
    private static final String updateStatement = "UPDATE client SET name = ?, phone_number = ?, address = ? WHERE id = ?";
    private static final String deleteStatement = "DELETE FROM client WHERE id = ?";

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

    @Override
    public void read(ClientT client) {
        super.read(client);
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
