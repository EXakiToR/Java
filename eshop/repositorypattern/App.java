package eshop.repositorypattern;

public class App {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Product product = new Product(1003, "Crowbar", new Money(100, Money.Currency.MDL));
        stock.addItem(
                new Item<Product>(
                        product,
                        8));

        Cart cart = new Cart(new Client("Gordon Freeman", "+88005553535"), stock);
        Item<Product> crowbar = new Item<Product>(
                product,
                3);

        cart.addItem(crowbar);
        cart.increaseQuantity(crowbar, 7);
        cart.decreaseQuantity(crowbar, 4);
        System.out.println(stock);
        System.out.println(cart);
    }
}
