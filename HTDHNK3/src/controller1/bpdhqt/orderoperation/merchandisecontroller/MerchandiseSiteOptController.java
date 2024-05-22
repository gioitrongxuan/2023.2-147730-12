package controller1.bpdhqt.orderoperation.merchandisecontroller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import model1.bpdhqt.orderoperation.merchandisemodel.Merchandise;
import model1.sitemodel.Site;

public class MerchandiseSiteOptController {
	private Merchandise merchandise;
	private Site site;
	private int site_x;
	
	public MerchandiseSiteOptController (Merchandise merchandise, Site site,int i) {
		this.merchandise = merchandise;
		this.site = site;
		this.site_x =i;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> meanChoiceBox;

    @FXML
    private TextField quantityTextField;

    @FXML
    private Label siteIDLbl;

    @FXML
    private ChoiceBox<String> unitChoiceBox;

    @FXML
    void initialize() {
        assert meanChoiceBox != null : "fx:id=\"meanChoiceBox\" was not injected: check your FXML file 'siteoptionview.fxml'.";
        assert quantityTextField != null : "fx:id=\"quantityTextField\" was not injected: check your FXML file 'siteoptionview.fxml'.";
        assert siteIDLbl != null : "fx:id=\"siteIDLbl\" was not injected: check your FXML file 'siteoptionview.fxml'.";
        assert unitChoiceBox != null : "fx:id=\"unitChoiceBox\" was not injected: check your FXML file 'siteoptionview.fxml'.";

    }

    public void setData(Merchandise merchandise, Site site, int site_x) {
    	this.merchandise = merchandise;
		this.site = site;
		this.site_x = site_x;
		
		siteIDLbl.setText(merchandise.getSites().get(site_x).getSiteCode());
		unitChoiceBox.getItems().add( merchandise.getUnit());
		meanChoiceBox.getItems().add( "Plane");
		meanChoiceBox.getItems().add( "Ship");
		meanChoiceBox.getItems().add( "Truck");
		meanChoiceBox.getItems().add( "Container");
		meanChoiceBox.getItems().add( "Motor");
    }
}
