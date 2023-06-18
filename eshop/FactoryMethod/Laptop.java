package eshop.FactoryMethod;

public class Laptop extends eshop.FactoryMethod.Product implements ProductInterface {
    private String CPU;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String cPU) {
        CPU = cPU;
    }

    @Override
    public String toString() {
        return "Laptop [name=" + getName() + ", price=" + getPrice() + ", CPU=" + getCPU() + "]";
    }

}
