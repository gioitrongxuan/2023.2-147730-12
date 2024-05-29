package htdh.controller.actor.dhqt.listcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import htdh.controller.actor.dhqt.merchandisecontroller.MerchandiseController;
import htdh.controller.actor.dhqt.merchandisecontroller.MerchandiseSiteOptController;
import htdh.controller.actor.dhqt.orderoperationcontroller.OrderOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfMerchandise;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;
import htdh.model.actor.dhqt.orderoperation.orderstosites.OrderToSite;
import htdh.subsystem.connection.dhqt.datafetch.DHQTDatabaseConfig;

public class ListOfMerchandiseController {
	
	
	//
	//
	//
	
	private ListOfMerchandise listOfMerchandise;
	private ListOfMerchandise listOfMerchandises;
	private OrderOperationController orderOperationController;
	private ArrayList<MerchandiseController> merchandiseControllers = new ArrayList<MerchandiseController>();
	private ArrayList<Button> listOfMerchandiseButtons = new  ArrayList<Button>();
	private ArrayList<OrderToSite> numberOfOrderToSite = new ArrayList<OrderToSite>();
	
	//
	//
	//

	public ListOfMerchandiseController(ListOfMerchandise listOfMerchandise, OrderOperationController orderOperationController, ArrayList<Button> listOfMerchandiseButtons) {
		this.listOfMerchandiseButtons = listOfMerchandiseButtons;
		this.listOfMerchandise = listOfMerchandise;
		this.orderOperationController = orderOperationController;
	}
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button merchandiseDetailBtn;

    @FXML
    private Label fromWhatSale;

    @FXML
    private Label orderSentDate;

    //
    //
    //
    public ListOfMerchandise getListOfMerchandise() {
		return listOfMerchandise;
	}

	public void setListOfMerchandise(ListOfMerchandise listOfMerchandise) {
		this.listOfMerchandise = listOfMerchandise;
	}

	public ListOfMerchandise getListOfMerchandises() {
		return listOfMerchandises;
	}

	public void setListOfMerchandises(ListOfMerchandise listOfMerchandises) {
		this.listOfMerchandises = listOfMerchandises;
	}

	public ResourceBundle getResources() {
		return resources;
	}

	public void setResources(ResourceBundle resources) {
		this.resources = resources;
	}

	public URL getLocation() {
		return location;
	}

	public void setLocation(URL location) {
		this.location = location;
	}

	public Button getMerchandiseDetailBtn() {
		return merchandiseDetailBtn;
	}

	public void setMerchandiseDetailBtn(Button merchandiseDetailBtn) {
		this.merchandiseDetailBtn = merchandiseDetailBtn;
	}

	public Label getMerchandiseIDLbl() {
		return fromWhatSale;
	}

	public void setMerchandiseIDLbl(Label merchandiseIDLbl) {
		this.fromWhatSale = merchandiseIDLbl;
	}

	public Label getMerchandiseLbl1() {
		return orderSentDate;
	}

	public void setMerchandiseLbl1(Label merchandiseLbl1) {
		this.orderSentDate = merchandiseLbl1;
	}
	
	//
	//
	//
	
	@FXML
    void merchandiseDetailBtnClicked(ActionEvent event) {
    	final String SITE_OPTION_FXML_FILE_PATH = "/fxml/dhqt/orderoperation/merchandiseview/merchandiseoverview.fxml";
    	
    	orderOperationController.getSiteOptGridPane().getChildren().clear();

        int column = 0;
        int row = 0;
        merchandiseControllers.clear();
        for (int i = 0; i < listOfMerchandise.getMerchandises().size(); i++) {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(SITE_OPTION_FXML_FILE_PATH));
            	
                Merchandise merchandise = listOfMerchandise.getMerchandises().get(i);
                MerchandiseController merchandiseController = new MerchandiseController(merchandise);
                fxmlLoader.setController(merchandiseController);
                
                Pane pane = fxmlLoader.load();

                merchandiseController.setMerchandiseData(listOfMerchandise);
                merchandiseControllers.add(merchandiseController);
                orderOperationController.getSiteOptGridPane().add(pane, column++, row);
                if (column == 1) {
                    column = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }
        
        for( int i = 0 ; i < listOfMerchandiseButtons.size(); i++ ) {
    		if(listOfMerchandiseButtons.get(i) == merchandiseDetailBtn) {
    			listOfMerchandiseButtons.get(i).setStyle("-fx-background-color: #132A13; -fx-border-color:  #0066FF; -fx-border-width: 1px;");
    		} else {
    			listOfMerchandiseButtons.get(i).setStyle("-fx-background-color: #CCFFCC; -fx-border-color:  #0066FF; -fx-border-width: 1px;");
    		}
    	}
    }

    @FXML
    void initialize() {
        assert merchandiseDetailBtn != null : "fx:id=\"merchandiseDetailBtn\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";
        assert fromWhatSale != null : "fx:id=\"merchandiseIDLbl\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";
        assert orderSentDate != null : "fx:id=\"merchandiseLbl1\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";

    }
    
    //
    //
    //
    
    public void setListOfMerchandiseData(ListOfMerchandise listOfMerchandise) {
    	this.listOfMerchandise = listOfMerchandise;
    	fromWhatSale.setText(listOfMerchandise.getListOfListID() + "-" + listOfMerchandise.getID() );
    	orderSentDate.setText(listOfMerchandise.getOrderSentDate());
    }

	public void saveSiteOptions(ListOfMerchandise listOfMerchandise) {
		this.listOfMerchandises = listOfMerchandise;
		for ( int i = 0 ; i < merchandiseControllers.size(); i++ ) {
			merchandiseControllers.get(i).saveSiteOptions(listOfMerchandise.getMerchandises().get(i));
		}
	}

