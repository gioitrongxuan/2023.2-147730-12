package htdh.test.dhqt.merchandisetest;

import java.util.ArrayList;

import htdh.controller.actor.dhqt.merchandisecontroller.MerchandiseController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;
import htdh.model.actor.sitemodel.Site;

public class MerchandiseTest extends Application {
	
	private static Merchandise merchandise;
	
	public void start(Stage primaryStage) throws Exception {
//		// TODO Auto-generated method stub
//		final String MERCHANDISE_FXML_FILE_PATH = "/view/bpdhqt/orderoperation/merchandiseview/MerchandiseOverview.fxml";
//		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MERCHANDISE_FXML_FILE_PATH));
//		MerchandiseController merchandiseController = new MerchandiseController(merchandise);
//		fxmlLoader.setController(merchandiseController);
//		Parent root = fxmlLoader.load();
//		merchandiseController.setMerchandiseData(merchandise);
//		
//		primaryStage.setTitle("Merchandise");
//		primaryStage.setScene(new Scene(root));
//		primaryStage.show();
	}
	
	public static void main(String[] args) {
//		Site site1 = new Site("Site A");
//        Site site2 = new Site("Site B");
//        Site site3 = new Site("Site C");
//        Site site4 = new Site("Site D");
//        Site site5 = new Site("Site E");
//
//        // Tạo danh sách các Site
//        ArrayList<Site> sites = new ArrayList<>();
//        sites.add(site1);
//        sites.add(site2);
//        sites.add(site3);
//        sites.add(site4);
//        sites.add(site5);
//
//        // Tạo đối tượng Merchandise
//        ArrayList<String> means = new ArrayList<String>();
//        ArrayList<Integer> orderedMerchandiseQuantity = new ArrayList<Integer>(0);
//        merchandise = new Merchandise("Asus laptop", sites, "M001", "Unit1", orderedMerchandiseQuantity, means);
		launch(args);
	}
}
