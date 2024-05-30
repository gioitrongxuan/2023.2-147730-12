package htdh.subsystem.salesSubsystem;



import htdh.model.actor.sales.Product;
import htdh.subsystem.connectionManagementSubsystem.SQLServerConnector2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetProductsSubsystem {

    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM Products";

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = SQLServerConnector2.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_PRODUCTS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String productID = resultSet.getString("productID");
                String productName = resultSet.getString("productName");
                int quantity = resultSet.getInt("quantity");
                String unit = resultSet.getString("unit");

                Product product = new Product(productID, productName, quantity, unit);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
