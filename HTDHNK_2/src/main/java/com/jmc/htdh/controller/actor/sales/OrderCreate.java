package com.jmc.htdh.controller.actor.sales;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import com.jmc.htdh.model.common.entity.Product;
import com.jmc.htdh.model.common.utils.SearchProductsUtils;

import java.util.ArrayList;

public class OrderCreate extends OrderPage{

    private ObservableList<Product> products;

    @FXML
    private ChoiceBox<?> deliveryDay;

    @FXML
    private ChoiceBox<?> deliveryMonth;

    @FXML
    private ChoiceBox<?> deliveryYear;

    @FXML
    private Text merCode;

    @FXML
    private Text merQuantity;

    @FXML
    private ChoiceBox<String> merUnit;

    @FXML
    private TextField searchField;

    @FXML
    void addToQueue(ActionEvent event) {

    }

    @FXML
    void queueProductPress(ActionEvent event) {

    }

    @FXML
    void searchMechandise(ActionEvent event) {

        Product searched = SearchProductsUtils.searchProducts("",searchField.getText());
        merCode.setText(searched.getProductCode());
        merUnit.setItems(FXCollections.observableArrayList(searched.getUnit()));
        
    }

    @FXML
    void searchProductPress(ActionEvent event) {

    }

    void setupDate(){

    }

}
