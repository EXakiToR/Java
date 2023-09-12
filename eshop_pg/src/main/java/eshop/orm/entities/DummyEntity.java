package eshop.orm.entities;

public class DummyEntity extends Entity{
    private String name;

    public DummyEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
