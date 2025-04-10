package controller.bpdhqt.orderoperation.listcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.bpdhqt.orderoperation.merchandisecontroller.MerchandiseController;
import controller.bpdhqt.orderoperation.orderoperationcontroller.OrderOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.bpdhqt.orderoperation.listmodel.ListOfList;
import model.bpdhqt.orderoperation.listmodel.ListOfMerchandise;
import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;

public class ListOfListController {
	
	private ListOfList listOfList;
	private ArrayList<ListOfList> needToOrderList = new ArrayList<ListOfList>();
	private OrderOperationController orderOperationController;
	private ArrayList<ListOfMerchandiseController> ListOfMerchandiseControllers = new ArrayList<ListOfMerchandiseController>();
    public ListOfListController(ListOfList listOfList) {
		super();
		this.listOfList = listOfList;
	}

	public ListOfListController(ArrayList<ListOfList> needToOrderList, ListOfList listOfList,
			OrderOperationController orderOperationController) {
		// TODO Auto-generated constructor stub
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
    	final String LISTOFMERCHANDISE_FXML_FILE_PATH = "/view/bpdhqt/orderoperation/listview/ListOfMerchandiseView.fxml";
    	
    	orderOperationController.getSiteOptGridPane().getChildren().clear();
    	orderOperationController.getListOfMerchandiseGridPane().getChildren().clear();

        int column = 0;
        int row = 0;
        
        ListOfMerchandiseControllers.clear();
        for (int i = 0; i < listOfList.getListOfMerchandise().size(); i++) {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(LISTOFMERCHANDISE_FXML_FILE_PATH));
            	
                ListOfMerchandise listOfMerchandise = listOfList.getListOfMerchandise().get(i);
                ListOfMerchandiseController listOfMerchandiseController = new ListOfMerchandiseController(listOfMerchandise, orderOperationController, this);
                fxmlLoader.setController(listOfMerchandiseController);
                
                Pane pane = fxmlLoader.load();

                listOfMerchandiseController.setListOfMerchandiseData(listOfMerchandise);
         
                ListOfMerchandiseControllers.add(listOfMerchandiseController);
                orderOperationController.getListOfMerchandiseGridPane().add(pane, column++, row);
                if (column == 1) {
                    column = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
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
//		ArrayList<ListOfMerchandise> listOfMerchandise = new ArrayList<ListOfMerchandise>();
//		listOfMerchandise = listOfList.getListOfMerchandise();		
		System.out.println("Hello");
		for( int i = 0 ; i < ListOfMerchandiseControllers.size() ; i++ ) {
			ListOfMerchandiseControllers.get(i).saveSiteOptions(listOfList.getListOfMerchandise());
		}
	}

}
