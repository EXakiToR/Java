package eshop.orm.repositories;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import eshop.orm.entities.Entity;

public abstract class Repository<T extends Entity> {
    private final String url = "jdbc:postgresql://localhost:5433/eshop?user=postgres&password=postgres&ssl=false";
    protected Connection conn;

    public Repository() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void create(T entity) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("INSERT INTO entity VALUES('"
                    + entity.getUuid() + "', '"
                    + entity.getClass().getSimpleName() + "', '"
                    + entity.getCreatedAt() + "', NULL, NULL, NULL)");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        entity.setCreatedAt(LocalDateTime.now().toString());
    }

    public T read(T entity) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE entity SET read_at = '"
                    + LocalDateTime.now().toString() + "' WHERE uuid = '"
                    + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        entity.setReadAt(LocalDateTime.now().toString());
        return entity;
    }

    public void update(T entity) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE entity SET updated_at = '"
                    + LocalDateTime.now().toString() + "' WHERE uuid = '"
                    + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        entity.setUpdatedAt(LocalDateTime.now().toString());
    }

    public void delete(T entity) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE entity SET deleted_at = '"
                    + LocalDateTime.now().toString() + "' WHERE uuid = '"
                    + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        entity.setDeletedAt(LocalDateTime.now().toString());
    }
    //TODO: Not so usable for current code.
    protected String execAllStartsWithMethodsPsql(T object, String startsWith) {
        Class<? extends Entity> objectClass = object.getClass();
        Method[] methods = objectClass.getDeclaredMethods();
        String psql = "";
        for (Method method : methods) {
            if (method.getName().startsWith(startsWith) && method.getParameterCount() == 0) {
                System.out.println(objectClass.getSimpleName());
                try {
                    //BUG: Why tf it doesn't work? There are litterary no arguments to pass in getter.
                    psql += ", '" + method.invoke(object) + "'";
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                try {
                    psql += ", " + method.invoke(object);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return psql;

    }

}
