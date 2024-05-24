package htdh.view.dhqt;

import java.util.ArrayList;

import htdh.controller.actor.dhqt.DHQTController;
import htdh.controller.actor.dhqt.orderoperationcontroller.OrderOperationController;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfList;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfMerchandise;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;
import htdh.model.actor.sitemodel.Site;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType;
    private static ArrayList<ListOfList> needToOrderList = new ArrayList<ListOfList>();

    //ClientView
    private final ObjectProperty<BPDHQTMenuOptions> clientSelectedMenuItem ;
    private AnchorPane dashboardView;
    private AnchorPane orderManagement;
    private VBox orderOperation;
//     AdminView
//    ....
    public  ViewFactory(){
        this.loginAccountType = AccountType.BPDHQT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
//        this.adminSelectedMenuItem..

    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<BPDHQTMenuOptions> getClientSelectedMenuItem(){
        return clientSelectedMenuItem;

    }


    public AnchorPane getDashboardView() {
       if (dashboardView == null) {
           try{
                dashboardView = new FXMLLoader(getClass().getResource("/fxml/dhqt/Dashboard.fxml")).load();
           }catch (Exception e) {
               e.printStackTrace();
           }
       }
       return dashboardView;
    }
    public AnchorPane getOrderManagement() {
        if (orderManagement == null) {
            try{
                orderManagement = new FXMLLoader(getClass().getResource("/fxml/dhqt/OrderList.fxml")).load();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orderManagement;
    }
    
    public VBox getPhanDuc() {
        if (orderOperation == null) {
            try{
        		Site site1 = new Site("Site A");
                Site site2 = new Site("Site B");
                Site site3 = new Site("Site C");
                Site site4 = new Site("Site D");
                Site site5 = new Site("Site E");
                Site site6 = new Site("Site F");
                Site site7 = new Site("Site G");
                Site site8 = new Site("Site H");
                Site site9 = new Site("Site J");
                Site site10 = new Site("Site K");

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
                Merchandise merchandise1 = new Merchandise("Asus laptop", sites3, "M001", "Unit1", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise2 = new Merchandise("Acer laptop", sites1, "M002", "Unit2", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise3 = new Merchandise("Toy's story", sites1, "M003", "Unit3", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise4 = new Merchandise("Panasonic Fridge", sites2, "M004", "Unit1", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise5 = new Merchandise("Iphone 13 pro max", sites2, "M005", "Unit3", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise6 = new Merchandise("Iphone 14 promax", sites3, "M006", "Unit2", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise7 = new Merchandise("Samsung S22 ultra", sites1, "M007", "Unit6", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise8 = new Merchandise("Havit airpod", sites3, "M008", "Unit2", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise9 = new Merchandise("Caculus Master", sites2, "M009", "Unit3", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise10 = new Merchandise("Vinfast car", sites3, "M0010", "Unit8", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise11 = new Merchandise("CAT Truck", sites3, "M0011", "Unit6", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise12 = new Merchandise("Ipad", sites2, "M0012", "Unit8", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise13 = new Merchandise("Akko mechanical keyboard", sites2, "M0013", "Unit5", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise14 = new Merchandise("Mark Ryden Bag", sites1, "M0014", "Unit6", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise15 = new Merchandise("Custom cable", sites1, "M0015", "Unit4", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise16 = new Merchandise("Macbook Air", sites2, "M0016", "Unit3", new ArrayList<Integer>(), new ArrayList<String>());
                Merchandise merchandise17 = new Merchandise("Mac Vision", sites2, "M0017", "Unit7", new ArrayList<Integer>(), new ArrayList<String>());
                ArrayList<Merchandise> merchandises1 = new ArrayList<>();
                merchandises1.add(merchandise1);
                merchandises1.add(merchandise2);
                merchandises1.add(merchandise3);
                merchandises1.add(merchandise4);
                merchandises1.add(merchandise5);
                
                ArrayList<Merchandise> merchandises2 = new ArrayList<>();
                merchandises2.add(merchandise4);
                merchandises2.add(merchandise3);
                merchandises2.add(merchandise7);
                merchandises2.add(merchandise1);
                merchandises2.add(merchandise5);
                
                ArrayList<Merchandise> merchandises3 = new ArrayList<>();
                merchandises3.add(merchandise4);
                merchandises3.add(merchandise5);
                merchandises3.add(merchandise6);
                
                ArrayList<Merchandise> merchandises4 = new ArrayList<>();
                merchandises4.add(merchandise8);
                merchandises4.add(merchandise9);
                merchandises4.add(merchandise10);
                merchandises4.add(merchandise11);
                merchandises4.add(merchandise12);
                merchandises4.add(merchandise13);
                merchandises4.add(merchandise14);
                
                ArrayList<Merchandise> merchandises5 = new ArrayList<>();
                merchandises5.add(merchandise8);
                merchandises5.add(merchandise9);
                merchandises5.add(merchandise10);
                merchandises5.add(merchandise17);
                merchandises5.add(merchandise2);
                merchandises5.add(merchandise15);
                merchandises5.add(merchandise16);

                ListOfMerchandise listOfMerchandise1 = new ListOfMerchandise("List of list 1", "List 1", merchandises1);
                ListOfMerchandise listOfMerchandise2 = new ListOfMerchandise("List of list 1", "List 2", merchandises2);
                ListOfMerchandise listOfMerchandise3 = new ListOfMerchandise("List of list 1", "List 3", merchandises3);
                ListOfMerchandise listOfMerchandise4 = new ListOfMerchandise("List of list 1", "List 4", merchandises4);
                ListOfMerchandise listOfMerchandise5 = new ListOfMerchandise("List of list 1", "List 5", merchandises5);
                
                ListOfMerchandise listOfMerchandise6 = new ListOfMerchandise("List of list 2", "List 1", merchandises1);
                ListOfMerchandise listOfMerchandise7 = new ListOfMerchandise("List of list 2", "List 2", merchandises2);
                ListOfMerchandise listOfMerchandise8 = new ListOfMerchandise("List of list 2", "List 3", merchandises3);
                ListOfMerchandise listOfMerchandise9 = new ListOfMerchandise("List of list 2", "List 4", merchandises4);
                
                ListOfMerchandise listOfMerchandise10 = new ListOfMerchandise("List of list 3", "List 5", merchandises5);
                ListOfMerchandise listOfMerchandise11 = new ListOfMerchandise("List of list 3", "List 1", merchandises1);
                ListOfMerchandise listOfMerchandise12 = new ListOfMerchandise("List of list 3", "List 2", merchandises2);
                ListOfMerchandise listOfMerchandise13 = new ListOfMerchandise("List of list 3", "List 3", merchandises3);
                ListOfMerchandise listOfMerchandise14 = new ListOfMerchandise("List of list 3", "List 4", merchandises4);
                ListOfMerchandise listOfMerchandise15 = new ListOfMerchandise("List of list 3", "List 5", merchandises5);
                
                
                ArrayList<ListOfMerchandise> listOfListOfMerchandise1 = new ArrayList<>();
                listOfListOfMerchandise1.add(listOfMerchandise1);
                listOfListOfMerchandise1.add(listOfMerchandise2);
                listOfListOfMerchandise1.add(listOfMerchandise3);
                listOfListOfMerchandise1.add(listOfMerchandise4);
                listOfListOfMerchandise1.add(listOfMerchandise5);
                
                ArrayList<ListOfMerchandise> listOfListOfMerchandise2 = new ArrayList<>();
                listOfListOfMerchandise2.add(listOfMerchandise6);
                listOfListOfMerchandise2.add(listOfMerchandise7);
                listOfListOfMerchandise2.add(listOfMerchandise8);
                listOfListOfMerchandise2.add(listOfMerchandise9);
                
                ArrayList<ListOfMerchandise> listOfListOfMerchandise3 = new ArrayList<>();
                listOfListOfMerchandise3.add(listOfMerchandise10);
                listOfListOfMerchandise3.add(listOfMerchandise11);
                listOfListOfMerchandise3.add(listOfMerchandise12);
                listOfListOfMerchandise3.add(listOfMerchandise13);
                listOfListOfMerchandise3.add(listOfMerchandise14);
                listOfListOfMerchandise3.add(listOfMerchandise15);

                ListOfList listOfList1 = new ListOfList("BPBH 1000", listOfListOfMerchandise1);
                ListOfList listOfList2 = new ListOfList("BPBH 2000", listOfListOfMerchandise2);
                ListOfList listOfList3 = new ListOfList("BPBH 1234", listOfListOfMerchandise3);
                
                needToOrderList.add(listOfList1);
                needToOrderList.add(listOfList2);
                needToOrderList.add(listOfList3);
                
            	final String ORDEROPERATION_FXML_FILE_PATH = "/fxml/dhqt/OrderOperation.fxml";
        		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ORDEROPERATION_FXML_FILE_PATH));
                OrderOperationController orderOperationController = new OrderOperationController(needToOrderList);
        		fxmlLoader.setController(orderOperationController);
        		orderOperationController.setOrderOperationData(needToOrderList);
        		orderOperation = fxmlLoader.load();;
        		
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orderOperation;
    }

    public  void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        createStage(loader);
    };
    public void showBPDHQTWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dhqt/DHQT.fxml"));
        DHQTController clientController = new DHQTController();
        loader.setController(clientController);
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
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/images/rose.jpg"))));
        stage.setResizable(false);
        stage.setTitle("BPDHQT");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }
}

