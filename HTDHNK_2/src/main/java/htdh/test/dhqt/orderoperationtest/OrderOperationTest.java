package htdh.test.dhqt.orderoperationtest;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfList;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfMerchandise;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;
import htdh.model.actor.sitemodel.Site;
import htdh.controller.actor.dhqt.orderoperationcontroller.OrderOperationController;

public class OrderOperationTest extends Application{

	private static ArrayList<ListOfList> needToOrderList = new ArrayList<ListOfList>();

	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final String ORDEROPERATION_FXML_FILE_PATH = "/fxml/dhqt/OrderOperation.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ORDEROPERATION_FXML_FILE_PATH));
        OrderOperationController orderOperationController = new OrderOperationController(needToOrderList);
		fxmlLoader.setController(orderOperationController);
		Parent root = fxmlLoader.load();
		orderOperationController.setOrderOperationData(needToOrderList);
		
		primaryStage.setTitle("Oder Operation");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {

		Site site1 = new Site("Site A", "Amazon", 5, 10);
        Site site2 = new Site("Site B", "Alibaba", 10, 20);
        Site site3 = new Site("Site C", "Ebay", 20, 43);
        Site site4 = new Site("Site D", "Warlmart", 20, 32);
        Site site5 = new Site("Site E", "Target Corp", 10, 21);
        Site site6 = new Site("Site F", "BestBuy", 13, 21);
        Site site7 = new Site("Site G", "Etsy", 32, 42);
        Site site8 = new Site("Site H", "CostCo", 21, 41);
        Site site9 = new Site("Site J", "Ikea", 20, 34);
        Site site10 = new Site("Site K", "FlipKart", 22, 26);

        // Tạo danh sách các Site
        ArrayList<Site> sites1 = new ArrayList<>();
        sites1.add(site1);
        sites1.add(site2);
        sites1.add(site3);
        sites1.add(site4);
        sites1.add(site5);
        
        ArrayList<Site> sites2 = new ArrayList<>();
        sites2.add(site1);
        sites2.add(site6);
        sites2.add(site3);
        sites2.add(site4);
        sites2.add(site7);
        
        ArrayList<Site> sites3 = new ArrayList<>();
        sites2.add(site8);
        sites2.add(site5);
        sites2.add(site2);
        sites2.add(site4);
        sites2.add(site10);
        sites2.add(site9);

        // Tạo đối tượng Merchandise
//        public Merchandise(String name, ArrayList<Site> sites, String merchandiseCode, String unit, ArrayList<Integer> quantityOrdered,
//   			 ArrayList<String> deliveryMean, String orderOfSale, String needOrderedQuantity,
//   			String orderSentDate, String desiredDeliveryDate)
        Merchandise merchandise1 = new Merchandise("Asus laptop", sites3, "M001", "Unit1", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise2 = new Merchandise("Acer laptop", sites1, "M002", "Unit2", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise3 = new Merchandise("Toy's story", sites1, "M003", "Unit3", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise4 = new Merchandise("Panasonic Fridge", sites2, "M004", "Unit1", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise5 = new Merchandise("Iphone 13 pro max", sites2, "M005", "Unit3", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise6 = new Merchandise("Iphone 14 promax", sites3, "M006", "Unit2", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise7 = new Merchandise("Samsung S22 ultra", sites1, "M007", "Unit6", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise8 = new Merchandise("Havit airpod", sites3, "M008", "Unit2", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise9 = new Merchandise("Caculus Master", sites2, "M009", "Unit3", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise10 = new Merchandise("Vinfast car", sites3, "M0010", "Unit8", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise11 = new Merchandise("CAT Truck", sites3, "M0011", "Unit6", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27", new ArrayList<String>());
        Merchandise merchandise12 = new Merchandise("Ipad", sites2, "M0012", "Unit8", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-05-27",new ArrayList<String>());
        Merchandise merchandise13 = new Merchandise("Akko mechanical keyboard", sites2, "M0013", "Unit5", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-06-01", new ArrayList<String>());
        Merchandise merchandise14 = new Merchandise("Mark Ryden Bag", sites1, "M0014", "Unit6", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-06-01", new ArrayList<String>());
        Merchandise merchandise15 = new Merchandise("Custom cable", sites1, "M0015", "Unit4", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-06-01", new ArrayList<String>());
        Merchandise merchandise16 = new Merchandise("Macbook Air", sites2, "M0016", "Unit3", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-06-01", new ArrayList<String>());
        Merchandise merchandise17 = new Merchandise("Mac Vision", sites2, "M0017", "Unit7", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 1000", 250, "2024-06-01", new ArrayList<String>());
        
        Merchandise merchandise18 = new Merchandise("Asus laptop", sites3, "M001", "Unit1", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-21", new ArrayList<String>());
        Merchandise merchandise19 = new Merchandise("AlienWare laptop", sites3, "M321", "Unit1", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-21", new ArrayList<String>());
        Merchandise merchandise20 = new Merchandise("Toy's story", sites3, "M003", "Unit3", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-21", new ArrayList<String>());
        Merchandise merchandise21 = new Merchandise("Panasonic Fridge", sites2, "M004", "Unit1", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-21", new ArrayList<String>());
        Merchandise merchandise22 = new Merchandise("Iphone 13 pro max", sites2, "M005", "Unit3", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-21", new ArrayList<String>());
        Merchandise merchandise23 = new Merchandise("Iphone 14 promax", sites3, "M006", "Unit2", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-21", new ArrayList<String>());
        Merchandise merchandise24 = new Merchandise("Samsung S22 ultra", sites1, "M007", "Unit6", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-21", new ArrayList<String>());
        
        Merchandise merchandise25 = new Merchandise("Havit airpod", sites3, "M008", "Unit2", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-25", new ArrayList<String>());
        Merchandise merchandise26 = new Merchandise("Caculus Master", sites2, "M009", "Unit3", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-25", new ArrayList<String>());
        Merchandise merchandise27 = new Merchandise("Vinfast car", sites3, "M0010", "Unit8", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-25", new ArrayList<String>());
        Merchandise merchandise28 = new Merchandise("CAT Truck", sites3, "M0011", "Unit6", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-25", new ArrayList<String>());
        Merchandise merchandise29 = new Merchandise("Ipad", sites2, "M0012", "Unit8", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-25", new ArrayList<String>());
        
        Merchandise merchandise30 = new Merchandise("Akko mechanical keyboard", sites2, "M0013", "Unit5", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-13", new ArrayList<String>());
        Merchandise merchandise31 = new Merchandise("Mark Ryden Bag", sites1, "M0014", "Unit6", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-13", new ArrayList<String>());
        Merchandise merchandise32 = new Merchandise("Custom cable", sites1, "M0015", "Unit4", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-13", new ArrayList<String>());
        Merchandise merchandise33 = new Merchandise("Macbook Air", sites2, "M0016", "Unit3", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-13", new ArrayList<String>());
        Merchandise merchandise34 = new Merchandise("Mac Vision", sites2, "M0017", "Unit7", new ArrayList<Integer>(), new ArrayList<String>(), "BPBH 2000", 250, "2024-06-13", new ArrayList<String>());
        
        ArrayList<Merchandise> merchandises1 = new ArrayList<>();
        merchandises1.add(merchandise1);
        merchandises1.add(merchandise2);
        merchandises1.add(merchandise3);
        merchandises1.add(merchandise4);
        merchandises1.add(merchandise5);
        merchandises1.add(merchandise6);
        merchandises1.add(merchandise7);
        merchandises1.add(merchandise8);
        merchandises1.add(merchandise9);
        merchandises1.add(merchandise10);
        merchandises1.add(merchandise11);
        merchandises1.add(merchandise12);
        
        ArrayList<Merchandise> merchandises2 = new ArrayList<>();
        merchandises2.add(merchandise13);
        merchandises2.add(merchandise14);
        merchandises2.add(merchandise15);
        merchandises2.add(merchandise16);
        merchandises2.add(merchandise17);
        
        ArrayList<Merchandise> merchandises3 = new ArrayList<>();
        merchandises3.add(merchandise18);
        merchandises3.add(merchandise19);
        merchandises3.add(merchandise20);
        merchandises3.add(merchandise21);
        merchandises3.add(merchandise22);
        merchandises3.add(merchandise23);
        merchandises3.add(merchandise24);
        
        ArrayList<Merchandise> merchandises4 = new ArrayList<>();
        merchandises4.add(merchandise25);
        merchandises4.add(merchandise26);
        merchandises4.add(merchandise27);
        merchandises4.add(merchandise28);
        merchandises4.add(merchandise29);
        
        ArrayList<Merchandise> merchandises5 = new ArrayList<>();
        merchandises5.add(merchandise30);
        merchandises5.add(merchandise31);
        merchandises5.add(merchandise32);
        merchandises5.add(merchandise33);
        merchandises5.add(merchandise34);

        ListOfMerchandise listOfMerchandise1 = new ListOfMerchandise("List of list 1", "List 1", merchandises1);
        ListOfMerchandise listOfMerchandise2 = new ListOfMerchandise("List of list 1", "List 2", merchandises2);
        ListOfMerchandise listOfMerchandise3 = new ListOfMerchandise("List of list 2", "List 1", merchandises3);
        ListOfMerchandise listOfMerchandise4 = new ListOfMerchandise("List of list 2", "List 2", merchandises4);
        ListOfMerchandise listOfMerchandise5 = new ListOfMerchandise("List of list 2", "List 3", merchandises5);
        
        
        
        
        ArrayList<ListOfMerchandise> listOfListOfMerchandise1 = new ArrayList<>();
        listOfListOfMerchandise1.add(listOfMerchandise1);
        listOfListOfMerchandise1.add(listOfMerchandise2);
        
        ArrayList<ListOfMerchandise> listOfListOfMerchandise2 = new ArrayList<>();
        listOfListOfMerchandise2.add(listOfMerchandise3);
        listOfListOfMerchandise2.add(listOfMerchandise4);
        listOfListOfMerchandise2.add(listOfMerchandise5);

        ListOfList listOfList1 = new ListOfList("BPBH 1000", listOfListOfMerchandise1);
        ListOfList listOfList2 = new ListOfList("BPBH 2000", listOfListOfMerchandise2);
        
        needToOrderList.add(listOfList1);
        needToOrderList.add(listOfList2);
		launch(args);
	}

}
