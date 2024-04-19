package org.example.data.access.classes;

import com.sun.jdi.connect.spi.Connection;

import java.sql.ResultSet;
import java.util.logging.Logger;

/**
 *
 * @author L7aur
 */
public class ConnectionFactory {
    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/warehouse";
    private static final String USER = "postgres";
    private static final String PASS = "L7aur";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException e) {
            System.out.println("<ERROR>" + e.toString());
            System.exit(-2);
        }
    }

    private Connection createConnection() {
        return null;
    }
    public static Connection getConnection() {
        return null;
    }
    public static void close(Connection connection) {

    }
    public static void close(Statement statement) {

    }
    public static void close(ResultSet resultSet) {

    }
}
