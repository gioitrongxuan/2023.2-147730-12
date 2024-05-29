package htdh.controller.actor.dhqt.merchandisecontroller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;
import htdh.model.actor.sitemodel.Site;

public class MerchandiseSiteOptController {
	//
	//
	//
	
    private Merchandise merchandise;
    private MerchandiseController merchandiseController;
    
    //
    //
    //
    
    public MerchandiseSiteOptController(Merchandise merchandise, MerchandiseController merchandiseController) {
        this.merchandise = merchandise;
        this.merchandiseController = merchandiseController;
    }
    //
    //
    //
    @FXML
    private Label siteNameLbl;

    @FXML
    private Label desiredDeliveryDateLbl;

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
        
        chosenQuantityCalculate();
        chosenQuantitySufficiencyCheck();
        
        
        
        
    }

    //
    //
    //

    public Label getSiteNameLbl() {
        return siteNameLbl;
    }

    public void setSiteNameLbl(Label siteNameLbl) {
        this.siteNameLbl = siteNameLbl;
    }

    public Label getDesiredDeliveryDateLbl() {
        return desiredDeliveryDateLbl;
    }

    public void setDesiredDeliveryDateLbl(Label desiredDeliveryDateLbl) {
        this.desiredDeliveryDateLbl = desiredDeliveryDateLbl;
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
    
    //
    //
    //
    
    private void updateDesiredDeliveryDate(String mean, int site_x) {
        if (mean == null || merchandiseController.getExpectedReceiveDate().getText() == null || merchandiseController.getExpectedReceiveDate().getText().isEmpty()) {
            desiredDeliveryDateLbl.setText("");
            return;
        }
        int byAirTime = merchandise.getSites().get(site_x).getByAirTime();
        int byShipTime = merchandise.getSites().get(site_x).getByShipTime();
        int daysToAdd = mean.equals("Air") ? byAirTime : byShipTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate orderSentDate = LocalDate.parse(merchandiseController.getExpectedReceiveDate().getText(), formatter);
        LocalDate desiredDeliveryDate = orderSentDate.plusDays(daysToAdd);

        desiredDeliveryDateLbl.setText(desiredDeliveryDate.format(formatter));
    }

    private void updateChosenQuantity() {
        int totalQuantity = merchandiseController.calculateTotalQuantity();
        merchandiseController.getChosenQuantityLbl().setText(String.valueOf(totalQuantity));
        int chosenQuantity = Integer.parseInt(merchandiseController.getChosenQuantityLbl().getText());
        int needOrderedQuantity = Integer.parseInt(merchandiseController.getNeedOrderedQuantityLbl().getText());
        
        if(chosenQuantity < needOrderedQuantity) {
        	merchandiseController.getNeedOrderedQuantityLbl().setStyle("-fx-text-fill: black;");
	    	merchandiseController.getChosenQuantityLbl().setStyle("-fx-text-fill: red;");
	    }
	    else if (chosenQuantity == needOrderedQuantity) {
	    	merchandiseController.getNeedOrderedQuantityLbl().setStyle("-fx-text-fill: black;");
	    	merchandiseController.getChosenQuantityLbl().setStyle("-fx-text-fill: green;");
	    }
	    else if (chosenQuantity > needOrderedQuantity) {
	    	merchandiseController.getNeedOrderedQuantityLbl().setStyle("-fx-text-fill: red;");
	    	merchandiseController.getChosenQuantityLbl().setStyle("-fx-text-fill: red;");
	    }
    }

    @FXML
    void quantityTextFieldClicked(ActionEvent event) {
        // Existing method content
    }

    public void setData(Merchandise merchandise, Site site, int site_x) {
        this.merchandise = merchandise;
        if(!(merchandise.getDesiredDeliveryDate().isEmpty())) {
        	desiredDeliveryDateLbl.setText(merchandise.getDesiredDeliveryDate().get(site_x));
        }
        siteIDLbl.setText(merchandise.getSites().get(site_x).getSiteCode());
        unitLbl.setText(merchandise.getUnit());
        siteNameLbl.setText(merchandise.getSites().get(site_x).getSiteName());
        if (merchandise.getQuantityOrdered().isEmpty()) {
            quantityTextField.setText("0");
        } else {
            quantityTextField.setText(merchandise.getQuantityOrdered().get(site_x) + "");
        }

        meanChoiceBox.getItems().add("Air");
        meanChoiceBox.getItems().add("Ship");

        if (!(merchandise.getDeliveryMean().isEmpty())) {
            meanChoiceBox.setValue(merchandise.getDeliveryMean().get(site_x));
        }
        
        meanChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateDesiredDeliveryDate(newValue, site_x);
        });
        
        if ( merchandiseController.getChosenQuantityLbl().getStyle().equals("-fx-text-fill: green;") && merchandiseController.getNeedOrderedQuantityLbl().getStyle().contains("-fx-text-fill: black;")) {
            if (quantityTextField.getText().equals("0")) {
                meanChoiceBox.setDisable(true);
                quantityTextField.setDisable(true);
            }
        } else {
            meanChoiceBox.setDisable(false);
            quantityTextField.setDisable(false);
        }
    }
    
    private void chosenQuantityCalculate() {
		quantityTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                if (quantityTextField.getText().equals("0")) {
                    quantityTextField.setText("");
                }
            } else {
                if (quantityTextField.getText().isEmpty()) {
                    quantityTextField.setText("0");
                }
            }
        });
        PauseTransition pause = new PauseTransition(Duration.millis(1000));
        pause.setOnFinished(event -> {
            
        });
        quantityTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                updateChosenQuantity();
                pause.playFromStart();
            }
        });
	}
    
    private void chosenQuantitySufficiencyCheck() {
		merchandiseController.getChosenQuantityLbl().styleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.contains("-fx-text-fill: green;") && merchandiseController.getNeedOrderedQuantityLbl().getStyle().contains("-fx-text-fill: black;")) {
                // Nếu điều kiện được đáp ứng, vô hiệu hóa các ô tùy chọn khác
                if (quantityTextField.getText().equals("0")) {
                    meanChoiceBox.setDisable(true);
                    quantityTextField.setDisable(true);
                }
            } else {
                // Nếu không, bật lại các ô tùy chọn khác
                meanChoiceBox.setDisable(false);
                quantityTextField.setDisable(false);
            }
        });
	}
}
