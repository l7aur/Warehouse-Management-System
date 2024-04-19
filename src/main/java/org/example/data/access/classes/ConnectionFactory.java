package org.example.data.access.classes;

import com.sun.jdi.connect.spi.Connection;
import org.example.data.access.utility.Statement;

import java.sql.ResultSet;

public class ConnectionFactory {
    private static final String LOGGER = "";
    private static final String DRIVER = "";
    private static final String DATABASE_URL = "";
    private static final String URL = "";
    private static final String PASS = "";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException e) {
            System.out.println("<ERROR>" + e.toString());
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
