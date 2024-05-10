package org.example.data.access.utility;

import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton pattern
 * The class that implements the connection to the database.
 * @author L7aur
 */
public class ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/warehouse";
    private static final String USER = "postgres";
    private static final String PASS = "L7aur";

    private static final ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Empty constructor
     */
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException e) {
            System.out.println("<ERROR>" + e);
        }
    }

    /**
     * Creates a connection to the database
     * @return a Connection
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            System.out.println("Connection created");
        }
        catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to connect to the database");
        }
        return connection;
    }

    /**
     * Getter
     * @return the singleton instance open connection
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Closes everything related to the connection to the database
     * @param connection the Connection object if any
     * @param statement the Statement object if any
     * @param resultSet the ResultSet object if any
     */
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        close(connection);
        close(statement);
        close(resultSet);
        System.out.println("Connection closed\n");
    }

    /**
     * Closes the Connection object if any
     * @param connection the Connection object to be closed
     */
    private static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the connection");
            }
        }
    }

    /**
     * Closes the Statement object if any
     * @param statement the Statement object to be closed
     */
    private static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the statement");
            }
        }
    }

    /**
     * Closes a ResultSet object if any
     * @param resultSet the ResultSet object to be closed
     */
    private static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occurred while trying to close the ResultSet");
            }
        }
    }
}
