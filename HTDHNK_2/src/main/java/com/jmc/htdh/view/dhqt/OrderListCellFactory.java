package com.jmc.htdh.view.dhqt;

import com.jmc.htdh.controller.bpdhqt.OrderListCellController;
import com.jmc.htdh.model.actor.dhqt.Order;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class OrderListCellFactory  extends ListCell<Order> {

    @Override
    protected void updateItem (Order order, boolean empty){
        super.updateItem(order ,empty);
        if(empty){
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BPDHQT/OrderListCell.fxml"));
            OrderListCellController controller = new OrderListCellController(order);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
