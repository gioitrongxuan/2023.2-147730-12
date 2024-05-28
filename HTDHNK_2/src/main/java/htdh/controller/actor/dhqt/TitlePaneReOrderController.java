package htdh.controller.actor.dhqt;

import htdh.model.common.entity.Order_Merchandise;
import htdh.model.common.entity.RejectOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class TitlePaneReOrderController implements Initializable {
    public Label merchandiseID_lbl;
    public Label merchandiseName_lbl;
    public Label quantity_lbl;
    public Label unit_lbl;
    public Label requestDate_lbl;
    public ListView list_site;

    private Order_Merchandise merchandise;
    public TitlePaneReOrderController(Order_Merchandise merchandise){
        this.merchandise = merchandise;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        merchandiseID_lbl.setText(merchandise.getMerchandiseCode());
        merchandiseName_lbl.setText(merchandise.getName());
        quantity_lbl.setText(String.valueOf(merchandise.getQuantity()));
        unit_lbl.setText(merchandise.getUnit());
        requestDate_lbl.setText(merchandise.getDesiredDeliveryDate());

        ObservableList<RejectOrder> rejectOrders = FXCollections.observableArrayList();
        rejectOrders.addAll(new RejectOrder("ID1",new Date()));
        rejectOrders.addAll(new RejectOrder("ID2",new Date()));
        rejectOrders.addAll(new RejectOrder("ID3",new Date()));

        list_site.setItems(rejectOrders);
        list_site.setCellFactory(new Callback<ListView<RejectOrder>, ListCell<RejectOrder>>() {
            @Override
            public ListCell<RejectOrder> call(ListView<RejectOrder> param) {
                return new ListCell<RejectOrder>(){
                    @Override
                    protected void updateItem(RejectOrder rejectOrder, boolean empty) {
                        // ...

                        super.updateItem(rejectOrder, empty);
                        if (empty) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dhqt/RejectOrderListCell.fxml"));
                            RejectOrderListCellController controller = new RejectOrderListCellController(rejectOrder);
                            loader.setController(controller);
                            setText(null);
                            try {
                                setGraphic(loader.load());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
            }
        });

    }
}
