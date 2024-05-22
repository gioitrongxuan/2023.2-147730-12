package test.bpdhqt.orderoperation.merchandisetest;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.bpdhqt.orderoperation.merchandisecontroller.MerchandiseController;
import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;
import model.sitemodel.Site;

public class MerchandiseTest extends Application {
	private static Merchandise merchandise;
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String LISTMERCHANDISE_FXML_FILE_PATH = "/view/bpdhqt/orderoperation/merchandiseview/merchandiseoverview.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(LISTMERCHANDISE_FXML_FILE_PATH));
		MerchandiseController merchandiseController = new MerchandiseController(merchandise);
		fxmlLoader.setController(merchandiseController);
		Parent root = fxmlLoader.load();
		merchandiseController.setMerchandiseData(merchandise);
		
		primaryStage.setTitle("Merchandise");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Site site1 = new Site("Site A");
        Site site2 = new Site("Site B");
        Site site3 = new Site("Site C");

        // Tạo danh sách các Site
        ArrayList<Site> sites = new ArrayList<>();
        sites.add(site1);
        sites.add(site2);
        sites.add(site3);

        // Tạo đối tượng Merchandise
        Merchandise merchandise = new Merchandise();
        merchandise.setName("Sample Merchandise");
        merchandise.setSites(sites);
        merchandise.setMerchandiseCode("M001");
        merchandise.setUnit("Unit1");
        merchandise.setQuantityOrdered(100);
        merchandise.setDeliveryMean("Air");
		launch(args);
	}
}
