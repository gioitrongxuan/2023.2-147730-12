package htdh.controller.warehousemanagement;

import htdh.model.warehousemanagement.ListOfOrderToWarehouseManagementModel;
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
    
    @FXML
    private TextField statusTextField;

    private ListOfOrderToWarehouseManagementModel aMerchandise;

    private ListOfOrderToWarehouseManagementController parentListOfOrderToWarehouseManagementController; // Thêm tham chiếu đến controller cha
    
    private ObservableList<ListOfOrderToWarehouseManagementModel> searchResult; // Danh sách sinh viên kết quả tìm kiếm

    public void setSearchResult(ObservableList<ListOfOrderToWarehouseManagementModel> result) {
        searchResult = result;
    }
    
    private ObservableList<ListOfOrderToWarehouseManagementModel> orderList; // Danh sách sinh viên ban đầu
    
    public void setLists(ObservableList<ListOfOrderToWarehouseManagementModel> list, ObservableList<ListOfOrderToWarehouseManagementModel> result) {
        orderList = list;
        searchResult = result;
    }

    public void setParentController(ListOfOrderToWarehouseManagementController parentController) {
        this.parentListOfOrderToWarehouseManagementController = parentController;
    }

    public void setAMerchandise(ListOfOrderToWarehouseManagementModel aMerchandise) {
        this.aMerchandise = aMerchandise;
        siteCodeLabel.setText(aMerchandise.getSiteCode());
        merchandiseCodeLabel.setText(aMerchandise.getMerchandiseCode());
        saleCodeLabel.setText(aMerchandise.getSaleCode());
        quanlityOrderLabel.setText(String.valueOf(aMerchandise.getQuanlityOrder()));
        quanlityActualTextField.setText(String.valueOf(aMerchandise.getQuanlityActual()));
        unitLabel.setText(aMerchandise.getUnit());
        arrivalDateLabel.setText(aMerchandise.getArrivalDate());
        noteTextArea.setText(aMerchandise.getNote());
        statusTextField.setText(aMerchandise.getStatus());
    }

    @FXML
    public void saveChanges(ActionEvent e) {
        // Lấy thông tin sinh viên từ giao diện
    	String siteCode = siteCodeLabel.getText();
        String merchandiseCode = merchandiseCodeLabel.getText();
        String saleCode = saleCodeLabel.getText();
        int quanlityOrder = Integer.parseInt(quanlityOrderLabel.getText());
        int quanlityActual = Integer.parseInt(quanlityActualTextField.getText());
        String unit = unitLabel.getText();
        String arrivalDate = arrivalDateLabel.getText();
        String note = noteTextArea.getText();
        String status = statusTextField.getText();

        // Tạo đối tượng Student mới
        ListOfOrderToWarehouseManagementModel updatedAMerchandise 
        	= new ListOfOrderToWarehouseManagementModel(siteCode, merchandiseCode, saleCode,
        			quanlityOrder, quanlityActual, unit, arrivalDate, note, status);

        // Tìm và cập nhật thông tin sinh viên trong danh sách ban đầu
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getMerchandiseCode() == updatedAMerchandise.getMerchandiseCode()) {
                orderList.set(i, updatedAMerchandise);
                break;
            }
        }

        // Tìm và cập nhật thông tin sinh viên trong danh sách kết quả tìm kiếm
        for (int i = 0; i < searchResult.size(); i++) {
            if (searchResult.get(i).getMerchandiseCode() == updatedAMerchandise.getMerchandiseCode()) {
                searchResult.set(i, updatedAMerchandise);
                break;
            }
        }

        // Đóng cửa sổ popup
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    public void goBack(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close(); // Đóng popup khi nhấn nút "Back"
    }
}
