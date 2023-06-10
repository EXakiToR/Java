package eshop;

public class Phone extends Product implements ProductInterface {
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
