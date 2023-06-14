package eshop;

public class Attribute {
    private String name;
    private PhysicalDimension value;

    public Attribute() {
    }

    public Attribute(String name, PhysicalDimension value) {
        setName(name);
        setValue(value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhysicalDimension getValue() {
        return value;
    }

    public void setValue(PhysicalDimension value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + name + ": " + value + "}";
    }

}
