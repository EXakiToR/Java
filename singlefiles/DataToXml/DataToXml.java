import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.javafaker.Faker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

public class DataToXml {
    public static void main(String[] args)
            throws ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element productsXml = document.createElement("products");
        document.appendChild(productsXml);
        List<Product> products = new ArrayList<>();
        Faker faker = new Faker();
        
        for (int i = 0; i < 10; i++) {
            products.add(new Product(faker.food().dish(), new Money(faker.number().numberBetween(3, 10), "EUR")));
            document = addProductToXmlDocument(document, productsXml, products.get(i));
        }
        
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        Source src = new DOMSource(document);

        Result file = new StreamResult(new File("products.xml"));
        transformer.transform(src, file);
    }

    public static Document addProductToXmlDocument(Document document, Element elementWhereToAppend, 
    Product desiredProduct)
            throws ParserConfigurationException {
        Element product = document.createElement("product");
        Element name = document.createElement("name");
        Element price = document.createElement("price");
        Element amount = document.createElement("amount");
        Element currency = document.createElement("currency");
        name.setTextContent(desiredProduct.getName());
        amount.setTextContent("" + desiredProduct.getPrice().getAmount());
        currency.setTextContent(desiredProduct.getPrice().getCurrency());
        elementWhereToAppend.appendChild(product);
        product.appendChild(name);
        product.appendChild(price);
        price.appendChild(amount);
        price.appendChild(currency);
        return document;
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
        return "Money [amount=" + amount + ", currency=" + currency + "]\n";
    }

}
