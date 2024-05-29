package htdh.controller.actor.dhqt;

import htdh.controller.actor.dhqt.merchandisecontroller.MerchandiseSiteOptController;
import htdh.model.actor.dhqt.Model;
import htdh.model.actor.sitemodel.Site;
import htdh.model.common.entity.Order;
import htdh.model.common.entity.Order_Merchandise;
import htdh.model.common.entity.CanceledOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class TitlePaneReOrderController implements Initializable {
    public Label merchandiseID_lbl;
    public Label merchandiseName_lbl;
    public Label quantity_lbl;
    public Label selected;
    public Label unit_lbl;
    public Label requestDate_lbl;

    public GridPane gridPane;

    private Order_Merchandise merchandise;

    public TitlePaneReOrderController(Order_Merchandise merchandise) {
        this.merchandise = merchandise;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        merchandiseID_lbl.setText(merchandise.getMerchandiseCode());
        merchandiseName_lbl.setText(merchandise.getName());
        quantity_lbl.setText(String.valueOf(merchandise.getQuantityOrdered()));
        unit_lbl.setText(merchandise.getUnit());
        requestDate_lbl.setText(merchandise.getDeliveryDate());

        ObservableList<Order> canceledOrders = FXCollections.observableArrayList();
        setCellSite();

    }

    public void setCellSite() {
        ResultSet resultSet = Model.getInstance().getDatabaseDriver().findListSite(merchandise.getMerchandiseCode());
        final String SITE_OPTION_FXML_FILE_PATH = "/fxml/dhqt/accordion/ListSiteCell.fxml";
        gridPane.getChildren().clear();
        try {
            int column = 0;
            int row = 0;
            while (resultSet.next()) {


                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource(SITE_OPTION_FXML_FILE_PATH));
                        ListSiteCellController listSiteCellController = new ListSiteCellController();
                        listSiteCellController.setTitlePaneReOrderController(this);
                        System.out.println(resultSet.getString("site_id"));
                        fxmlLoader.setController(listSiteCellController);
                        gridPane.add(fxmlLoader.load(), 0, row);
                        listSiteCellController.setData(resultSet);
                        listSiteCellController.selected_tld.textProperty().addListener((observable, oldValue, newValue) -> {

                                int s = Integer.parseInt(selected.getText());
                                int r = Integer.parseInt(quantity_lbl.getText());
                                int o = oldValue != null && !oldValue.isEmpty() ? Integer.parseInt(oldValue) : 0;
                                int n = newValue != null && !newValue.isEmpty() ? Integer.parseInt(newValue) : 0;
                                s = s - o + n;
                                selected.setText(String.valueOf(s)); // Update quantity_lbl with the value from selected_tld
                                if(r>s){
                                    selected.setStyle("-fx-text-fill: red;");
                                } else
                                    if (r==s){
                                        selected.setStyle("-fx-text-fill: green;");
                                    }

                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                row++;

                }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
