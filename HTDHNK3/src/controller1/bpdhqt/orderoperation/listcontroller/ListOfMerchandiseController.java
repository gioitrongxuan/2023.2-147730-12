package controller1.bpdhqt.orderoperation.listcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model1.bpdhqt.orderoperation.listofmerchandisemodel.ListOfMerchandise;

public class ListOfMerchandiseController {
	private ListOfMerchandise listOfMerchandise;

	public ListOfMerchandiseController(ListOfMerchandise listOfMerchandise) {
		this.listOfMerchandise = listOfMerchandise;
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

    @FXML
    void merchandiseDetailBtnClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert merchandiseDetailBtn != null : "fx:id=\"merchandiseDetailBtn\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";
        assert merchandiseIDLbl != null : "fx:id=\"merchandiseIDLbl\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";
        assert merchandiseLbl1 != null : "fx:id=\"merchandiseLbl1\" was not injected: check your FXML file 'ListOfMerchandiseView.fxml'.";

    }

    public void setListOfMerchandiseData(ListOfMerchandise listOfMerchandise) {
    	this.listOfMerchandise = listOfMerchandise;
    	merchandiseIDLbl.setText(listOfMerchandise.getID());
    	merchandiseLbl1.setText(listOfMerchandise.getName());
    }
}
