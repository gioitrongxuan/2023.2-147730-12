package htdh.controller.actor.dhqt;

import htdh.model.common.entity.RejectOrder;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RejectOrderListCellController implements Initializable{
    public RejectOrderListCellController(RejectOrder rejectOrder) {
        this.rejectOrder = rejectOrder;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        reject_orderID.setText(rejectOrder.getRejectOrderID());
    }
    public RejectOrder getRejectOrder() {
        return rejectOrder;
    }

    private RejectOrder rejectOrder;
    public Label reject_orderID;



    public void setReject_orderID(Label reject_orderID) {
        this.reject_orderID = reject_orderID;
    }

    public Label getReject_orderID() {
        return reject_orderID;
    }
}
