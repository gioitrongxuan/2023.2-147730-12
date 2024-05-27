package htdh.controller.actor.sales.createOrder.child.createOrder.child;

import htdh.common.utils.notification.PopupNotification;
import htdh.common.utils.pageInitialize.DateInitialize;
import htdh.controller.actor.sales.createOrder.child.createOrder.parent.CreateOrder;
import htdh.common.entity.Product;
import htdh.common.utils.searchTools.SearchProducts;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MerchandiseSearch extends CreateOrder {

    @FXML
    private ChoiceBox<Integer> deliveryDay;

    @FXML
    private ChoiceBox<Integer> deliveryMonth;

    @FXML
    private ChoiceBox<Integer> deliveryYear;

    @FXML
    private Text merCode;

    @FXML
    private TextField merQuantity;

    @FXML
    private ChoiceBox<String> merUnit;

    @FXML
    private TextField searchField;

    @FXML
    void addToQueue(ActionEvent event) {
        CreateOrder.addMerchandiseColumnData(
                new MechandiseColumn(
                        merCode.getText(),
                        Integer.parseInt(merQuantity.getText()),
                        merUnit,
                        deliveryDay,
                        deliveryMonth,
                        deliveryYear
                )
        );
        PopupNotification.popupNotification("Thành công", "Đã thêm sản phẩm vào danh sách chờ");
    }

    @FXML
    void searchMechandise(ActionEvent event) {
        try{
            initDateChoiceBox();
            Product searched = SearchProducts.searchProducts("",searchField.getText());
            merCode.setText(searched.getProductCode());
            merUnit.setItems(FXCollections.observableArrayList(searched.getUnit()));
            merQuantity.setText("0");
        } catch  (NullPointerException e){
            merCode.setText("Khong tim thay san pham");
        }

    }

    void initDateChoiceBox() {
        deliveryDay.setItems(DateInitialize.initDays());
        deliveryMonth.setItems(DateInitialize.initMonth());
        deliveryYear.setItems(DateInitialize.initYear());
    }



}
