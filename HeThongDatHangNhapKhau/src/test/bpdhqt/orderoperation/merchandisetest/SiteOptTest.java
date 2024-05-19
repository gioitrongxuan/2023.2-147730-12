package test.bpdhqt.orderoperation.merchandisetest;

import java.util.ArrayList;

import controller.bpdhqt.orderoperation.merchandisecontroller.MerchandiseSiteOptController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;
import model.sitemodel.Site;
public class SiteOptTest extends Application {
	
	private static Merchandise merchandise;
	private static Site site;
	private int i = 1;
	
	public void start(Stage primaryStage) throws Exception {
		Site site1 = new Site("Site A");
        Site site2 = new Site("Site B");
        Site site3 = new Site("Site C");

        // Tạo danh sách các Site
        ArrayList<Site> sites = new ArrayList<>();
        sites.add(site1);
        sites.add(site2);
        sites.add(site3);
		merchandise = new Merchandise("Sample merchandise", sites, "M001", "Unit1", 100, "Plane");
		site = site1;
		// TODO Auto-generated method stub
		final String MERCHANDISEOPT_FXML_FILE_PATH = "/view/bpdhqt/orderoperation/merchandiseview/SiteOptionView.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MERCHANDISEOPT_FXML_FILE_PATH));
		MerchandiseSiteOptController merchandiseSiteOptController = new MerchandiseSiteOptController(merchandise, site,1);
		fxmlLoader.setController(merchandiseSiteOptController);
		Parent root = fxmlLoader.load();
//		merchandiseSiteOptController.setData(merchandise, site, i);
		
		primaryStage.setTitle("Merchandise");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
