package htdh.controller.actor.sales.createProduct;

import htdh.model.actor.sales.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateProductPopupViewController {

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnCreate;

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField unitField;

    private CreateProductController productController;

    public void setProductController(CreateProductController productController) {
        this.productController = productController;
    }

    @FXML
    void btnCancelPressed(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnCreatePressed(ActionEvent event) {
        String id = idField.getText();
        String name = nameField.getText();
        String quantityText = quantityField.getText();
        String unit = unitField.getText();

        if (id.isEmpty() || name.isEmpty() || quantityText.isEmpty() || unit.isEmpty()) {
            showErrorMessage("All fields are required.");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            showErrorMessage("Quantity must be a valid integer.");
            return;
        }

        if (quantity < 0) {
            showErrorMessage("Quantity must be a non-negative integer.");
            return;
        }

        boolean isCreated = productController.createProduct(id, name, quantity, unit);

        if (isCreated) {
            Stage stage = (Stage) btnCreate.getScene().getWindow();
            stage.close();
        } else {
            showErrorMessage("Failed to create new product.");
        }
    }

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
