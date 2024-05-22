package com.jmc.htdh.controller.actor.sales;

import com.jmc.htdh.model.actor.sales.ProductList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import com.jmc.htdh.model.actor.sales.Product;

public class CreateProductController {
	private ProductList productList = new ProductList();

    @FXML
    private Button btnCreate;

    @FXML
    private TableColumn<Product, String> colId;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, Integer> colQuantity;

    @FXML
    private TableColumn<Product, String> colUnit;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TableView<Product> tbl;

    @FXML
    private TextField tfFilter;

    @FXML
    public void initialize() {
    	colId.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
    	colName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
    	colQuantity.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
    	colUnit.setCellValueFactory(new PropertyValueFactory<Product, String>("unit"));
    	if(productList.getItems() != null)
    		tbl.setItems(productList.getItems());

    }

    @FXML
    void btnCreatePressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sales/CreateProductPopup.fxml"));
            Parent root = loader.load();

            CreateProductPopupController popupController = loader.getController();
            popupController.setParentController(this); // Pass a reference to this controller

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Tạo mặt hàng mới");
            popupStage.setScene(new Scene(root));

            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to add a new product to the table
    public void addProduct(Product product) {
        productList.addProduct(product); // Thêm sản phẩm vào danh sách
        tbl.setItems(productList.getItems()); // Thêm sản phẩm vào bảng
    }
}
