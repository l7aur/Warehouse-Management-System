package org.example.data.access.utility;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDAO<T> {
    private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getSimpleName());

    private String createStatement(T t) {
        if(t != null) {
            Class<?> clazz = t.getClass();
            StringBuilder statementText = new StringBuilder();
            statementText.append("INSERT INTO \""); // INSERT INTO "
            statementText.append(clazz.getSimpleName().toLowerCase()); // convert to lowercase the tableName
            statementText.delete(statementText.length() - 1, statementText.length()); // remove the last t in the name
            statementText.append("\" ("); // INSERT INTO "tableName" (
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) // add fields and separators
                if (field.getName().equals("phoneNumber"))
                    statementText.append("phone_number, ");
                else if (field.getName().equals("clientID"))
                    statementText.append("client_id, ");
                else if (field.getName().equals("productID"))
                    statementText.append("product_id, ");
                else if (!field.getName().equals("id")) {
                    statementText.append(field.getName());
                    statementText.append(", ");
                }
            statementText.delete(statementText.length() - 2, statementText.length()); // remove the last comma and the following space
            statementText.append(") VALUES ("); // INSERT INTO "tableName" (fields, fields, ...) VALUES (
            statementText.append("?, ".repeat(Math.max(0, fields.length - 1))); //add question marks and separators
            statementText.delete(statementText.length() - 2, statementText.length()); //remove the last comma and the following space
            statementText.append(")"); // INSERT INTO "tableName" (fields, fields, ...) VALUES (?, ?, ...)
            return statementText.toString();
        }
        return null;
    }

    private String deleteStatement(T t) {
        if(t != null) {
            Class<?> clazz = t.getClass();
            StringBuilder statementText = new StringBuilder();
            statementText.append("DELETE FROM \""); // DELETE FROM"
            statementText.append(clazz.getSimpleName().toLowerCase()); // convert to lowercase the tableName
            statementText.delete(statementText.length() - 1, statementText.length()); // remove the last t in the name
            statementText.append("\" WHERE id = ?"); // DELETE FROM "tableName" WHERE id = ?
            return statementText.toString();
        }
        return null;
    }

    private String updateStatement(T t) {
        if(t != null) {
            Class<?> clazz = t.getClass();
            StringBuilder statementText = new StringBuilder();
            //todo
            return statementText.toString();
        }
        return null;
    }

    private void setParametersForCreate(PreparedStatement statement, T t) {
        if(t != null) {
            Class<?> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            int index = 0;
            for (Field field : fields) {
                if (!field.getName().equals("id")) {
                    index++;
                    try {
                        field.setAccessible(true);
                        switch (field.getType().getSimpleName()) {
                            case "int":
                                statement.setInt(index, (Integer) field.get(t));
                                break;
                            case "String":
                                statement.setString(index, field.get(t).toString());
                                break;
                            default:
                                LOGGER.log(Level.SEVERE, "Unrecognized field type!");
                                break;
                        }
                    } catch (IllegalAccessException e) {
                        LOGGER.log(Level.SEVERE, "Unrecognized field type!");
                    } catch (SQLException e) {
                        LOGGER.log(Level.SEVERE, "SQL Exception at params!");
                    }
                }
            }
        }
    }

    public int create(T t) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int insertedId = -1;
        try {
            statement = connection.prepareStatement(createStatement(t), Statement.RETURN_GENERATED_KEYS);
            setParametersForCreate(statement, t);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            if(resultSet.next()) {
                insertedId = resultSet.getInt("id");
            }
        }
        catch (SQLException e) {
            LOGGER.log(Level.WARNING, "FAILED CREATE OPERATION\n" + e.getMessage());
        }
        finally {
            if(insertedId != -1)
                LOGGER.log(Level.INFO, "SUCCESS CREATE OPERATION\nID: " + insertedId + "\n");
            ConnectionFactory.closeAll(connection, statement, resultSet);
        }
        return insertedId;
    }

    public ArrayList<Object> read() {
        return null;
    }

    private void setParametersForUpdate(PreparedStatement statement, T t) {
        //todo
    }

    public void update(T t){
        //replace with new one todo
    }

    public void update1(T t){
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int success = -1;
        try {
            statement = connection.prepareStatement(updateStatement(t), Statement.RETURN_GENERATED_KEYS);
            setParametersForUpdate(statement, t);
            success = statement.executeUpdate();
        }
        catch (SQLException ex) {
            LOGGER.log(Level.WARNING, "FAILED UPDATE OPERATION\n" + ex.getMessage());
        }
        finally {
            if(success != -1)
                LOGGER.log(Level.INFO, "SUCCESS UPDATE OPERATION\n");
            ConnectionFactory.closeAll(connection, statement, null);
        }
    }

    private void setParametersForDelete(PreparedStatement statement, T t) {
        if( t != null) {
            Class<?> clazz = t.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals("id")) {
                    try {
                        field.setAccessible(true);
                        if (field.getType().getSimpleName().equals("int"))
                            statement.setInt(1, (Integer) field.get(t));
                        else
                            LOGGER.log(Level.SEVERE, "Unrecognized field type!");
                    } catch (IllegalAccessException e) {
                        LOGGER.log(Level.SEVERE, "Unrecognized field type!");
                    } catch (SQLException e) {
                        LOGGER.log(Level.SEVERE, "SQL Exception at params!");
                    }
                }
            }
        }
    }

    public void delete(T t) {
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement statement = null;
        int success = -1;
        try {
            statement = connection.prepareStatement(deleteStatement(t), Statement.RETURN_GENERATED_KEYS);
            setParametersForDelete(statement, t);
            success = statement.executeUpdate();
        }
        catch (SQLException e) {
            LOGGER.log(Level.WARNING, "FAILED DELETE OPERATION\n" + e.getMessage());
        }
        finally {
            if (success != -1)
                LOGGER.log(Level.INFO, "SUCCESS DELETE OPERATION\n");
            ConnectionFactory.closeAll(connection, statement, null);
        }
    }
}
