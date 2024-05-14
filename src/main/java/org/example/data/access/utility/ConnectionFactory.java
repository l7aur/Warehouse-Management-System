package org.example.data.access.utility;

import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton implementation of the connection to the database.
 * @author L7aur
 */
public class ConnectionFactory {

    /**
     * Logger object.
     */
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

    /**
     * Driver path.
     */
    private static final String DRIVER = "org.postgresql.Driver";

    /**
     * Link to database.
     */
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/warehouse";

    /**
     * Database username. (root - bad practice)
     */
    private static final String USER = "postgres";

    /**
     * User database password.
     */
    private static final String PASS = "L7aur";

    /**
     * Singleton instance.
     */
    private static final ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Constructor.
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
     * Creates a connection to the database.
     * @return a connection if possible.
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
            System.out.println("Connection created");
        }
        catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occurred while trying to connect to the database!");
        }
        return connection;
    }

    /**
     * Gets the singleton instance of the validator.
     * @return The singleton instance.
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Closes everything related to the connection to the database.
     * @param connection The connection if any.
     * @param statement The statement if any.
     * @param resultSet The result set if any.
     */
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
        close(connection);
        close(statement);
        close(resultSet);
        System.out.println("Connection closed\n");
    }

    /**
     * Closes the connection object if any.
     * @param connection The connection to be closed.
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
     * Closes the statement object if any.
     * @param statement The statement object to be closed.
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
     * Closes a result set object if any.
     * @param resultSet The result set object to be closed.
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
