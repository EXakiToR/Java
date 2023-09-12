package eshop.orm.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.UUID;

import eshop.orm.entities.Entity;

public abstract class Repository<T extends Entity> extends Entity{
    private final String url = "jdbc:postgresql://localhost:5433/eshop?user=postgres&password=postgres&ssl=false";
    protected Connection conn;
    //Abstract logic for Entities in data base needed, only time footprints present
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
                    + entity.getCreatedAt() + "', NULL, NULL, NULL)");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void read(UUID uuid) {
        
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE entities SET read_time = '"
                    + LocalDateTime.now() + "' WHERE uuid = '"
                    + uuid + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void update(T entity) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE entities SET update_time = '"
                    + LocalDateTime.now() + "' WHERE uuid = '"
                    + entity.getUuid() + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delete(UUID uuid) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE entities SET delete_time = '"
                    + LocalDateTime.now() + "' WHERE uuid = '"
                    + uuid + "'");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
