package eshop;

public class Laptop extends Product implements ProductInterface {
    private String CPU;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String cPU) {
        CPU = cPU;
    }

    @Override
    public String toString() {
        return "Printer [name=" + getName() + ", price=" + getPrice() + ", CPU=" + getCPU() + "]";
    }

}
