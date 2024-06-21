package htdh.controller.actor.dhqt;

import htdh.model.actor.dhqt.Model;
import htdh.model.common.entity.Order;
import htdh.model.common.entity.Order_Merchandise;
import htdh.model.common.entity.CanceledOrder;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class CanceledOrderListController implements Initializable {
    private List<TitlePaneReOrderController> titlePaneReOrderControllers = FXCollections.observableArrayList();

    public ListView order_listview;
    public Accordion list_merchan_site_acd;
    public TextField filter;

    public ChoiceBox filter_choibox;
    public Label delivery_mean_ldl;
    public Label site_lbl1;
    public Label order_date_lbl;
    public Button reorder_btn;
    public Button deleteOrder;
    private List<Order_Merchandise> order_merchandises = FXCollections.observableArrayList();
    public List<TitlePaneReOrderController> getTitlePaneReOrderControllers() {
        return titlePaneReOrderControllers;
    }

    public void setTitlePaneReOrderControllers(List<TitlePaneReOrderController> titlePaneReOrderControllers) {
        this.titlePaneReOrderControllers = titlePaneReOrderControllers;
    }

    @Override
    public void initialize(URL url, ResourceBundle resources) {
        ObservableList<Order> canceledOrders = FXCollections.observableArrayList(Model.getInstance().getDatabaseDriver().getCanceledOrders());
        FilteredList<Order> filteredData = new FilteredList<>(canceledOrders, p -> true);
        order_listview.setItems(filteredData);
        deleteOrder.disableProperty().bind(Bindings.isEmpty(order_listview.getSelectionModel().getSelectedItems()));
        deleteOrder.setOnAction(event -> {
            Order selectedOrder = (Order) order_listview.getSelectionModel().getSelectedItem();
            if (selectedOrder != null) {
                Model.getInstance().getDatabaseDriver().deleteCancelOrder(selectedOrder.getOrderID());
                canceledOrders.remove(selectedOrder);
                order_listview.refresh();
                list_merchan_site_acd.getPanes().clear();
            }
        });
        reorder_btn.setOnAction(event -> {
            Order selectedOrder = (Order) order_listview.getSelectionModel().getSelectedItem();
            if (selectedOrder != null) {
                for (TitlePaneReOrderController titlePaneReOrderController : titlePaneReOrderControllers) {
                    for (ListSiteCellController listSiteCellController : titlePaneReOrderController.getListSiteCellControllers()) {
                       this.order_merchandises.add(listSiteCellController.getOrder_merchandise());
                    }
                }
                Model.getInstance().getDatabaseDriver().deleteCancelOrder(selectedOrder.getOrderID());
                canceledOrders.remove(selectedOrder);
                order_listview.refresh();
                list_merchan_site_acd.getPanes().clear();
            }
        });


        // Add a listener to the filter text field
        filter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(order -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String filterText = newValue.toLowerCase();
                return String.valueOf(order.getOrderID()).toLowerCase().contains(filterText);
            });
        });

        order_listview.setCellFactory(new Callback<ListView<Order>, ListCell<Order>>() {
            @Override
            public ListCell<Order> call(ListView<Order> param) {
                return new ListCell<Order>() {
                    @Override
                    protected void updateItem(Order canceledOrder, boolean empty) {
                        // ...

                        super.updateItem(canceledOrder, empty);
                        if (empty) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dhqt/CanceledOrderListCell.fxml"));
                            CanceledOrderListCellController controller = new CanceledOrderListCellController(canceledOrder);
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
                Order selectedOrder = (Order) newValue;
                // Handle the selected RejectOrder
                System.out.println("Selected RejectOrder: " + selectedOrder.getOrderID());

                list_merchan_site_acd.getPanes().clear();
                order_date_lbl.setText(selectedOrder.getOrderSentDate());
                delivery_mean_ldl.setText(selectedOrder.getDeliveryMean());
                site_lbl1.setText(selectedOrder.getSiteID());
                ObservableList<Order_Merchandise> mechandises = FXCollections.observableArrayList(Model.getInstance().getDatabaseDriver().getOrderMerchandises(selectedOrder.getOrderID()));
                for (Order_Merchandise merchandise : mechandises) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dhqt/accordion/TitlePaneReOrder.fxml"));
                    TitlePaneReOrderController controller = new TitlePaneReOrderController(merchandise);
                    loader.setController(controller);
                    try {
                        list_merchan_site_acd.getPanes().add(loader.load());
                        titlePaneReOrderControllers.add(controller);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }


        });

    }
}
