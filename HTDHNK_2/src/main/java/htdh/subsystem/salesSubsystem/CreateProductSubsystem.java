package htdh.subsystem.salesSubsystem;

import htdh.model.actor.sales.Product;
import htdh.subsystem.connectionManagementSubsystem.SQLServerConnector2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateProductSubsystem {
    private static final Logger logger = Logger.getLogger(CreateProductSubsystem.class.getName());
    private static final String INSERT_PRODUCT_QUERY = "INSERT INTO Products (productID, productName, quantity, unit) VALUES (?, ?, ?, ?)";

    public boolean createProduct(Product product) {
        // Validation
        if (!isValidProduct(product)) {
            logger.log(Level.SEVERE, "Invalid product data: {0}", product);
            throw new RuntimeException("Product data is invalid.");
        }

        try (Connection connection = SQLServerConnector2.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT_QUERY)) {

            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getUnit());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating product: {0}", e.getMessage());

            if (e.getMessage().contains("duplicate key")) {
                throw new RuntimeException("Product ID already exists.", e);
            } else {
                throw new RuntimeException("Failed to create product.", e);
            }
        }
    }

    private boolean isValidProduct(Product product) {
        if (product.getId() == null || product.getId().isEmpty()
                || product.getName() == null || product.getName().isEmpty()
                || product.getUnit() == null || product.getUnit().isEmpty()) {
            return false;
        }

        if (product.getQuantity() < 0) {
            return false;
        }

        return true;
    }
}
