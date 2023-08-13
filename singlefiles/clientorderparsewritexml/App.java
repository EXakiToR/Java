
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class App {
    static String entry = "products.xml";
    static String output = "order.xml";

    public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException,
            TransformerFactoryConfigurationError, TransformerException {

        List<Product> restaurantProducts = parseXml(entry);

        System.out.println("Welcome to restaurant!");
        Scanner readConsole = new Scanner(System.in);
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
        
        updateRestaurantProductsXml(entry, restaurantProducts);
        generateOrderXml(output, order);
    }

    public static List<Product> parseXml(String pathToFile)
            throws SAXException, IOException, ParserConfigurationException {
        NodeList productsXml = getDocumentRootElement(pathToFile).getElementsByTagName("product");
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= productsXml.getLength(); i++) {
            Element productXml = (Element) productsXml.item(i - 1);
            products.add(new Product(i, getTextFromElement(productXml, "name"),
                    new Money(Integer.parseInt(getTextFromElement(productXml, "amount")),
                            getTextFromElement(productXml, "currency")),
                    Integer.parseInt(getTextFromElement(productXml, "available"))));
        }
        return products;
    }

    public static void updateRestaurantProductsXml(String pathToFile, List<Product> products) throws SAXException, IOException,
            ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
        Element root = getDocumentRootElement(pathToFile);
        NodeList productsXml = root.getElementsByTagName("product");
        for (int i = 0; i < productsXml.getLength(); i++) {
            Element productXml = (Element) productsXml.item(i);
            setTextToElement(productXml, "available", "" + products.get(i).getQuantity());
        }
        writeXml(pathToFile, root.getOwnerDocument());
        System.out.println("\tFile " + pathToFile + " was updated:\n" + products);
    }

    public static void generateOrderXml(String outputFilePath, Order order) throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        //Too monotonous
        Element 
        root = document.createElement("order"),
        client = document.createElement("client"),
        clientName = document.createElement("name"),
        phone = document.createElement("phone"),
        items = document.createElement("items"),
        total = document.createElement("total"),
        amount = document.createElement("amount"),
        currency = document.createElement("currency");


        clientName.setTextContent(order.getClient().getName());
        phone.setTextContent(order.getClient().getPhone());
        amount.setTextContent("" + order.getTotal());
        currency.setTextContent(order.getItems().get(0).getPrice().getCurrency());
        for (Product product : order.getItems()) {
            Element
            item = document.createElement("item"),
            productId = document.createElement("product_id"),
            itemName = document.createElement("product_name"),
            quantity = document.createElement("quantity");
            productId.setTextContent("" + product.getId());
            itemName.setTextContent(product.getName());
            quantity.setTextContent("" + product.getQuantity());
            items.appendChild(item);
            item.appendChild(productId);
            item.appendChild(itemName);
            item.appendChild(quantity);
        }
        document.appendChild(root);
        root.appendChild(client);
        root.appendChild(items);
        root.appendChild(total);

        client.appendChild(clientName);
        client.appendChild(phone);

        total.appendChild(amount);
        total.appendChild(currency);
        writeXml(outputFilePath, document);
        System.out.println("\tFile " + outputFilePath + " was created with following data:\n" + order);
    }
    public static void writeXml(String filePath, Document document) throws TransformerFactoryConfigurationError, TransformerException{
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        if(!filePath.equals(entry)){
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        }
        Source src = new DOMSource(document);

        Result target = new StreamResult(new File(filePath));
        transformer.transform(src, target);
    }
    public static Element getDocumentRootElement(String pathToFile)
            throws SAXException, IOException, ParserConfigurationException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(pathToFile));
        return document.getDocumentElement();
    }

    public static String getTextFromElement(Element element, String tagName) {
        return element.getElementsByTagName(tagName).item(0).getTextContent().trim();
    }

    public static void setTextToElement(Element element, String tagName, String text) {
        element.getElementsByTagName(tagName).item(0).setTextContent(text);
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