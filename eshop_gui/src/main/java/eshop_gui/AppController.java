package eshop_gui;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import eshop_gui.domain.Money;
import eshop_gui.domain.Product;
import eshop_gui.domain.ProductRepository;
import eshop_gui.services.Bnm;
import eshop_gui.services.PriceTransformer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AppController {
    @FXML
    public HBox content;
    private ProductRepository productRepository;
    private Bnm bnm;
    private PriceTransformer priceTransformer;
    private List<Product> products;
    private Label name, description, priceAmountAndCurrency;
    private ImageView imageView;
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
        products = productRepository.all();
    }

    public void setBnm(Bnm bnm) {
        this.bnm = bnm;
    }

    public void setPriceTransformer(PriceTransformer priceTransformer) {
        this.priceTransformer = priceTransformer;
    }

    public void renderCatalog() throws URISyntaxException, SAXException, IOException, ParserConfigurationException {
        content.getChildren().clear();
        for (Product product : products) {
            VBox container = new VBox();
            name = new Label(product.getName());
            name.setFont(Font.font("Verdana", 25));
            name.setStyle("-fx-text-fill: green;");
            description = new Label(product.getDescription());
            description.setFont(Font.font("Verdana", 15));
            description.setStyle("-fx-text-fill: gray;");
            Money transformedPrice = priceTransformer.transformPrice(product, bnm);
            product.setPrice(transformedPrice);
            priceAmountAndCurrency = new Label(
                    transformedPrice.getFloatAmount() + " " + transformedPrice.getCurrency().getCharCode());
            priceAmountAndCurrency.setFont(Font.font("Arial", 15));
            container.getChildren().addAll(name, description, priceAmountAndCurrency);
            Image image = new Image(getClass().getResource(product.getImage()).toURI().toString(), 200, 200, true,
                    false);
            imageView = new ImageView(image);
            container.getChildren().add(imageView);
            content.getChildren().add(container);
        }
    }
}
