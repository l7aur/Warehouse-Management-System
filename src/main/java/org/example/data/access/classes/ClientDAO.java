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

    private static final int ID_COLUMN = 4;
    private static final int NAME_COLUMN = 1;
    private static final int PHONE_NUMBER_COLUMN = 2;
    private static final int ADDRESS_COLUMN = 3;

    @Override
    public int create(ClientT client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        int insertedId = -1;
        try {
            statement = con.prepareStatement(createStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(NAME_COLUMN, client.getName());
            statement.setString(PHONE_NUMBER_COLUMN, client.getPhoneNumber());
            statement.setString(ADDRESS_COLUMN, client.getAddress());
            statement.executeUpdate();
            rs = statement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(ID_COLUMN);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::insert::" + ex.getMessage());
        } finally {
            String successString = "success";
            if(insertedId != -1)
                successString = "fail";
            System.out.println("ClientDAO::insert::" + successString + "::" + insertedId);
            ConnectionFactory.closeAll(con, statement, rs);
        }
        return insertedId;
    }

    private ArrayList<ClientT> processSelectResultSet(ResultSet rs) throws SQLException {
        if (rs == null)
            return null;
        ArrayList<ClientT> list = new ArrayList<>();
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
    public ArrayList<ClientT> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<ClientT> list = null;
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

    @Override
    public void update(ClientT client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int success = -1;
        try {
            statement = con.prepareStatement(updateStatement, Statement.RETURN_GENERATED_KEYS);
            statement.setString(NAME_COLUMN, client.getName());
            statement.setString(PHONE_NUMBER_COLUMN, client.getPhoneNumber());
            statement.setString(ADDRESS_COLUMN, client.getAddress());
            statement.setInt(ID_COLUMN, client.getId());
            success = statement.executeUpdate();
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::update::" + ex.getMessage());
        }
        finally {
            String successString = "success";
            if(success == -1)
                successString = "fail";
            System.out.println("ClientDAO::update::" + successString);
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
            statement.setInt(ID_COLUMN, client.getId());
            success = statement.executeUpdate();
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::delete::" + ex.getMessage());
        }
        finally {
            String successString = "success";
            if(success == -1)
                successString = "fail";
            System.out.println("ClientDAO::delete::" + successString);
            ConnectionFactory.closeAll(con, statement, null);
        }
    }
}
