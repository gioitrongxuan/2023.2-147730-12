package controller1.bpdhqt.orderoperation.orderscreencontroller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class OrderScreenController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label AIMS;

    @FXML
    private Button ViewCart;

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
    private Pane windowOptionPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AIMS != null : "fx:id=\"AIMS\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert ViewCart != null : "fx:id=\"ViewCart\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert listOfListGridPane != null : "fx:id=\"listOfListGridPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert listOfListScrollPane != null : "fx:id=\"listOfListScrollPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert listOfMerchandiseGridPane != null : "fx:id=\"listOfMerchandiseGridPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert listOfMerchandiseScrollPane != null : "fx:id=\"listOfMerchandiseScrollPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert orderOperationBtn != null : "fx:id=\"orderOperationBtn\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert siteOptGridPane != null : "fx:id=\"siteOptGridPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert siteOptionScrollPane != null : "fx:id=\"siteOptionScrollPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";
        assert windowOptionPane != null : "fx:id=\"windowOptionPane\" was not injected: check your FXML file 'OrderOperation.fxml'.";

    }

}
