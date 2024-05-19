package controller.bpdhqt.orderoperation.merchandisecontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;
import model.sitemodel.Site;

public class MerchandiseController {
    private Merchandise merchandise;
    private Site site;

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
    void infoVBoxClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert merchandiseDetailPane != null : "fx:id=\"merchandiseDetailPane\" was not injected: check your FXML file 'merchandiseoverview.fxml'.";
        assert merchandiseLbl != null : "fx:id=\"merchandiseLbl\" was not injected: check your FXML file 'merchandiseoverview.fxml'.";
        assert merchandiseNameLbl != null : "fx:id=\"merchandiseNameLbl\" was not injected: check your FXML file 'merchandiseoverview.fxml'.";
    }

    public void setMerchandiseData(Merchandise merchandise) {
        this.merchandise = merchandise;
        merchandiseLbl.setText(merchandise.getMerchandiseCode());
        merchandiseNameLbl.setText(merchandise.getName());
        final String SITE_OPTION_FXML_FILE_PATH = "/view/bpdhqt/orderoperation/merchandiseview/SiteOptionView.fxml";
        // Xóa tất cả các nút hiện có trong merchandiseDetailPane
        gridPane.getChildren().clear();
        // Thêm các giao diện từ file FXML thứ hai vào merchandiseDetailPane
        int column = 0;
        int row = 0;
        int paneHeight;
        int siteOptPaneHeight;
        
        for (int i = 0; i < merchandise.getSites().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(SITE_OPTION_FXML_FILE_PATH));

                AnchorPane anchorPane = new AnchorPane();
                fxmlLoader.setRoot(anchorPane);

                Site site = merchandise.getSites().get(i);
                MerchandiseSiteOptController merchandiseSiteOptController = new MerchandiseSiteOptController(merchandise, site, i);
                fxmlLoader.setController(merchandiseSiteOptController);
                fxmlLoader.load();

                merchandiseSiteOptController.setData(merchandise, site, i);
                gridPane.add(anchorPane, column++, row);
                if (column == 1) {
                    column = 0;
                    row++;
                }
                
                
                siteOptPaneHeight = (int) anchorPane.getScaleY();
                paneHeight = (int) merchandiseDetailPane.getHeight();
                if (siteOptPaneHeight > paneHeight) {
                	merchandiseDetailPane.setMaxHeight(paneHeight + 100);
                	paneHeight = (int) merchandiseDetailPane.getHeight();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        }
        
    }
}
