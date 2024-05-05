package org.example.data.access.classes;

import java.util.ArrayList;

public abstract class AbstractDAO<T> {
    public int create(T t) {
//        Class<?> clazz = t.getClass();
//        String tableName = clazz.getSimpleName().toLowerCase();
//        Field[] fields = clazz.getDeclaredFields();
//
//        StringBuilder query = new StringBuilder("INSERT INTO " + tableName + " (");
//        StringBuilder values = new StringBuilder(" VALUES (");
//        for (Field field : fields) {
//            query.append(field.getName()).append(", ");
//            values.append("?, ");
//        }
//        query.replace(query.length() - 2, query.length(), ")");
//        values.replace(values.length() - 2, values.length(), ")");
//        String fullQuery = query.toString() + values.toString();
//        Connection con = ConnectionFactory.getConnection();
//        PreparedStatement ps = null;
//        ResultSet rs = null;
        return -1;
    }

    public ArrayList<T> read() {
        return null;
    }

    public void update(T t){}

    public void delete(T t){}
}
