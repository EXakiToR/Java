import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class App {
    static String entry = "products.json";
    static String output = "order.json";

    public static void main(String[] args) throws IOException {
        List<Product> restaurantProducts = parseJson(entry);

        System.out.println("Welcome to restaurant!");
        try (Scanner readConsole = new Scanner(System.in)) {
            int clientQuantity, choice;
            Order order = new Order();
            String answ;
            boolean validId;
            while (true) {
                validId = false;
                System.out.print("\tChoose the id of your dish:\n" + restaurantProducts + "\n>> id ");
                choice = readConsole.nextInt();
                readConsole.nextLine();
                for (Product product : restaurantProducts) {
                    if (product.getId() == choice) {
                        validId = true;
                        System.out.print("How much?\n>> quantity ");
                        clientQuantity = readConsole.nextInt();
                        readConsole.nextLine();
                        if (product.getQuantity() >= clientQuantity) {
                            order.addProduct(product, clientQuantity);
                            break;
                        } else {
                            System.err.println("Available " + product.getQuantity());
                        }
                    }
                }
                if (!validId) {
                    System.err.println("Invalid id!");
                    continue;
                }
                System.out.print("Is that all? (yes/any key - no)\n>> ");
                answ = readConsole.next().toLowerCase();
                readConsole.nextLine();
                if (answ.equals("yes") || answ.equals("y")) {
                    break;
                }
            }
            System.out.print("Enter your name: ");
            order.getClient().setName(readConsole.nextLine());
            System.out.print("Enter your phone number: ");
            order.getClient().setPhone(readConsole.nextLine());

            updateRestaurantProductsJson(entry, restaurantProducts);
            generateOrderJson(output, order);
        }
    }

    public static List<Product> parseJson(String pathToFile) throws IOException {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(new FileReader(pathToFile), JsonObject.class);
        return gson.fromJson(jsonObject.getAsJsonArray("products"), new TypeToken<List<Product>>() {
        }.getType());
    }

    public static void updateRestaurantProductsJson(String pathToFile, List<Product> products) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject productsJsonObject = new JsonObject();
        JsonArray productsArray = gson.toJsonTree(products).getAsJsonArray();
        productsJsonObject.add("products", productsArray);

        try (FileWriter writer = new FileWriter(pathToFile)) {
            gson.toJson(productsJsonObject, writer);
        }
        System.out.println("\tFile " + pathToFile + " was updated:\n" + products);
    }

    public static void generateOrderJson(String outputFilePath, Order order) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(order);
        FileWriter writer = new FileWriter(outputFilePath);
        writer.write(json);
        writer.close();
        System.out.println("\tFile " + outputFilePath + " was created with following data:\n" + order);
    }
}

class Order {
    private List<Product> items;
    private Client client;
    private int total;

    public Order() {
        items = new ArrayList<>();
        client = new Client();
    }

    public void addProduct(Product product, int quantity) {
        // If client decided to order the same product several times, just increase
        // quantity.
        for (Product ordered : items) {
            if (ordered.getName().equals(product.getName())) {
                ordered.setQuantity(ordered.getQuantity() + quantity);
                product.setQuantity(product.getQuantity() - quantity);
                total += ordered.getPrice().getAmount() * quantity;
                return;
            }
        }
        // Make a copy of ordered product to put it in ordered items.
        Product copy = product.clone();
        items.add(copy);
        total += copy.getPrice().getAmount() * quantity;
        copy.setQuantity(quantity);
        product.setQuantity(product.getQuantity() - quantity);
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order [items=" + items + ", client=" + client + ", total=" + total + "]";
    }

}

class Client {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client [name=" + name + ", phone=" + phone + "]";
    }

}

class Product implements Cloneable {
    private int id;
    private String name;
    private Money price;
    @SerializedName("available")
    private int quantity;

    public Product(int id, String name, Money price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public Product clone() {
        try {
            Product copy = (Product) super.clone();
            copy.price = new Money(price.getAmount(), price.getCurrency());
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]\n";
    }

}

class Money {
    private int amount;
    private String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Money [amount=" + amount + ", currency=" + currency + "]";
    }

}