package test;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
	public void showListOfOrderToWarehouseManagementView() {
	    // Mã để hiển thị ListOfOrderToWarehouseManagementView.fxml
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListOfOrderToWarehouseManagementView.fxml"));
	        Parent root = loader.load();
	        Stage stage = new Stage();
	        stage.setScene(new Scene(root));
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
