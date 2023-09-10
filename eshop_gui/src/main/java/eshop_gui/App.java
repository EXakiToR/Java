package eshop_gui;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import eshop_gui.domain.ProductRepository;
import eshop_gui.services.Bnm;
import eshop_gui.services.CurrencyService;
import eshop_gui.services.PriceTransformer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private ProductRepository productRepository;
    private Bnm bnm;
    private PriceTransformer priceTransformer;

    private void loadServices() {
        productRepository = new ProductRepository();
        bnm = Bnm.getInstance();
        priceTransformer = new PriceTransformer();
    }

    @Override
    public void start(Stage stage) throws URISyntaxException {
        try {
            loadServices();
            URL fxmlURL = getClass().getResource("/fxml/layout.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlURL);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            AppController appController = loader.getController();
            appController.setProductRepository(productRepository);
            appController.setBnm(bnm);
            appController.setPriceTransformer(priceTransformer);
            MenuBar menuBar = (MenuBar) root.getChildrenUnmodifiable().get(0);
            Menu menu = new Menu(bnm.getActiveCurrency());
            menuBar.getMenus().add(menu);
            for (String currencyCharCode : bnm.getSelectedcurrencies()) {
                MenuItem menuItem = new MenuItem(currencyCharCode);
                menu.getItems().add(menuItem);
                menuItem.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        String activeCurrency = ((MenuItem) event.getTarget()).getText();
                        bnm.setActiveCurrency(activeCurrency);
                        menu.setText(activeCurrency);
                        try {
                            appController.renderCatalog();
                        } catch (URISyntaxException | SAXException | IOException | ParserConfigurationException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                });
            }
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}