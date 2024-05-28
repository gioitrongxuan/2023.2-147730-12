package htdh.controller.actor.dhqt;

import htdh.controller.actor.sales.child.create.parent.CreateOrder;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;
import htdh.model.common.entity.Order_Merchandise;
import htdh.model.common.entity.RejectOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
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
    public Accordion list_merchan_site_acd;

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

        // Add a listener to the selected item property
        order_listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RejectOrder selectedOrder = (RejectOrder) newValue;
                // Handle the selected RejectOrder
                System.out.println("Selected RejectOrder: " + selectedOrder.getRejectOrderID());
            }
        });
        ObservableList<Order_Merchandise> mechandises = FXCollections.observableArrayList();
        mechandises.addAll(new  Order_Merchandise("ID1","Name1","Site1",1,"Unit1","DeliveryMean1","OrderOfSale1",1,"OrderSentDate1","DesiredDeliveryDate1"));
        mechandises.addAll(new  Order_Merchandise("ID2","Name2","Site2",2,"Unit2","DeliveryMean2","OrderOfSale2",2,"OrderSentDate2","DesiredDeliveryDate2"));
        mechandises.addAll(new  Order_Merchandise("ID3","Name3","Site3",3,"Unit3","DeliveryMean3","OrderOfSale3",3,"OrderSentDate3","DesiredDeliveryDate3"));
        mechandises.addAll(new  Order_Merchandise("ID4","Name4","Site4",4,"Unit4","DeliveryMean4","OrderOfSale4",4,"OrderSentDate4","DesiredDeliveryDate4"));
        mechandises.addAll(new  Order_Merchandise("ID5","Name5","Site5",5,"Unit5","DeliveryMean5","OrderOfSale5",5,"OrderSentDate5","DesiredDeliveryDate5"));
        list_merchan_site_acd.getPanes().clear();
        for (Order_Merchandise merchandise : mechandises) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dhqt/accordion/TitlePaneReOrder.fxml"));
            TitlePaneReOrderController controller = new TitlePaneReOrderController(merchandise);
            loader.setController(controller);
            try {
                list_merchan_site_acd.getPanes().add( loader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
