package htdh.controller.warehousemanagement;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import htdh.model.warehousemanagement.*;

public class ListOfOrderToWarehouseManagementController implements Initializable {
    @FXML
    private TableView<ListOfOrderToWarehouseManagementModel> table;

    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, String> siteCodeColumn;

    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, String> merchandiseCodeColumn;

    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, String> saleCodeColumn;

    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, Integer> quanlityOrderColumn;
    
    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, Integer> quanlityActualColumn;
    
    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, String> unitColumn;
    
    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, String> arrivalDateColumn;
    
    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, String> noteColumn;
    
    @FXML
    private TableColumn<ListOfOrderToWarehouseManagementModel, String> statusColumn;

    private ObservableList<ListOfOrderToWarehouseManagementModel> orderList;
    
    @FXML
    private ChoiceBox<String> searchTypeChoiceBox;
    
    @FXML
    private TextField searchTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderList = FXCollections.observableArrayList(
            new ListOfOrderToWarehouseManagementModel("SITE01", "MER01", "SALE01", 250, 0, "Cái", "2024-05-30", null, "unchecked"),
            new ListOfOrderToWarehouseManagementModel("SITE01", "MER02", "SALE03", 150, 0, "Bộ", "2024-06-01", null, "unchecked"),
            new ListOfOrderToWarehouseManagementModel("SITE02", "MER01", "SALE01", 200, 0, "Cái", "2024-05-30", null, "unchecked")
        );

        siteCodeColumn.setCellValueFactory(new PropertyValueFactory<>("siteCode"));
        merchandiseCodeColumn.setCellValueFactory(new PropertyValueFactory<>("merchandiseCode"));
        saleCodeColumn.setCellValueFactory(new PropertyValueFactory<>("saleCode"));
        quanlityOrderColumn.setCellValueFactory(new PropertyValueFactory<>("quanlityOrder"));
        quanlityActualColumn.setCellValueFactory(new PropertyValueFactory<>("quanlityActual"));
        unitColumn.setCellValueFactory(new PropertyValueFactory<>("unit"));
        arrivalDateColumn.setCellValueFactory(new PropertyValueFactory<>("arrivalDate"));
        noteColumn.setCellValueFactory(new PropertyValueFactory<>("note"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        table.setItems(orderList);
        
        searchTypeChoiceBox.getItems().addAll("Merchandise Code", "Site Code", "Sale Code");

        // Đặt mục mặc định được chọn
        searchTypeChoiceBox.setValue("Merchandise Code");
    }

    // Hàm này được gọi từ popup để cập nhật sinh viên trong bảng
    public void updateListOfOrderInTable(ListOfOrderToWarehouseManagementModel updateList) {
        // Tìm chỉ mục của sinh viên đã cập nhật trong danh sách
        int index = -1;
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getSiteCode().equals(updateList.getSiteCode())) {
                index = i;
                break;
            }
        }

        // Thay thế sinh viên cũ bằng sinh viên đã cập nhật
        if (index != -1) {
            orderList.set(index, updateList);
        }
    }
    // Hàm này được gọi khi nhấn nút để hiển thị popup
 // Hàm này được gọi khi nhấn nút để hiển thị popup
	public void update(ActionEvent e) throws IOException {
        ListOfOrderToWarehouseManagementModel selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            System.out.println("No merchandise selected");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dhqt/warehousemanagement/PopUpOfAMerchandiseView.fxml"));
        Parent aMerchandiseViewParent = loader.load();

        Scene scene = new Scene(aMerchandiseViewParent);

        // Đảm bảo rằng bạn đang lấy đúng controller
        PopUpOfAMerchandiseController controller = loader.getController();
        controller.setAMerchandise(selected);
        controller.setLists(orderList, table.getItems()); // Truyền danh sách order ban đầu và danh sách kết quả tìm kiếm

        Stage popupStage = new Stage();
        popupStage.setScene(scene);
        popupStage.setTitle("Update Merchandise");
        popupStage.initModality(Modality.WINDOW_MODAL);
        popupStage.initOwner(((Node) e.getSource()).getScene().getWindow());

        popupStage.showAndWait();
    }


	public void search(ActionEvent e) {
        String searchText = searchTextField.getText().toLowerCase().trim();
        String searchType = searchTypeChoiceBox.getValue();
        ObservableList<ListOfOrderToWarehouseManagementModel> searchResult = FXCollections.observableArrayList();
        if (searchTypeChoiceBox.getValue() != null && !searchText.isEmpty()) {
            if (searchType.equals("Merchandise Code")) {
                for (ListOfOrderToWarehouseManagementModel aMerchandise : orderList) {
                    if (aMerchandise.getMerchandiseCode().toLowerCase().contains(searchText)) {
                        searchResult.add(aMerchandise);
                    }
                }
            } else if (searchType.equals("Site Code")) {
                for (ListOfOrderToWarehouseManagementModel aMerchandise : orderList) {
                    if (aMerchandise.getSiteCode().toLowerCase().contains(searchText)) {
                        searchResult.add(aMerchandise);
                    }
                }
            } else if (searchType.equals("Sale Code")) {
                for (ListOfOrderToWarehouseManagementModel aMerchandise : orderList) {
                	if (aMerchandise.getSaleCode().toLowerCase().contains(searchText)) {
                        searchResult.add(aMerchandise);
                    }
                }
            }
            table.setItems(searchResult);
        } else {
            table.setItems(orderList);
        }
    }


}
