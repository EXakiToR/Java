package EshopDB.orm.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import EshopDB.orm.entities.Product;
import EshopDB.orm.repository.Repository;

public class ProductRepository extends Repository {

    private static ProductRepository instance;

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public void create(Product product) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("INSERT INTO products VALUES("
                    + product.getId() + ", '"
                    + product.getName() + "', '"
                    + product.getImage() + "'" +
                    ")");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Product readById(int id) {
        Product product = null;
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM products WHERE id = " + id);
            rs.next();
            product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> readByMultipleId(int[] id) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < id.length; i++) {
            products.add(readById(id[i]));
        }
        return products;
    }

    public List<Product> readAll() {
        List<Product> product = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                product.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return product;
    }

    public void update(Product product) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("UPDATE products SET name = '"
                    + product.getName() + "', image = '"
                    + product.getImage() + "' WHERE id = "
                    + product.getId());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void delete(Product product) {
        deleteById(product.getId());
    }

    public void deleteMultiple(List<Product> products) {
        for (Product product : products) {
            delete(product);
        }

    }

    public void deleteById(int id) {
        try (Statement st = conn.createStatement()) {
            st.executeUpdate("DELETE FROM products WHERE id = " + id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deleteByMultipleId(int[] id) {
        for (int i = 0; i < id.length; i++) {
            deleteById((id[i]));
        }
    }
}
