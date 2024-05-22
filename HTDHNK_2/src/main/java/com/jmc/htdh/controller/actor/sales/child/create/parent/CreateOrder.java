package com.jmc.htdh.controller.actor.sales.child.create.parent;

import com.jmc.htdh.common.utils.notification.PopupNotification ;
import com.jmc.htdh.controller.actor.sales.parent.OrderPage ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.jmc.htdh.common.entity.Merchandise ;

import java.io.IOException;

public class CreateOrder extends OrderPage {
    final String SEARCH_MECHANDISE_PATH = "/view/sales/create/search/MerchandiseSearch.fxml";
    final String QUEUE_MECHANDISE_PATH = "/view/sales/create/queue/MerchandiseQueue.fxml";

    static ObservableList<MechandiseColumn> columnData = FXCollections.observableArrayList();
    @FXML
    public void searchMechandiseButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(SEARCH_MECHANDISE_PATH));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void queueMechandiseButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(QUEUE_MECHANDISE_PATH));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public class MechandiseColumn {
        private CheckBox checkBox;
        private String merchandiseCode;
        private TextField quantityOrdered;
        private ChoiceBox<String> unit;
        private ChoiceBox<Integer> day;
        private ChoiceBox<Integer> month;
        private ChoiceBox<Integer> year;


        public MechandiseColumn(String merchandiseCode,
                                int quantity,
                                ChoiceBox<String> unit,
                                ChoiceBox<Integer> deliveryDay,
                                ChoiceBox<Integer> deliveryMonth,
                                ChoiceBox<Integer> deliveryYear)
        {
            this.checkBox = new CheckBox();
            this.checkBox.setSelected(false);

            this.merchandiseCode = merchandiseCode;
            this.quantityOrdered = new TextField();
            this.quantityOrdered.setText(String.valueOf(quantity));

            this.unit = new ChoiceBox<>();
            this.unit.setItems(unit.getItems());
            this.unit.setValue(unit.getValue());

            this.day = new ChoiceBox<>(); // Initialize day ChoiceBox here
            this.month = new ChoiceBox<>(); // Initialize month ChoiceBox here
            this.year = new ChoiceBox<>(); // Initialize year ChoiceBox here

            this.day.setItems(deliveryDay.getItems());
            this.month.setItems(deliveryMonth.getItems());
            this.year.setItems(deliveryYear.getItems());

            this.day.setValue(deliveryDay.getValue());
            this.month.setValue(deliveryMonth.getValue());
            this.year.setValue(deliveryYear.getValue());
        }

        public MechandiseColumn() {
        }

        public CheckBox getCheckBox() {
            return checkBox;
        }

        public void setCheckBox(CheckBox checkBox) {
            this.checkBox = checkBox;
        }

        public String getMerchandiseCode() {
            return merchandiseCode;
        }

        public void setMerchandiseCode(String merchandiseCode) {
            this.merchandiseCode = merchandiseCode;
        }

        public TextField getQuantityOrdered() {
            return quantityOrdered;
        }

        public void setQuantityOrdered(TextField quantityOrdered) {
            this.quantityOrdered = quantityOrdered;
        }

        public ChoiceBox<String> getUnit() {
            return unit;
        }

        public void setUnit(ChoiceBox<String> unit) {
            this.unit = unit;
        }

        public ChoiceBox<Integer> getDay() {
            return day;
        }

        public void setDay(ChoiceBox<Integer> day) {
            this.day = day;
        }

        public ChoiceBox<Integer> getMonth() {
            return month;
        }

        public void setMonth(ChoiceBox<Integer> month) {
            this.month = month;
        }

        public ChoiceBox<Integer> getYear() {
            return year;
        }

        public void setYear(ChoiceBox<Integer> year) {
            this.year = year;
        }

        public Merchandise getMerchandiseValue(){
            try {
                Merchandise merchandise = new Merchandise();
                merchandise.setMerchandiseCode(this.merchandiseCode);
                merchandise.setUnit(this.unit.getValue());
                merchandise.setQuantityOrdered(Integer.parseInt(this.quantityOrdered.getText()));
                merchandise.setUnit(this.unit.getValue());
                merchandise.setDay(this.day.getValue());
                merchandise.setMonth(this.month.getValue());
                merchandise.setYear(this.year.getValue());
                return merchandise;
            }catch (NumberFormatException e){
                PopupNotification.popupNotification("Lỗi dữ liệu", "Số lượng phải là số nguyên");
                return null;
            }
        }
    }

    public static void addMerchandiseColumnData(MechandiseColumn mer){
        columnData.add(mer);
    }

    protected static ObservableList<MechandiseColumn> getColumnData(){
        return columnData;
    }

    protected static void cleanColumnData(){
        columnData = FXCollections.observableArrayList();
    }
}