	public void removeSiteOptions(ListOfMerchandise listOfMerchandise) {
		this.listOfMerchandises = listOfMerchandise;
		for ( int i = 0 ; i < merchandiseControllers.size(); i++ ) {
			merchandiseControllers.get(i).removeSiteOptions(listOfMerchandise.getMerchandises().get(i));
		}
	}

	public void sendOrderToSite(ListOfMerchandise listOfMerchandise) {
		// TODO Auto-generated method stub
		this.listOfMerchandises = listOfMerchandise;

		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Xác nhận");
        alert.setHeaderText("Xác nhận gửi đơn");
        alert.setContentText("Bạn có muốn gửi đơn " + listOfMerchandise.getListOfListID() + "-" + listOfMerchandise.getID() + " không?");
        DialogPane dialogPane = alert.getDialogPane();

        dialogPane.setPrefWidth(500); // Đặt kích thước chiều rộng
        dialogPane.setPrefHeight(100); // Đặt kích thước chiều cao

        dialogPane.setStyle("-fx-font-size: 14px;"); // Đặt kích thước chữ
     
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        	allocationOrdersToSites();
        	orderOperationController.getSiteOptGridPane().getChildren().clear();
        } else {
        	
        }
	    ordersToSitesInformation();
	}

	private void ordersToSitesInformation() {
		System.out.println("Thông tin các Order đã được tạo:");
	    for (OrderToSite order : numberOfOrderToSite) {
	    	System.out.println("ID of the Order to Site: " + order.getOrderToSiteID());
	        System.out.println("SiteID: " + order.getSiteID());
	        System.out.println("SiteName: " + order.getSiteName());
	        System.out.println("DeliveryMean: " + order.getDeliveryMean());
	        System.out.println("OrderSentDate: " + order.getOrderSentDate());
	        System.out.println("DesiredDeliveryDate: " + order.getDesiredDeliveryDate());
	        System.out.println("Status: " + order.getStatus());
	        System.out.println("Merchandises:");
	        ArrayList<Merchandise> merchandises = order.getMerchandisesNeedToOrder();
	        ArrayList<Integer> quantities = order.getAmountOfMerchandisesNeedToOrder();
	        for (int i = 0; i < merchandises.size(); i++) {
	            Merchandise merchandise = merchandises.get(i);
	            int quantity = quantities.get(i);
	            System.out.println("  Merchandise Name: " + merchandise.getName());
	            System.out.println("  Quantity: " + quantity);
	            // In thêm các thuộc tính khác của merchandise nếu cần
	        }
	        System.out.println("\n");
	    }
	}

	private void allocationOrdersToSites() {
		
		DHQTDatabaseConfig dbConfig = new DHQTDatabaseConfig();
	    
	    // Kết nối tới cơ sở dữ liệu
	    dbConfig.connect();
	    
	    // Tạo bảng nếu chưa tồn tại
	    dbConfig.createTable();
		
		List<String> orderToSiteKey = new ArrayList<String>();
		for ( MerchandiseController merchandiseController : merchandiseControllers ) {
			for( MerchandiseSiteOptController merchandiseSiteOptController : merchandiseController.getMerchandiseSiteOptControllers()) {
				String siteID = merchandiseSiteOptController.getSiteIDLbl().getText();
		    	String siteName = merchandiseSiteOptController.getSiteNameLbl().getText();
		    	String deliveryMean = merchandiseSiteOptController.getMeanChoiceBox().getValue();
		    	String orderSentDate = merchandiseController.getExpectedReceiveDate().getText();
		    	String desiredDeliveryDate;
		    	
		    	ArrayList<Merchandise> merchandisesNeedToOrder = new ArrayList<Merchandise>();
		    	ArrayList<Integer> amountOfMerchandisesNeedToOrder = new ArrayList<Integer>();
		    	String status = "Chờ xác nhận";
		    	String key = siteID + "-" + deliveryMean + "-" + orderSentDate;
		    	if(!(merchandiseSiteOptController.getQuantityTextField().getText().equals("0"))) {
		    		if (orderToSiteKey.contains(key) == false) {
			    		orderToSiteKey.add(key);
			    		desiredDeliveryDate = (merchandiseSiteOptController.getDesiredDeliveryDateLbl().getText());
			    		merchandisesNeedToOrder.add(merchandiseController.getMerchandise());
			    		amountOfMerchandisesNeedToOrder.add(Integer.parseInt(merchandiseSiteOptController.getQuantityTextField().getText()));
			    		OrderToSite orderToSite = new OrderToSite(key, siteID, siteName, deliveryMean, orderSentDate, desiredDeliveryDate, merchandisesNeedToOrder, amountOfMerchandisesNeedToOrder, status);
			    		numberOfOrderToSite.add(orderToSite);
			        } else {
			        	for ( int i = 0 ; i < numberOfOrderToSite.size() ; i++ ) {
			        		if(numberOfOrderToSite.get(i).getSiteID().equals(siteID)) {
			        			numberOfOrderToSite.get(i).setDesiredDeliveryDate(merchandiseSiteOptController.getDesiredDeliveryDateLbl().getText());;
			        			numberOfOrderToSite.get(i).getMerchandisesNeedToOrder().add(merchandiseController.getMerchandise());
					    		numberOfOrderToSite.get(i).getAmountOfMerchandisesNeedToOrder().add(Integer.parseInt(merchandiseSiteOptController.getQuantityTextField().getText()));
			        		}
			        	}
			        }
		    	}
			}
		}
		for (OrderToSite order : numberOfOrderToSite) {
	        dbConfig.insertDataIntoOrderToSiteTable(order);
	    }
	}
}
