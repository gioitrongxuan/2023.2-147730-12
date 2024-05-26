package htdh.controller.actor.dhqt.merchandisecontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfMerchandise;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;
import htdh.model.actor.sitemodel.Site;

public class MerchandiseController {
    private Merchandise merchandise;
    private ArrayList<Merchandise> merchandises;
    private ListOfMerchandise listOfMerchandise;
    private Site site;
    private MerchandiseSiteOptController merchandiseSiteOptController;
    private ArrayList<MerchandiseSiteOptController> merchandiseSiteOptControllers = new ArrayList<MerchandiseSiteOptController>();

    public MerchandiseController(Merchandise merchandise) {
        this.merchandise = merchandise;
    }
    @FXML
    private Label chosenQuantityLbl;
    @FXML
    private Label expectedReceiveDate;

    @FXML
    private Label needOrderedQuantityLbl;
	@FXML
    private GridPane gridPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane merchandiseDetailPane;

    @FXML
    private Label merchandiseLbl;

    @FXML
    private Label merchandiseNameLbl;

    @FXML
    private Button saveOneMerchandiseSiteOpt;
    
    @FXML
    void infoVBoxClicked(MouseEvent event) {

    }

    
    public MerchandiseSiteOptController getMerchandiseSiteOptController() {
		return merchandiseSiteOptController;
	}


	public void setMerchandiseSiteOptController(MerchandiseSiteOptController merchandiseSiteOptController) {
		this.merchandiseSiteOptController = merchandiseSiteOptController;
	}


	public ArrayList<MerchandiseSiteOptController> getMerchandiseSiteOptControllers() {
		return merchandiseSiteOptControllers;
	}


	public void setMerchandiseSiteOptControllers(ArrayList<MerchandiseSiteOptController> merchandiseSiteOptControllers) {
		this.merchandiseSiteOptControllers = merchandiseSiteOptControllers;
	}


	public Label getChosenQuantityLbl() {
		return chosenQuantityLbl;
	}


	public void setChosenQuantityLbl(Label chosenQuantityLbl) {
		this.chosenQuantityLbl = chosenQuantityLbl;
	}


	public Label getExpectedReceiveDate() {
		return expectedReceiveDate;
	}


	public void setExpectedReceiveDate(Label expectedReceiveDate) {
		this.expectedReceiveDate = expectedReceiveDate;
	}


	public Label getNeedOrderedQuantityLbl() {
		return needOrderedQuantityLbl;
	}


	public void setNeedOrderedQuantityLbl(Label needOrderedQuantityLbl) {
		this.needOrderedQuantityLbl = needOrderedQuantityLbl;
	}


	public Button getSaveOneMerchandiseSiteOpt() {
		return saveOneMerchandiseSiteOpt;
	}


	public void setSaveOneMerchandiseSiteOpt(Button saveOneMerchandiseSiteOpt) {
		this.saveOneMerchandiseSiteOpt = saveOneMerchandiseSiteOpt;
	}


	public Merchandise getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	public ListOfMerchandise getListOfMerchandise() {
		return listOfMerchandise;
	}

