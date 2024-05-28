package htdh.controller.actor.dhqt.orderoperationcontroller;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import htdh.controller.actor.dhqt.listcontroller.ListOfListController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfList;

public class OrderOperationController {
	
	//
	//
	//
	
	private ArrayList<ListOfList> needToOrderList;
	private ArrayList<ListOfListController> listOfListControllers = new ArrayList<ListOfListController>();
	private ArrayList<Button> listOfListButtons = new ArrayList<Button>();
	
	//
	//
	//
	
	public OrderOperationController(ArrayList<ListOfList> needToOrderList) {
		this.needToOrderList = needToOrderList;
	}
	
	//
	//
	//
	
    @FXML
    private ChoiceBox<String> comparisonStandardsChoiceBox;
    
    @FXML
    private TextField searchBox;
    
    @FXML
    private Button removeSiteOptionsBtn;
    
    @FXML
    private Button sendOrderBtn;
    
	@FXML
    private Button needOrderedMerchandisesBtn;

	@FXML
    private Button OrderStatusDetailBtn;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AIMS;

    @FXML
    private GridPane listOfListGridPane;

    @FXML
    private ScrollPane listOfListScrollPane;

    @FXML
    private GridPane listOfMerchandiseGridPane;

    @FXML
    private ScrollPane listOfMerchandiseScrollPane;

    @FXML
    private Button orderOperationBtn;

    @FXML
    private GridPane siteOptGridPane;

    @FXML
    private ScrollPane siteOptionScrollPane;

    @FXML
    private VBox windowOptVBox;
    
    @FXML
    private Button siteOptSaveBtn;
    //
    //
    //
	public ResourceBundle getResources() {
		return resources;
	}

	public ArrayList<ListOfList> getNeedToOrderList() {
		return needToOrderList;
	}

