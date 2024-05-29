package htdh.controller.actor.sales.createProduct;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import htdh.model.actor.sales.Product;

public class CreateProductViewController {
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

    private final CreateProductController productController = new CreateProductController();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));

        productController.getAllProducts();
        tbl.setItems(productController.getProductList());
    }

    @FXML
    public void logout(ActionEvent event) {

    }

    @FXML
    void btnCreatePressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/sales/create/product/CreateProductPopup.fxml"));
            Parent root = loader.load();

            CreateProductPopupViewController popupController = loader.getController();
            popupController.setProductController(productController); // Pass the shared controller

            Stage popupStage = new Stage();
            popupStage.initModality(Modality.APPLICATION_MODAL);
            popupStage.setTitle("Tạo mặt hàng mới");
            popupStage.setScene(new Scene(root));

            // After the popup closes, refresh the table
            popupStage.setOnHidden(e -> {
                tbl.refresh();
            });

            popupStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void chuyen(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/sales/create/search/MerchandiseSearch.fxml"));
            // Already setup controller in fxml file

            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
