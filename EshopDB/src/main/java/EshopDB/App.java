package EshopDB;

import java.sql.SQLException;

import EshopDB.orm.entities.Product;
import EshopDB.orm.repositories.ProductRepository;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws SQLException {
        ProductRepository pr = ProductRepository.getInstance();
        Product product = new Product(1, "Test", "img.jpg");
        pr.insert(product);
        product.setName("Test2");
        product.setId(2);
        pr.insert(product);
        pr.update(product);
        System.out.println(pr.readAll());
        System.out.println(pr.readByMultipleId(new int[] { 1, 2 }));
        pr.deleteByMultipleId(new int[] { 1, 2 });
    }
}