package eshop.repositorypattern;

public final class Cart extends ItemRepository {
    private Client owner;
    private Money total;
    private ItemRepository stock;

    public Cart(Client owner, ItemRepository stock) {
        this.stock = stock;
        this.owner = owner;
        this.total = new Money(0, null);
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
    public void addItem(Item<Product> item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot add null item to the cart!");
        }
        updatePriceTotalAmount(item, "+", item.getQuantity());
        total.setCurrency(item.getObject().getPrice().getCurrency());
        super.addItem(item);
        System.out.println(item.getQuantity() + " " + getItemObjectName(item) + " added to the cart.");
    }

    @Override
    public void removeItem(Item<Product> item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot remove null item from the cart!");
        }
        updatePriceTotalAmount(item, "-", item.getQuantity());
        super.removeItem(item);
        System.out.println(getItemObjectName(item) + " was removed from cart.");
    }

    @Override
    public void decreaseQuantity(Item<Product> item, Integer quantity) {
        int validQuantity = item.getQuantity() - 1;
        if (validDifference(item, quantity)) {
            validQuantity = quantity;
        } else {
            System.out.println(getItemObjectName(item) + "'s cart quantity was set to 1. Can't decrease more than "
                    + validQuantity);
        }
        super.decreaseQuantity(item, validQuantity);
        updatePriceTotalAmount(item, "-", validQuantity);

    }
    //Very dirty! Code should be optimised.
    @Override
    public void increaseQuantity(Item<Product> item, Integer quantity) {
        Item<Product> stockItem = stock.getItemById(item.getObject().getId());
        int validQuantity = stockItem.getQuantity();
        if (validDifference(stockItem, quantity)) {
            validQuantity = quantity;
        } else {
            System.out.println(getItemObjectName(stockItem) + "'s are out of stock. Can't have more than "
                    + validQuantity);
        }
        
        super.increaseQuantity(item, validQuantity);
        updatePriceTotalAmount(item, "+", validQuantity);
    }

    private Integer getItemPriceAmount(Item<Product> item) {
        return item.getObject().getPrice().getAmount();
    }

    private void updatePriceTotalAmount(Item<Product> item, String operation, Integer quantity) {
        int itemTotalPriceAmount = getItemPriceAmount(item) * quantity;
        Item<Product> stockItem = stock.getItemById(item.getObject().getId());
        if (operation.equals("+")) {
            //Add to cart
            total.setAmount(total.getAmount() + itemTotalPriceAmount);
            //Substract from stock
            stockItem.setQuantity(stockItem.getQuantity() - quantity);
            

        } else if (operation.equals("-")) {
            total.setAmount(total.getAmount() - itemTotalPriceAmount);
            stockItem.setQuantity(stockItem.getQuantity() + quantity);
        }

    }

    @Override
    public String toString() {
        return "Cart [owner=" + owner + ", total=" + total + "]" + super.toString();
    }
}
