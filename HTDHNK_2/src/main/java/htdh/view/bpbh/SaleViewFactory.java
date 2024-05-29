package htdh.view.bpbh;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SaleViewFactory {
    public void showSaleWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sales/create/product/CreateProduct.fxml"));
//        CreateProductController clientController = new CreateProductController();
//        loader.setController(clientController);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/images/sale.png"))));
        stage.setResizable(false);
        stage.setTitle("SALE");
        stage.show();
    }
}
