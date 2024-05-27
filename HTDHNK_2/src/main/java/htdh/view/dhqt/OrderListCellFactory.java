package htdh.view.dhqt;

import htdh.controller.actor.dhqt.OrderListCellController;
import htdh.model.actor.dhqt.Order;
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dhqt/OrderListCell.fxml"));
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
