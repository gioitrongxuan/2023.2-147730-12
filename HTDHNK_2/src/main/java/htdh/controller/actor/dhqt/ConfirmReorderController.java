package htdh.controller.actor.dhqt;

import htdh.model.actor.site.Site;
import htdh.model.common.entity.Order;
import htdh.model.common.entity.Order_Merchandise;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ConfirmReorderController implements Initializable {
    public GridPane ReOrderGridPane;
    public List<Order> listOrder = FXCollections.observableArrayList();
    public void initialize(URL location, ResourceBundle resources) {
        final String SITE_OPTION_FXML_FILE_PATH = "/fxml/dhqt/Reorder.fxml";
        ReOrderGridPane.getChildren().clear();
        int column = 0;
        int row = 0;

        for(Order order : listOrder) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(SITE_OPTION_FXML_FILE_PATH));
                ReOrderConfirmCell reOrderConfirmCell = new ReOrderConfirmCell();
                reOrderConfirmCell.setOrder(order);
                fxmlLoader.setController(reOrderConfirmCell);
                ReOrderGridPane.add(fxmlLoader.load(), 0, row);
            } catch (IOException e) {
                e.printStackTrace();
            }
            row++;
        }
    }
}
