package eshop;

import java.sql.SQLException;

import eshop.orm.entities.DummyEntity;
import eshop.orm.entities.Product;
import eshop.orm.repositories.DummyRepository;
import eshop.orm.repositories.ProductRepository;

public class App {
    public static void main(String[] args) throws SQLException {
        DummyRepository dummyRepository = new DummyRepository();

        // Create a new entity
        DummyEntity entity1 = new DummyEntity("Entity 1");
        dummyRepository.create(entity1);
        
        dummyRepository.read(entity1);

        dummyRepository.update(entity1);

        dummyRepository.delete(entity1);
    }
}
