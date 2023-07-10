package eshop.repositorypattern;

public class Item<T> {
    private T object;
    private Integer quantity;

    public Item(T object, Integer quantity) {
        this.object = object;
        this.quantity = quantity;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item [object=" + object + ", quantity=" + quantity + "]";
    }

}
