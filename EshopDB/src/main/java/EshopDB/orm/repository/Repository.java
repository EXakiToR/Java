package EshopDB.orm.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Repository {
    private final String url = "jdbc:postgresql://localhost/eshop?user=postgres&password=postgres&ssl=false";
    protected Connection conn;

    public Repository() {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
