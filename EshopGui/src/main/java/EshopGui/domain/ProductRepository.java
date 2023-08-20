package EshopGui.domain;

public class ProductRepository {
    public Product getTestProduct() {
        return new Product("Test product name",
                "Desc", "/images/testProduct.jpg",
                new Money(10.50f,
                new Currency("US Dollar", "USD", 0, 0.9f)));
    }
}
