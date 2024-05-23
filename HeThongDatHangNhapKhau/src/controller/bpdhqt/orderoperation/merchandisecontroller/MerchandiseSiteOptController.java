package controller.bpdhqt.orderoperation.merchandisecontroller;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;
import model.sitemodel.Site;

public class MerchandiseSiteOptController {
	private Merchandise merchandise;
	private MerchandiseController merchandiseController;

	public MerchandiseSiteOptController (Merchandise merchandise) {
		this.merchandise = merchandise;

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
    private Label unitLbl;

    @FXML
    void initialize() {
        assert meanChoiceBox != null : "fx:id=\"meanChoiceBox\" was not injected: check your FXML file 'siteoptionview.fxml'.";
        assert quantityTextField != null : "fx:id=\"quantityTextField\" was not injected: check your FXML file 'siteoptionview.fxml'.";
        assert siteIDLbl != null : "fx:id=\"siteIDLbl\" was not injected: check your FXML file 'siteoptionview.fxml'.";
        assert unitChoiceBox != null : "fx:id=\"unitChoiceBox\" was not injected: check your FXML file 'siteoptionview.fxml'.";
    }

    
    
    public Merchandise getMerchandise() {
		return merchandise;
	}



	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}



	public MerchandiseController getMerchandiseController() {
		return merchandiseController;
	}



	public void setMerchandiseController(MerchandiseController merchandiseController) {
		this.merchandiseController = merchandiseController;
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



	public ChoiceBox<String> getMeanChoiceBox() {
		return meanChoiceBox;
	}



	public void setMeanChoiceBox(ChoiceBox<String> meanChoiceBox) {
		this.meanChoiceBox = meanChoiceBox;
	}



	public TextField getQuantityTextField() {
		return quantityTextField;
	}



	public void setQuantityTextField(TextField quantityTextField) {
		this.quantityTextField = quantityTextField;
	}



	public Label getSiteIDLbl() {
		return siteIDLbl;
	}



	public void setSiteIDLbl(Label siteIDLbl) {
		this.siteIDLbl = siteIDLbl;
	}



	public ChoiceBox<String> getUnitChoiceBox() {
		return unitChoiceBox;
	}



	public void setUnitChoiceBox(ChoiceBox<String> unitChoiceBox) {
		this.unitChoiceBox = unitChoiceBox;
	}



	public Label getUnitLbl() {
		return unitLbl;
	}



	public void setUnitLbl(Label unitLbl) {
		this.unitLbl = unitLbl;
	}



	public void setData(Merchandise merchandise, Site site, int site_x) {
    	this.merchandise = merchandise;
    	
    	siteIDLbl.setText(merchandise.getSites().get(site_x).getSiteCode());
		unitLbl.setText(merchandise.getUnit());
		
		if(merchandise.getQuantityOrdered().isEmpty()) {
			quantityTextField.setText("0");
		} else {
				quantityTextField.setText(merchandise.getQuantityOrdered().get(site_x)+"");
		}
		
		meanChoiceBox.getItems().add( "Air");
		meanChoiceBox.getItems().add( "Ship");
	    // Xóa các mục cũ trong ChoiceBox và thêm các mục mới
		
		if(!(merchandise.getDeliveryMean().isEmpty())) {
				meanChoiceBox.setValue(merchandise.getDeliveryMean().get(site_x));
		}
    }
}
