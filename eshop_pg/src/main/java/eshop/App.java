package eshop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import eshop.orm.entities.DummyEntity;
import eshop.orm.repositories.DummyRepository;

public class App {
    public static void main(String[] args) throws SQLException {
        DummyRepository dr = new DummyRepository();
        DummyEntity de = new DummyEntity("Testing dummy repository with dummy entity.");
        dr.create(de);
        System.out.println(dr.read(de.getUuid()));
        // System.out.println(dr.read(de.getUuid()));
        // de.setName("Testing dummy repository with UPDATED dummy entity.");
        // dr.update(de);
        // // dr.delete(de);
   
        
    }
}
