package controller.bpdhqt.orderoperation.listcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ListOfListController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button listDetailBtn;
    
    @FXML
    private Label listOfListLbl;

    @FXML
    void listDetailBtnClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert listDetailBtn != null : "fx:id=\"listDetailBtn\" was not injected: check your FXML file 'ListOfListMerchandiseView.fxml'.";

    }

}
