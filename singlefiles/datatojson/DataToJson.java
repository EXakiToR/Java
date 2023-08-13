import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class DataToJson {
    public static void main(String[] args) throws IOException {
        Faker faker = new Faker();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutFilePath = "products.json";
        FileWriter writer = new FileWriter(jsonOutFilePath);
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            products.add(new Product(faker.food().dish(), new Money(faker.number().numberBetween(3, 10), "EUR")));
            
        }
        gson.toJson(products, writer);
        writer.close();
        System.out.println("Data written to " + jsonOutFilePath + " file successfully.");
    }

}

class Product {
    private String name;
    private Money price;

    public Product(String name, Money price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }

}

class Money {
    @SerializedName("amount")
    private int centAmount;
    private String currency;

    public Money(int amount, String currency) {
        this.centAmount = amount;
        this.currency = currency;
    }

    public int getCentAmount() {
        return centAmount;
    }

    public void setCentAmount(int amount) {
        this.centAmount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    private String format(int centAmount){

        return centAmount / 100 + "." + centAmount % 100;
    }
    @Override
    public String toString() {
        return "Money [amount=" + format(centAmount) + ", currency=" + currency + "]\n";
    }

}
