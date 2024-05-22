package com.jmc.htdh.model.actor.internationalOrder.orderoperation.merchandisecontroller;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import com.jmc.htdh.model.actor.internationalOrder.orderoperation.merchandisemodel.Merchandise;
import com.jmc.htdh.model.actor.site.Site;

public class MerchandiseSiteOptController {
	private Merchandise merchandise;
	private Site site;
	private int site_x;
	
	public MerchandiseSiteOptController (Merchandise merchandise, Site site) {
		this.merchandise = merchandise;
		this.site = site;
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
