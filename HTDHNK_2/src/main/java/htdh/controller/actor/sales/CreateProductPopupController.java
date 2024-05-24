package htdh.controller.actor.sales;

import htdh.model.actor.sales.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateProductPopupController {

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

    private CreateProductController parentController; // Reference to the main controller

    public void setParentController(CreateProductController controller) {
        this.parentController = controller;
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

        // Check if any of the fields are empty
        if (id.isEmpty() || name.isEmpty() || quantityText.isEmpty() || unit.isEmpty()) {
            // Show an error message if any field is empty
            showErrorMessage("All fields are required.");
            return;
        }
        
        int quantity;
        try {
            // Parse the quantity string to an integer
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            // Show an error message if quantity is not a valid integer
            showErrorMessage("Quantity must be a valid integer.");
            return;
        }
        
        if (quantity < 0) {
            // Show an error message if quantity is negative
            showErrorMessage("Quantity must be a non-negative integer.");
            return;
        }

        // Create a new Product object
        Product newProduct = new Product(id, name, quantity, unit);

        // Add the new product to the table using the main controller's method
        parentController.addProduct(newProduct);

        // Close the popup window
        Stage stage = (Stage) btnCreate.getScene().getWindow();
        stage.close();
    }
    
    private void showErrorMessage(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

