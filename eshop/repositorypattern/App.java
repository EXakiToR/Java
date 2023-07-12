package eshop.repositorypattern;

public class App {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Cart cart = new Cart(new Client("Gordon Freeman", "+88005553535"), stock);
        try {
            Product product = new Product(1003, "Crowbar", new Money(100, Money.Currency.MDL));
            stock.addItem(
                    new Item<Product>(
                            product,
                            8));

            Item<Product> crowbar = new Item<Product>(
                    product,
                    3);

            cart.addItem(crowbar);
            cart.increaseQuantity(crowbar, 4);
            cart.decreaseQuantity(crowbar, 2);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        
        System.out.println(stock);
        System.out.println(cart);
    }
}
