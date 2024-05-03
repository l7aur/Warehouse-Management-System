package org.example.model.classes;

import org.example.data.access.classes.ConnectionFactory;
import org.example.data.access.classes.dto.Client;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends AbstractDAO<Client> {
    private static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String createStatement = "INSERT INTO client (name, phone_number, address, id) VALUES (?, ?, ?, ?)";

    @Override
    public int create(Client client) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = con.prepareStatement(createStatement, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, client.getName());
            insertStatement.setString(2, client.getPhoneNumber());
            insertStatement.setString(3, client.getAddress());
            insertStatement.executeUpdate();
            ResultSet rs = insertStatement.getGeneratedKeys();
            if(rs.next()) {
                insertedId = rs.getInt(1);
            }
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "ClientDAO::insert" + ex.getMessage());
        }
        finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(con);
        }
        return insertedId;
    }

    @Override
    public void read(Client client) {
        super.read(client);
    }

    @Override
    public void update(Client client) {
        super.update(client);
    }

    @Override
    public void delete(Client client) {
        super.delete(client);
    }
}
