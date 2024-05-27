package htdh.controller.actor.dhqt;

import htdh.model.common.entity.RejectOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.fxml.FXMLLoader;

public class RejectOrderListController implements Initializable {

    public ListView order_listview;

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        ObservableList<RejectOrder> rejectOrders = FXCollections.observableArrayList();
        rejectOrders.addAll(new RejectOrder("ID1",new Date()));
        rejectOrders.addAll(new RejectOrder("ID2",new Date()));
        rejectOrders.addAll(new RejectOrder("ID3",new Date()));
        rejectOrders.addAll(new RejectOrder("ID4",new Date()));
        rejectOrders.addAll(new RejectOrder("ID5",new Date()));
        order_listview.setItems(rejectOrders);
        order_listview.setCellFactory(new Callback<ListView<RejectOrder>, ListCell<RejectOrder>>() {
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
