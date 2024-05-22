package com.jmc.htdh.model.actor.internationalOrder.orderoperation.merchandisecontroller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import com.jmc.htdh.model.actor.internationalOrder.orderoperation.merchandisemodel.Merchandise;
import com.jmc.htdh.model.actor.site.Site;

public class MerchandiseController {
	private Merchandise merchandise;
	private Site site;
	
	public MerchandiseController(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

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
        if (merchandise != null) {
            // Xóa tất cả các nút hiện có trong merchandiseDetailPane
            merchandiseDetailPane.getChildren().clear();

            // Thêm các giao diện từ file FXML thứ hai vào merchandiseDetailPane
            for (int i = 0; i < merchandise.getSites().size(); i++) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/bpdhqt/orderoperation/merchandiseview/optionview/siteoptionview.fxml"));
                    VBox siteLayout = loader.load();
                    // Gọi phương thức để thiết lập dữ liệu của Site vào giao diện đã tải
                    MerchandiseSiteOptController merchandiseSiteOptController = loader.getController();
                    merchandiseSiteOptController.setData(merchandise, site, i);
                    // Thêm giao diện của Site vào merchandiseDetailPane
                    merchandiseDetailPane.getChildren().add(siteLayout);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
