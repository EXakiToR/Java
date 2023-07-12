package eshop.repositorypattern;

import java.util.ArrayList;
import java.util.List;

public abstract class ItemRepository {
    private List<Item<Product>> items;

    public ItemRepository() {
        items = new ArrayList<>();
    }

    public List<Item<Product>> getItems() {
        return items;
    }

    public void setItems(List<Item<Product>> items) {
        this.items = items;
    }

    public void addItem(Item<Product> item) {
        if (item == null) {
            throw new NullPointerException("Cannot add null item!");
        }
        items.add(item);
    }

    public void removeItem(Item<Product> item) {
        if (item == null) {
            throw new NullPointerException("Cannot remove null item!");
        }
        items.remove(item);
    }

    public Item<Product> getItemById(Integer id) {
        int index = indexById(id);
        if (index != -1) {
            return items.get(index);
        }
        System.err.println("Id " + id + " not found.");
        return null;
    }

    public void removeItemById(Integer id) {
        int index = indexById(id);
        if (index != -1) {
            items.remove(index);
            return;
        }
        throw new IllegalArgumentException("Item with ID " + id + " not found.");
    }

    public Integer increaseQuantity(Item<Product> item, Integer quantity) {

        item.setQuantity(item.getQuantity() + quantity);
        System.out.println(getItemObjectName(item) + "'s quantity was increased by " + quantity);
        return quantity;
    }

    public Integer decreaseQuantity(Item<Product> item, Integer quantity) {

        int validQuantity = item.getQuantity() - 1;
        if (validDifference(item, quantity)) {
            validQuantity = quantity;
            item.setQuantity(item.getQuantity() - validQuantity);
            System.out.println(getItemObjectName(item) + "'s quantity was decreased by " + validQuantity);
        } else {
            item.setQuantity(1);
            System.out.println(getItemObjectName(item) + "'s cart quantity was set to 1. Can't decrease more than "
                    + validQuantity);
        }
        return validQuantity;
    }

    protected String getItemObjectName(Item<Product> item) {
        return item.getObject().getName();
    }

    protected boolean validDifference(Item<Product> item, Integer quantity) {
        return item.getQuantity() - quantity > 0;
    }

    private int indexById(Integer id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getObject().getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "\n\t[items=" + items + "]";
    }

}
