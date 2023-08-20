package EshopGui;

import EshopGui.domain.Product;
import EshopGui.domain.ProductRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AppController {
    @FXML
    public HBox content;
    private ProductRepository productRepository;
    
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void renderCatalog(){
        Product product = productRepository.getTestProduct();
        VBox container = new VBox();
        Label nameLabel = new Label(product.getName());
        Label descriptionLabel = new Label(product.getDescription());
        container.getChildren().add(nameLabel);
        container.getChildren().add(descriptionLabel);
        Image image = new Image(product.getImage());
        ImageView imageView = new ImageView(image);
        container.getChildren().add(imageView);
        content.getChildren().add(container);
        
    }
}
