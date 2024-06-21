package htdh.controller.actor.dhqt;

import htdh.controller.actor.dhqt.reorder.ReorderController;
import htdh.model.actor.dhqt.Model;
import htdh.model.actor.site.Site;
import htdh.model.common.entity.Order;
import htdh.model.common.entity.Order_Merchandise;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

public class TitlePaneReOrderController implements Initializable {
    public String getSiteCanceled() {
        return siteCanceled;
    }

    public void setSiteCanceled(String siteCanceled) {
        this.siteCanceled = siteCanceled;
    }

    private String siteCanceled;
    public Label merchandiseID_lbl;
    public Label merchandiseName_lbl;
    public Label quantity_lbl;
    public Label selected;
    public Label unit_lbl;
    public Label requestDate_lbl;


    public GridPane gridPane;

    public Order_Merchandise getMerchandise() {
        return merchandise;
    }

    private Order_Merchandise merchandise;

    private ReorderController reorderController = new ReorderController();
    private List<ListSiteCellController> listSiteCellControllers = FXCollections.observableArrayList();

    public List<ListSiteCellController> getListSiteCellControllers() {
        return listSiteCellControllers;
    }

    public void setListSiteCellControllers(List<ListSiteCellController> listSiteCellControllers) {
        this.listSiteCellControllers = listSiteCellControllers;
    }

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
        ResultSet resultSet = Model.getInstance().getDatabaseDriver().findListSite(merchandise.getMerchandiseCode(),siteCanceled);
        System.out.println("siteCanceled"+siteCanceled);
        final String SITE_OPTION_FXML_FILE_PATH = "/fxml/dhqt/accordion/ListSiteCell.fxml";
        merchandise.setSiteId(siteCanceled);
        List<Site> listSite = reorderController.getListSite(merchandise);
        gridPane.getChildren().clear();
            int column = 0;
            int row = 0;
                for(Site site : listSite) {

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource(SITE_OPTION_FXML_FILE_PATH));
                        ListSiteCellController listSiteCellController = new ListSiteCellController();
                        listSiteCellController.setTitlePaneReOrderController(this);
                        fxmlLoader.setController(listSiteCellController);
                        gridPane.add(fxmlLoader.load(), 0, row);
                        listSiteCellController.setData(site);
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
                        listSiteCellControllers.add(listSiteCellController);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                row++;
                }

                





    }
}
