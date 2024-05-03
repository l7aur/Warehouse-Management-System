package org.example.data.access.classes;

import org.example.business.logic.classes.ClientT;
import org.example.data.access.utility.ConnectionFactory;
import org.example.model.classes.dto.Client;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends AbstractDAO<ClientT> {
    private static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String createStatement = "INSERT INTO client (name, phone_number, address) VALUES (?, ?, ?)";

    @Override
    public int create(ClientT client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        ResultSet rs = null;
        int insertedId = -1;
        try {
            insertStatement = con.prepareStatement(createStatement, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, client.getName());
            insertStatement.setString(2, client.getPhoneNumber());
            insertStatement.setString(3, client.getAddress());
            insertStatement.executeUpdate();
            rs = insertStatement.getGeneratedKeys();
            if(rs.next()) {
                insertedId = rs.getInt(4);
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::insert::" + ex.getMessage());
        }
        finally {
            ConnectionFactory.closeAll(con, insertStatement, rs);
        }
        return insertedId;
    }

    @Override
    public void read(ClientT client) {
        super.read(client);
    }

    @Override
    public void update(ClientT client) {
        super.update(client);
    }

    @Override
    public void delete(ClientT client) {
        super.delete(client);
    }
}
