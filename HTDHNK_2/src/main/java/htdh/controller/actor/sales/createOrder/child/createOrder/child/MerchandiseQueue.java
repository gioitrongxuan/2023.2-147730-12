package htdh.controller.actor.sales.createOrder.child.createOrder.child;

import htdh.common.utils.notification.PopupNotification;
import htdh.controller.actor.sales.createOrder.child.createOrder.parent.CreateOrder;
import htdh.common.entity.Merchandise;
import htdh.model.actor.sales.ViewModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MerchandiseQueue extends CreateOrder {

    @FXML
    private TableColumn<?, ?> checkbox;

    @FXML
    private TableColumn<?, ?> orderID;

    @FXML
    private TableColumn<?, ?> orderQuantity;

    @FXML
    private TableColumn<?, ?> orderReceivedDay;

    @FXML
    private TableColumn<?, ?> orderReceivedMonth;

    @FXML
    private TableColumn<?, ?> orderReceivedYear;

    @FXML
    private TableColumn<?, ?> orderUnit;

    @FXML
    private TextField searchField;

    @FXML
    private TableView<MechandiseColumn> table;

    ObservableList<MechandiseColumn> data;

    @FXML
    void createOrder(ActionEvent event) {
        ArrayList<Merchandise> selectedMechandise = getSelectedMechandiseColumn();
        if (selectedMechandise.size()>0){
            PopupNotification.popupNotification("Thành công", "Đơn hàng đã được tạo thành công");
            cleanColumnData();
            initialize();
            ViewModel.getInstance().createOrder(selectedMechandise);
        }else{
            PopupNotification.popupNotification("Thất bại", "Không có sản phẩm trong giỏ hàng");
        }
    }

    @FXML
    public void initialize(){
        data = CreateOrder.getColumnData();

        checkbox.setCellValueFactory(
                new PropertyValueFactory<>("checkBox")
        );

        orderID.setCellValueFactory(
                new PropertyValueFactory<>("merchandiseCode")
        );

        orderQuantity.setCellValueFactory(
                new PropertyValueFactory<>("quantityOrdered")
        );

        orderUnit.setCellValueFactory(
                new PropertyValueFactory<>("unit")
        );

        orderReceivedYear.setCellValueFactory(
                new PropertyValueFactory<>("year")
        );

        orderReceivedMonth.setCellValueFactory(
                new PropertyValueFactory<>("month")
        );

        orderReceivedDay.setCellValueFactory(
                new PropertyValueFactory<>("day")
        );

        table.setItems(data);
    }

    public ArrayList<Merchandise> getSelectedMechandiseColumn(){
        MechandiseColumn merchandise;
        Merchandise currentMerchandise;
        ArrayList<Merchandise> selectedMerchandise = new ArrayList<Merchandise>();
        for (int i=0; i<table.getItems().size();i++){
            merchandise = table.getItems().get(i);
            if (merchandise.getCheckBox().isSelected()){
                currentMerchandise = merchandise.getMerchandiseValue();
                if(currentMerchandise==null) return null;
                selectedMerchandise.add(currentMerchandise);
                System.out.println(merchandise.getMerchandiseCode());
            }
        }
        return selectedMerchandise;
    }
}