	public void setNeedToOrderList(ArrayList<ListOfList> needToOrderList) {
		this.needToOrderList = needToOrderList;
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

	public GridPane getListOfListGridPane() {
		return listOfListGridPane;
	}

	public void setListOfListGridPane(GridPane listOfListGridPane) {
		this.listOfListGridPane = listOfListGridPane;
	}

	public ScrollPane getListOfListScrollPane() {
		return listOfListScrollPane;
	}

	public void setListOfListScrollPane(ScrollPane listOfListScrollPane) {
		this.listOfListScrollPane = listOfListScrollPane;
	}

	public GridPane getListOfMerchandiseGridPane() {
		return listOfMerchandiseGridPane;
	}

	public void setListOfMerchandiseGridPane(GridPane listOfMerchandiseGridPane) {
		this.listOfMerchandiseGridPane = listOfMerchandiseGridPane;
	}

	public ScrollPane getListOfMerchandiseScrollPane() {
		return listOfMerchandiseScrollPane;
	}

	public void setListOfMerchandiseScrollPane(ScrollPane listOfMerchandiseScrollPane) {
		this.listOfMerchandiseScrollPane = listOfMerchandiseScrollPane;
	}

	public Button getOrderOperationBtn() {
		return orderOperationBtn;
	}

	public void setOrderOperationBtn(Button orderOperationBtn) {
		this.orderOperationBtn = orderOperationBtn;
	}

	public GridPane getSiteOptGridPane() {
		return siteOptGridPane;
	}

	public void setSiteOptGridPane(GridPane siteOptGridPane) {
		this.siteOptGridPane = siteOptGridPane;
	}

	public ScrollPane getSiteOptionScrollPane() {
		return siteOptionScrollPane;
	}

	public void setSiteOptionScrollPane(ScrollPane siteOptionScrollPane) {
		this.siteOptionScrollPane = siteOptionScrollPane;
	}

	public VBox getWindowOptVBox() {
		return windowOptVBox;
	}

	public void setWindowOptVBox(VBox windowOptVBox) {
		this.windowOptVBox = windowOptVBox;
	}
    //
    //
    //
    @FXML
    void initialize() {
        assert AIMS != null : "fx:id=\"AIMS\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert listOfListGridPane != null : "fx:id=\"listOfListGridPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert listOfListScrollPane != null : "fx:id=\"listOfListScrollPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert listOfMerchandiseGridPane != null : "fx:id=\"listOfMerchandiseGridPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert listOfMerchandiseScrollPane != null : "fx:id=\"listOfMerchandiseScrollPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert orderOperationBtn != null : "fx:id=\"orderOperationBtn\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert siteOptGridPane != null : "fx:id=\"siteOptGridPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert siteOptionScrollPane != null : "fx:id=\"siteOptionScrollPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert windowOptVBox != null : "fx:id=\"windowOptVBox\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        
        
    }
    //
	//
    //
    
	public void setOrderOperationData(ArrayList<ListOfList> needToOrderList) {
		this.needToOrderList = needToOrderList;
		showListOfListMerchandise(needToOrderList);
	}

	private void showListOfListMerchandise(ArrayList<ListOfList> needToOrderList) {
	    this.needToOrderList = needToOrderList;
	    final String NEEDTOORDERLIST_OPTION_FXML_FILE_PATH = "/fxml/dhqt/orderoperation/listview/ListOfListMerchandiseView.fxml";

	    listOfListGridPane.getChildren().clear();

	    int column = 0;
	    int row = 0;
        listOfListControllers.clear();
        listOfListButtons.clear();
	    for (int i = 0; i < needToOrderList.size(); i++) {
	        try {
	            FXMLLoader fxmlLoader = new FXMLLoader();
	            fxmlLoader.setLocation(getClass().getResource(NEEDTOORDERLIST_OPTION_FXML_FILE_PATH));

	            ListOfList listOfList = needToOrderList.get(i);
	            ListOfListController listOfListController = new ListOfListController(needToOrderList, listOfList, this, listOfListButtons);
	            fxmlLoader.setController(listOfListController);
	            Pane pane = fxmlLoader.load();
	            
	            listOfListController.setListOfListData(listOfList);
	            listOfListButtons.add(listOfListController.getListDetailBtn());
	            listOfListControllers.add(listOfListController);
	            
	            listOfListGridPane.add(pane, column++, row);
	            if (column == 1) {
	                column = 0;
	                row++;
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	
	
	//
	//
	//
	@FXML
    void OrderStatusDetailBtnClicked(ActionEvent event) {

    }

    @FXML
    void needOrderedMerchandisesBtnClicked(ActionEvent event) {

    }

    @FXML
    void orderOperationBtnClicked(ActionEvent event) {

    }
	@FXML
    void siteOptSaveBtnClicked(ActionEvent event) {
		for (int i = 0 ; i < listOfListControllers.size() ; i++) {
			saveSiteOptions(i, needToOrderList.get(i));
		}
    }
	@FXML
	void sendOrderBtnClicked(ActionEvent event) {
		for (int i = 0 ; i < listOfListControllers.size() ; i++) {
    		if(listOfListButtons.get(i).getStyle().contains("-fx-background-color: #132A13;")) {
    			sendOrderToSite(i, needToOrderList.get(i));
    		} else {

    		}
		}
	}
    @FXML
    void removeSiteOptionsBtnClicked(ActionEvent event) {
    	for (int i = 0 ; i < listOfListControllers.size() ; i++) {
    		if(listOfListButtons.get(i).getStyle().contains("-fx-background-color: #132A13;")) {
    			removeSiteOptions(i, needToOrderList.get(i));
    		} else {

    		}
		}
    }
    
	@FXML
    void seachBoxFilled(ActionEvent event) {
    	
    }
    
    @FXML
    void comparisonStandardsChoiceBoxClicked(MouseEvent event) {

    }

	//
	//
	//
    
	private void saveSiteOptions(int i, ListOfList listOfList) {
		listOfListControllers.get(i).saveSiteOptions(listOfList);
	}
	
	private void removeSiteOptions(int i, ListOfList listOfList) {
		listOfListControllers.get(i).removeSiteOptions(listOfList);
	}
	
	private void sendOrderToSite(int i, ListOfList listOfList) {
		listOfListControllers.get(i).sendOrderToSite(listOfList);
	}
}
