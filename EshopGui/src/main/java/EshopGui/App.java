package EshopGui;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import EshopGui.domain.Product;
import EshopGui.domain.ProductRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    public static Product product = new Product("Produs D/BR", "Produs de branza", "S", null);
    @Override
    public void start(Stage stage) {
        try {
            URL fxmlURL = getClass().getResource("/fxml/layout.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlURL);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            AppController appController = loader.getController();
            appController.setProductRepository(new ProductRepository());
            stage.setScene(scene);
            stage.show();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}