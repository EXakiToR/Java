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
        super.addItem(item);
        updatePriceTotalAmount(item, "+", item.getQuantity());
        total.setCurrency(item.getObject().getPrice().getCurrency());
        System.out.println(item.getQuantity() + " " + getItemObjectName(item) + " added to the cart.");
    }

    @Override
    public void removeItem(Item<Product> item) {
        super.removeItem(item);
        updatePriceTotalAmount(item, "-", item.getQuantity());

        System.out.println(getItemObjectName(item) + " was removed from cart.");
    }

    // Still should be optimized, along with ItemRepository's methods
    @Override
    public Integer increaseQuantity(Item<Product> item, Integer quantity) {
        if (item == null) {
            throw new NullPointerException("Cannot increase quantity of null item!");
        } else if (quantity.equals(null)) {
            throw new NullPointerException("Cannot increase quantity by null!");
        } else if (quantity < 0) {
            throw new IllegalArgumentException("Cannot take negative quantity to increase!");
        }

        Item<Product> stockItem = stock.getItemById(item.getObject().getId());
        int validQuantity = stockItem.getQuantity();
        if (validDifference(stockItem, quantity)) {
            validQuantity = quantity;
        } else {
            System.out.println(getItemObjectName(stockItem) + "'s are out of stock. Can't have more than "
                    + validQuantity);
        }
        updatePriceTotalAmount(item, "+", super.increaseQuantity(item, validQuantity));
        return null;
    }

    @Override
    public Integer decreaseQuantity(Item<Product> item, Integer quantity) {
        if (item == null) {
            throw new NullPointerException("Cannot decrease quantity of null item!");
        } else if (quantity.equals(null)) {
            throw new NullPointerException("Cannot decrease quantity by null!");
        } else if (quantity < 0) {
            throw new IllegalArgumentException("Cannot take negative quantity to decrease!");
        }
        updatePriceTotalAmount(item, "-", super.decreaseQuantity(item, quantity));
        return null;
    }

    private void updatePriceTotalAmount(Item<Product> item, String operation, Integer quantity) {
        int itemTotalPriceAmount = getItemPriceAmount(item) * quantity;
        Item<Product> stockItem = stock.getItemById(item.getObject().getId());

        if (operation.equals("+")) {
            // Add to cart
            total.setAmount(total.getAmount() + itemTotalPriceAmount);
            // Substract from stock
            stockItem.setQuantity(stockItem.getQuantity() - quantity);

        } else if (operation.equals("-")) {
            total.setAmount(total.getAmount() - itemTotalPriceAmount);
            stockItem.setQuantity(stockItem.getQuantity() + quantity);
        }

    }

    private Integer getItemPriceAmount(Item<Product> item) {
        return item.getObject().getPrice().getAmount();
    }

    @Override
    public String toString() {
        return "Cart [owner=" + owner + ", total=" + total + "]" + super.toString();
    }
}
