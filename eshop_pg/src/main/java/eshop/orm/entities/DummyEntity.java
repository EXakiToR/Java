package eshop.orm.entities;

public class DummyEntity extends Entity{
    private String name;

    public DummyEntity(String name) {
        this.name = name;
    }
    
    public DummyEntity() {
    }

    public void setName(String name) {
        this.name = name;
    }
        

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", DummyEntity [name=" + name + "]";
    }
}
