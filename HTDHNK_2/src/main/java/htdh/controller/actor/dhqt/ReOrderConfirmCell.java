package htdh.controller.actor.dhqt;

import htdh.model.common.entity.Order;
import javafx.scene.control.Label;

public class ReOrderConfirmCell {
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
    }
}
