package htdh.controller.actor.dhqt;

import htdh.model.common.entity.Order;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CanceledOrderListCellController implements Initializable{
    public CanceledOrderListCellController(Order canceledOrder) {
        this.canceledOrder = canceledOrder;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        canceled_orderID.setText(canceledOrder.getOrderID());
        order_name_lbl.setText(canceledOrder.getSiteName());
    }
    public Order getRejectOrder() {
        return canceledOrder;
    }

    private Order canceledOrder;
    public Label canceled_orderID;
    public Label order_name_lbl;



    public void setCanceled_orderID(Label canceled_orderID) {
        this.canceled_orderID = canceled_orderID;
    }

    public Label getCanceled_orderID() {
        return canceled_orderID;
    }
}
