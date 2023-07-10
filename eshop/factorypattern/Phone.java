package eshop.factorypattern;

public class Phone extends eshop.factorypattern.Product implements ProductInterface {
    private float diagonal;

    public float getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Phone [name=" + getName() + ", price=" + getPrice() + ", diagonal=" + diagonal + "]";
    }
}
