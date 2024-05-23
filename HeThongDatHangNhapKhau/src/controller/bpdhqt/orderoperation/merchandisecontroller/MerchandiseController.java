package controller.bpdhqt.orderoperation.merchandisecontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.bpdhqt.orderoperation.listmodel.ListOfMerchandise;
import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;
import model.sitemodel.Site;

public class MerchandiseController {
    private Merchandise merchandise;
    private ListOfMerchandise listOfMerchandise;
    private Site site;
    private MerchandiseSiteOptController merchandiseSiteOptController;
    private ArrayList<MerchandiseSiteOptController> merchandiseSiteOptControllers = new ArrayList<MerchandiseSiteOptController>();

    public MerchandiseController(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

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
	    for( int i = 0; i < merchandise.getDeliveryMean().size();i++) {
			System.out.println("Phương thức giao hàng: " + merchandise.getDeliveryMean().get(i));
		}

	    ArrayList<String> means = new ArrayList<String>();
	    ArrayList<Integer> orderedMerchandiseQuantity = new ArrayList<Integer>();
	    for(int i = 0; i < merchandiseSiteOptControllers.size(); i++) {
	    	if ( merchandiseSiteOptControllers.get(i).getQuantityTextField().getText() == null ) {
	    		orderedMerchandiseQuantity.add(0);
	    		merchandiseSiteOptControllers.get(i).getQuantityTextField().setText("0");;
	    	} else {
	    		orderedMerchandiseQuantity.add(Integer.parseInt(merchandiseSiteOptControllers.get(i).getQuantityTextField().getText()));

	    	}
	    	
	    	means.add(merchandiseSiteOptControllers.get(i).getMeanChoiceBox().getValue());
	    }
	    
	    merchandise.setQuantityOrdered(orderedMerchandiseQuantity);
	    merchandise.setDeliveryMean(means);
//	    listOfMerchandise.setMerchandises(null);
	    
	    
	    
	    System.out.println("\n\nThông tin Merchandise SAU khi lưu:");
	    System.out.println("Số lượng đặt hàng: " + merchandise.getQuantityOrdered());
	    for( int i = 0; i < merchandise.getDeliveryMean().size();i++) {
			System.out.println("Phương thức giao hàng: " + merchandise.getDeliveryMean());
		}
	}
	
    
    public void setMerchandiseData(ListOfMerchandise listOfMerchandise) {
        this.listOfMerchandise = listOfMerchandise;
        merchandiseLbl.setText(merchandise.getMerchandiseCode());
        merchandiseNameLbl.setText(merchandise.getName());
        final String SITE_OPTION_FXML_FILE_PATH = "/view/bpdhqt/orderoperation/merchandiseview/SiteOptionView.fxml";

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
                MerchandiseSiteOptController merchandiseSiteOptController = new MerchandiseSiteOptController(merchandise);
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


	public void saveSiteOptions(ListOfMerchandise listOfMerchandise) {
		System.out.println("Hello");
		ArrayList<String> means = new ArrayList<String>();
	    ArrayList<Integer> orderedMerchandiseQuantity = new ArrayList<Integer>();
	    for(int i = 0; i < merchandiseSiteOptControllers.size(); i++) {
	    	if ( merchandiseSiteOptControllers.get(i).getQuantityTextField().getText() == null ) {
	    		orderedMerchandiseQuantity.add(0);
	    		merchandiseSiteOptControllers.get(i).getQuantityTextField().setText("0");;
	    	} else {
	    		orderedMerchandiseQuantity.add(Integer.parseInt(merchandiseSiteOptControllers.get(i).getQuantityTextField().getText()));

	    	}
	    	
	    	means.add(merchandiseSiteOptControllers.get(i).getMeanChoiceBox().getValue());
	    }
	    
	    merchandise.setQuantityOrdered(orderedMerchandiseQuantity);
	    merchandise.setDeliveryMean(means);
	}



}
