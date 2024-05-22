package com.jmc.htdh.controller.actor.dhqt.listcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jmc.htdh.controller.actor.dhqt.merchandisecontroller.MerchandiseController;
import com.jmc.htdh.controller.actor.dhqt.merchandisecontroller.MerchandiseSiteOptController;
import com.jmc.htdh.controller.actor.dhqt.orderoperationcontroller.OrderOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import com.jmc.htdh.model.actor.dhqt.orderoperation.listmodel.ListOfMerchandise;
import com.jmc.htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;

public class ListOfMerchandiseController {
	
	private ListOfMerchandise listOfMerchandise;
	private ArrayList<ListOfMerchandise> listOfMerchandises = new ArrayList<ListOfMerchandise>();
	private OrderOperationController orderOperationController;
	private MerchandiseController merchandiseController;
	private ArrayList<MerchandiseSiteOptController> merchandiseSiteOptControllers = new ArrayList<>();
	
	public ListOfMerchandiseController(ListOfMerchandise listOfMerchandise, OrderOperationController orderOperationController, ListOfListController listOfListController) {
		
//		this.listOfMerchandises = listOfMerchandises;
		this.listOfMerchandise = listOfMerchandise;
		this.orderOperationController = orderOperationController;
	}
	
	public ListOfMerchandiseController(ListOfMerchandise listOfMerchandise, OrderOperationController orderOperationController, ListOfListController listOfListController, ArrayList<MerchandiseSiteOptController> merchandiseSiteOptControllers ) {
		 this.merchandiseSiteOptControllers = merchandiseSiteOptControllers;
//		this.listOfMerchandises = listOfMerchandises;
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
    private Label merchandiseIDLbl;

    @FXML
    private Label merchandiseLbl1;
    //
    //
    //
    public ListOfMerchandise getListOfMerchandise() {
		return listOfMerchandise;
	}

	public void setListOfMerchandise(ListOfMerchandise listOfMerchandise) {
		this.listOfMerchandise = listOfMerchandise;
	}

	public ArrayList<ListOfMerchandise> getListOfMerchandises() {
		return listOfMerchandises;
	}

	public void setListOfMerchandises(ArrayList<ListOfMerchandise> listOfMerchandises) {
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
		return merchandiseIDLbl;
	}

	public void setMerchandiseIDLbl(Label merchandiseIDLbl) {
		this.merchandiseIDLbl = merchandiseIDLbl;
	}

	public Label getMerchandiseLbl1() {
		return merchandiseLbl1;
	}

	public void setMerchandiseLbl1(Label merchandiseLbl1) {
		this.merchandiseLbl1 = merchandiseLbl1;
	}
	//
	//
	//
	@FXML
    void merchandiseDetailBtnClicked(ActionEvent event) {
    	final String SITE_OPTION_FXML_FILE_PATH = "/view/bpdhqt/orderoperation/merchandiseview/MerchandiseOverview.fxml";
    	
    	orderOperationController.getSiteOptGridPane().getChildren().clear();

        int column = 0;
        int row = 0;
        for (int i = 0; i < listOfMerchandise.getMerchandises().size(); i++) {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(SITE_OPTION_FXML_FILE_PATH));
            	
                Merchandise merchandise = listOfMerchandise.getMerchandises().get(i);
                MerchandiseController merchandiseController = new MerchandiseController(merchandise);
                fxmlLoader.setController(merchandiseController);
                
                Pane pane = fxmlLoader.load();

                merchandiseController.setMerchandiseData(listOfMerchandise);
                orderOperationController.getSiteOptGridPane().add(pane, column++, row);
                if (column == 1) {
                    column = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }   
        }
    }

    @FXML
    void initialize() {
        assert merchandiseDetailBtn != null : "fx:id=\"merchandiseDetailBtn\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";
        assert merchandiseIDLbl != null : "fx:id=\"merchandiseIDLbl\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";
        assert merchandiseLbl1 != null : "fx:id=\"merchandiseLbl1\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";

    }

    public void setListOfMerchandiseData(ListOfMerchandise listOfMerchandise) {
    	this.listOfMerchandise = listOfMerchandise;
    	merchandiseIDLbl.setText(listOfMerchandise.getListOfListID());
    	merchandiseLbl1.setText(listOfMerchandise.getID());
    }
}
