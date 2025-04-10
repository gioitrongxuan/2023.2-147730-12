package htdh.test.warehousemanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/dhqt/warehousemanagement/ListOfOrderToWarehouseManagementView.fxml"));
        primaryStage.setTitle("List Of Order To WarehouseManagement");
        primaryStage.setScene(new Scene(root, 1110, 740));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
