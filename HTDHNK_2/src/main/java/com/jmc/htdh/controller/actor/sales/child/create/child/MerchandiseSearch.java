package com.jmc.htdh.controller.actor.sales.child.create.child;

import com.jmc.htdh.common.utils.pageInitialize.DateInitialize;
import com.jmc.htdh.controller.actor.sales.child.create.parent.CreateOrder;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import com.jmc.htdh.common.entity.Product;
import com.jmc.htdh.common.utils.searchTools.SearchProducts;

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
