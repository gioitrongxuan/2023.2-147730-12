package test;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PopUpOfAMerchandiseController {
    @FXML
    private Label siteCodeLabel;

    @FXML
    private Label merchandiseCodeLabel;

    @FXML
    private Label saleCodeLabel;
    
    @FXML
    private Label quanlityOrderLabel;
    
    @FXML
    private TextField quanlityActualTextField;

    @FXML
    private Label unitLabel;
    
    @FXML
    private Label arrivalDateLabel;
    
    @FXML
    private TextArea noteTextArea;

    private ListOfOrderToWarehouseManagementModel aMerchandise;

    private ListOfOrderToWarehouseManagementController parentListOfOrderToWarehouseManagementController;
    
    private ObservableList<ListOfOrderToWarehouseManagementModel> searchResult;
    
    public void setSearchResult(ObservableList<ListOfOrderToWarehouseManagementModel> result) {
        searchResult = result;
    }
    
    private ObservableList<test.ListOfOrderToWarehouseManagementModel> orderList;
    
    public void setLists(ObservableList<test.ListOfOrderToWarehouseManagementModel> orderList2, ObservableList<test.ListOfOrderToWarehouseManagementModel> observableList) {
        orderList = orderList2;
        searchResult = observableList;
    }

    public void setParentController(ListOfOrderToWarehouseManagementController parentController) {
        this.parentListOfOrderToWarehouseManagementController = parentController;
    }

    public void setAMerchandise(test.ListOfOrderToWarehouseManagementModel selected) {
        this.aMerchandise = selected;
        siteCodeLabel.setText(selected.getSiteCode());
        merchandiseCodeLabel.setText(selected.getMerchandiseCode());
        saleCodeLabel.setText(selected.getSaleCode());
        quanlityOrderLabel.setText(String.valueOf(selected.getQuanlityOrder()));
        quanlityActualTextField.setText(String.valueOf(selected.getQuanlityActual()));
        unitLabel.setText(selected.getUnit());
        arrivalDateLabel.setText(selected.getArrivalDate());
        noteTextArea.setText(selected.getNote());
    }

    @FXML
    public void saveChanges(ActionEvent e) {
        String siteCode = siteCodeLabel.getText();
        String merchandiseCode = merchandiseCodeLabel.getText();
        String saleCode = saleCodeLabel.getText();
        int quanlityOrder = Integer.parseInt(quanlityOrderLabel.getText());
        int quanlityActual = Integer.parseInt(quanlityActualTextField.getText());
        String unit = unitLabel.getText();
        String arrivalDate = arrivalDateLabel.getText();
        String note = noteTextArea.getText();

        ListOfOrderToWarehouseManagementModel updatedAMerchandise = new ListOfOrderToWarehouseManagementModel(siteCode, merchandiseCode, saleCode, quanlityOrder, quanlityActual, unit, arrivalDate, note, "checked");

        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getMerchandiseCode().equals(updatedAMerchandise.getMerchandiseCode())) {
                orderList.set(i, updatedAMerchandise);
                break;
            }
        }

        for (int i = 0; i < searchResult.size(); i++) {
            if (searchResult.get(i).getMerchandiseCode().equals(updatedAMerchandise.getMerchandiseCode())) {
                searchResult.set(i, updatedAMerchandise);
                break;
            }
        }

        if (parentListOfOrderToWarehouseManagementController != null) {
            parentListOfOrderToWarehouseManagementController.refreshTable();
        }

        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void goBack(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }
}
