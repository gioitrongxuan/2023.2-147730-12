package htdh.controller.actor.dhqt;

import htdh.model.common.entity.Order;
import htdh.model.common.entity.Order_Merchandise;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ReOrderConfirmCell implements Initializable {
    private Order order;
    public Label site_lbl;
    public Label mer_code_lbl;
    public Label date_lbl;
    public Label pt_lbl;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
        site_lbl.setText(order.getSiteID());
        String mer_code="";
        for(Order_Merchandise order_merchandise : order.getOrderMerchandiseList()){
           mer_code = appendWithLimit(mer_code, order_merchandise.getMerchandiseCode(), 20);
        }
        mer_code_lbl.setText(mer_code);
        date_lbl.setText(order.getDeliverydate());
        pt_lbl.setText(order.getDeliveryMean());
    }
    public static String appendWithLimit(String original, String toAppend, int limit) {
        String concatenated = original +"-"+ toAppend;

        if (concatenated.length() > limit) {
            return concatenated.substring(0, limit - 3) + "...";
        } else {
            return concatenated;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