	public void setListOfMerchandise(ListOfMerchandise listOfMerchandise) {
		this.listOfMerchandise = listOfMerchandise;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
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

	public Pane getMerchandiseDetailPane() {
		return merchandiseDetailPane;
	}

	public void setMerchandiseDetailPane(Pane merchandiseDetailPane) {
		this.merchandiseDetailPane = merchandiseDetailPane;
	}

	public Label getMerchandiseLbl() {
		return merchandiseLbl;
	}

	public void setMerchandiseLbl(Label merchandiseLbl) {
		this.merchandiseLbl = merchandiseLbl;
	}

	public Label getMerchandiseNameLbl() {
		return merchandiseNameLbl;
	}

	public void setMerchandiseNameLbl(Label merchandiseNameLbl) {
		this.merchandiseNameLbl = merchandiseNameLbl;
	}

	@FXML
    void initialize() {
        assert merchandiseDetailPane != null : "fx:id=\"merchandiseDetailPane\" was not injected: check your FXML file 'merchandiseoverview.fxml'.";
        assert merchandiseLbl != null : "fx:id=\"merchandiseLbl\" was not injected: check your FXML file 'merchandiseoverview.fxml'.";
        assert merchandiseNameLbl != null : "fx:id=\"merchandiseNameLbl\" was not injected: check your FXML file 'merchandiseoverview.fxml'.";
    }

	@FXML
	void saveOneMerchandiseSiteOptClicked(ActionEvent event) throws IOException {
	
		System.out.println("Thông tin Merchandise TRƯỚC khi lưu:");
	    System.out.println("Số lượng đặt hàng: " + merchandise.getQuantityOrdered());
		System.out.println("Phương thức giao hàng: " + merchandise.getDeliveryMean());
	    System.out.println("Tgian hen: " + merchandise.getDesiredDeliveryDate());

	    ArrayList<String> means = new ArrayList<String>();
	    ArrayList<Integer> orderedMerchandiseQuantity = new ArrayList<Integer>();
	    ArrayList<String> desiredDeliveryDate = new ArrayList<String>();
	    for(int i = 0; i < merchandiseSiteOptControllers.size(); i++) {
	    	if ( merchandiseSiteOptControllers.get(i).getQuantityTextField().getText() == null ) {
	    		orderedMerchandiseQuantity.add(0);
	    		merchandiseSiteOptControllers.get(i).getQuantityTextField().setText("0");;
	    	} else {
	    		orderedMerchandiseQuantity.add(Integer.parseInt(merchandiseSiteOptControllers.get(i).getQuantityTextField().getText()));

	    	}
	    	
	    	means.add(merchandiseSiteOptControllers.get(i).getMeanChoiceBox().getValue());
	    	desiredDeliveryDate.add(merchandiseSiteOptControllers.get(i).getDesiredDeliveryDateLbl().getText());
	    }
	    
	    merchandise.setQuantityOrdered(orderedMerchandiseQuantity);
	    merchandise.setDeliveryMean(means);
	    merchandise.setDesiredDeliveryDate(desiredDeliveryDate);
//	    listOfMerchandise.setMerchandises(null);
	    
	    
	    
	    System.out.println("\n\nThông tin Merchandise SAU khi lưu:");
	    System.out.println("Số lượng đặt hàng: " + merchandise.getQuantityOrdered());
		System.out.println("Phương thức giao hàng: " + merchandise.getDeliveryMean());
		System.out.println("Tgian hen: " + merchandise.getDesiredDeliveryDate());
	}
	
    
    public void setMerchandiseData(ListOfMerchandise listOfMerchandise) {
        this.listOfMerchandise = listOfMerchandise;
        merchandiseLbl.setText(merchandise.getMerchandiseCode());
        merchandiseNameLbl.setText(merchandise.getName());
        expectedReceiveDate.setText(merchandise.getOrderSentDate());
        needOrderedQuantityLbl.setText(merchandise.getNeedOrderedQuantity()+"");
        final String SITE_OPTION_FXML_FILE_PATH = "/fxml/dhqt/orderoperation/merchandiseview/SiteOptionView.fxml";

        gridPane.getChildren().clear();

        int column = 0;
        int row = 0;
        
        merchandiseSiteOptControllers.clear();
        for (int i = 0; i < merchandise.getSites().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(SITE_OPTION_FXML_FILE_PATH));

                AnchorPane anchorPane = new AnchorPane();
                anchorPane.setMinHeight(100);
                fxmlLoader.setRoot(anchorPane);

                Site site = merchandise.getSites().get(i);
                MerchandiseSiteOptController merchandiseSiteOptController = new MerchandiseSiteOptController(merchandise, this);
                fxmlLoader.setController(merchandiseSiteOptController);
                merchandiseSiteOptControllers.add(merchandiseSiteOptController);
                fxmlLoader.load();

                merchandiseSiteOptController.setData(merchandise, site, i);
                gridPane.add(anchorPane, column++, row);
                if (column == 1) {
                    column = 0;
                    row++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }


	public void saveSiteOptions(Merchandise merchandise) {
		this.merchandise = merchandise;
			ArrayList<String> means = new ArrayList<String>();
		    ArrayList<Integer> orderedMerchandiseQuantity = new ArrayList<Integer>();
		    ArrayList<String> desiredDeliveryDate = new ArrayList<String>();
		    for(int i = 0; i < merchandiseSiteOptControllers.size(); i++) {
		    	if ( merchandiseSiteOptControllers.get(i).getQuantityTextField().getText() == null ) {
		    		orderedMerchandiseQuantity.add(0);
		    		merchandiseSiteOptControllers.get(i).getQuantityTextField().setText("0");;
		    	} else {
		    		orderedMerchandiseQuantity.add(Integer.parseInt(merchandiseSiteOptControllers.get(i).getQuantityTextField().getText()));
	
		    	}
		    	
		    	means.add(merchandiseSiteOptControllers.get(i).getMeanChoiceBox().getValue());
		    	desiredDeliveryDate.add(merchandiseSiteOptControllers.get(i).getDesiredDeliveryDateLbl().getText());
		    }
		    
		    merchandise.setQuantityOrdered(orderedMerchandiseQuantity);
		    merchandise.setDeliveryMean(means);
		    merchandise.setDesiredDeliveryDate(desiredDeliveryDate);
//		    listOfMerchandise.setMerchandises(null);
	    
	    
	    System.out.println("Số lượng đặt hàng: " + merchandise.getQuantityOrdered());
		System.out.println("Phương thức giao hàng: " + merchandise.getDeliveryMean());
		System.out.println("Tgian hen: " + merchandise.getDesiredDeliveryDate());
	}


//	public void saveSiteOptions(ArrayList<Merchandise> merchandises) {
//		// TODO Auto-generated method stub
//		this.merchandises = merchandises;
//		for (int i = 0; i < merchandises.get)
//	}
}