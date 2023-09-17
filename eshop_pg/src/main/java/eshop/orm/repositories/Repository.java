package eshop.orm.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import eshop.orm.entities.Entity;

public abstract class Repository<T extends Entity>{
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
            st.executeUpdate("INSERT INTO entities VALUES('"
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
            st.executeUpdate("UPDATE entities SET read_at = '"
                    + LocalDateTime.now().toString() + "' WHERE uuid = '"
                    + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        entity.setReadAt(LocalDateTime.now().toString());
        return entity;
    }
    //HACK: Just to make the override work
    public T read(String uuid){
        return null;
    }
    public void update(T entity) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE entities SET updated_at = '"
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
            st.executeUpdate("UPDATE entities SET deleted_at = '"
                    + LocalDateTime.now().toString() + "' WHERE uuid = '"
                    + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        entity.setDeletedAt(LocalDateTime.now().toString());
    }
}
