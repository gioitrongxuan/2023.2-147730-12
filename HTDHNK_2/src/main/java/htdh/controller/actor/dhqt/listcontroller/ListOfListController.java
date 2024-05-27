package htdh.controller.actor.dhqt.listcontroller;

import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfList;
import htdh.controller.actor.dhqt.orderoperationcontroller.OrderOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfMerchandise;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListOfListController {
	//
	//
	//
	
	private ListOfList listOfList;
	private ArrayList<ListOfList> needToOrderList = new ArrayList<ListOfList>();
	private OrderOperationController orderOperationController;
	private ArrayList<ListOfMerchandiseController> listOfMerchandiseControllers = new ArrayList<ListOfMerchandiseController>();
	private ArrayList<Button> listOfListButtons = new ArrayList<Button>();
	private ArrayList<Button> listOfMerchandiseButtons = new  ArrayList<Button>();
	
	//
	//
	//
	
    public ListOfListController(ListOfList listOfList) {
		super();
		this.listOfList = listOfList;
	}

	public ListOfListController(ArrayList<ListOfList> needToOrderList, ListOfList listOfList,
			OrderOperationController orderOperationController, ArrayList<Button> listOfListButtons) {
		this.listOfListButtons = listOfListButtons;
		this.needToOrderList = needToOrderList;
		this.listOfList = listOfList;
		this.orderOperationController = orderOperationController;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button listDetailBtn;
    
    @FXML
    private Label listOfListLbl;

    @FXML
    void lisrOfListLblClicked(MouseEvent event) {
    	
    }
    
    @FXML
    void listDetailBtnClicked(ActionEvent event) {
    	final String LISTOFMERCHANDISE_FXML_FILE_PATH = "/fxml/dhqt/orderoperation/listview/ListOfMerchandiseView.fxml";
//    	listDetailBtn.setStyle("-fx-background-color: #132A13; -fx-border-color:  #0066FF; -fx-border-width: 2px;");
    	orderOperationController.getSiteOptGridPane().getChildren().clear();
    	orderOperationController.getListOfMerchandiseGridPane().getChildren().clear();

        int column = 0;
        int row = 0;
        listOfMerchandiseButtons.clear();
        listOfMerchandiseControllers.clear();
        for (int i = 0; i < listOfList.getListOfMerchandise().size(); i++) {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(LISTOFMERCHANDISE_FXML_FILE_PATH));
            	
                ListOfMerchandise listOfMerchandise = listOfList.getListOfMerchandise().get(i);
                ListOfMerchandiseController listOfMerchandiseController = new ListOfMerchandiseController(listOfMerchandise, orderOperationController, this, listOfMerchandiseButtons);
                fxmlLoader.setController(listOfMerchandiseController);
                
                Pane pane = fxmlLoader.load();

                listOfMerchandiseController.setListOfMerchandiseData(listOfMerchandise);
         
                listOfMerchandiseButtons.add(listOfMerchandiseController.getMerchandiseDetailBtn());
                listOfMerchandiseControllers.add(listOfMerchandiseController);
                orderOperationController.getListOfMerchandiseGridPane().add(pane, column++, row);
                if (column == 1) {
                    column = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }
        
        for( int i = 0 ; i < listOfListButtons.size(); i++ ) {
    		if(listOfListButtons.get(i) == listDetailBtn) {
    			listOfListButtons.get(i).setStyle("-fx-background-color: #132A13; -fx-border-color:  #0066FF; -fx-border-width: 1px;");
    		} else {
    			listOfListButtons.get(i).setStyle("-fx-background-color: #CCFFCC; -fx-border-color:  #0066FF; -fx-border-width: 1px;");
    		}
    	}
    }
    
    
    
    public ListOfList getListOfList() {
		return listOfList;
	}



	public void setListOfList(ListOfList listOfList) {
		this.listOfList = listOfList;
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



	public Button getListDetailBtn() {
		return listDetailBtn;
	}



	public void setListDetailBtn(Button listDetailBtn) {
		this.listDetailBtn = listDetailBtn;
	}



	public Label getListOfListLbl() {
		return listOfListLbl;
	}



	public void setListOfListLbl(Label listOfListLbl) {
		this.listOfListLbl = listOfListLbl;
	}



	@FXML
    void initialize() {
        assert listDetailBtn != null : "fx:id=\"listDetailBtn\" was not injected: check your FXML file 'ListOfListMerchandiseView.fxml'.";
    }
    
    public void setListOfListData(ListOfList listOfList) {
    	this.listOfList = listOfList;
    	listOfListLbl.setText(listOfList.getListOfListID());
    }

	public void saveSiteOptions(ListOfList listOfList) {
		this.listOfList = listOfList;
		for( int i = 0 ; i < listOfMerchandiseControllers.size() ; i++ ) {
			listOfMerchandiseControllers.get(i).saveSiteOptions(listOfList.getListOfMerchandise().get(i));
		}
	}

	public void removeSiteOptions(ListOfList listOfList) {
		this.listOfList = listOfList;
		for ( int i = 0 ; i < listOfMerchandiseControllers.size() ; i++ ) {
			if(listOfMerchandiseButtons.get(i).getStyle().contains("-fx-background-color: #132A13;")) {
				listOfMerchandiseControllers.get(i).removeSiteOptions(listOfList.getListOfMerchandise().get(i));
			} else {
				
			}
		}
	}

}
