package com.jmc.htdh.model.common.utils;

import com.jmc.htdh.model.common.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchProductsUtils {
    private SearchProductsUtils() {} // Constructor private để ngăn tạo instance

    public static Product searchProducts(String connectionString, String searchTerm) {
        List<Product> products = new ArrayList<>();

//        try (Connection connection = DriverManager.getConnection(connectionString);
//             PreparedStatement statement = connection.prepareStatement(
//                     "SELECT * FROM Products WHERE ProductCode = ? OR Name LIKE ? OR Description LIKE ?")) {
//
//            statement.setString(1, searchTerm);
//            statement.setString(2, "%" + searchTerm + "%");
//            statement.setString(3, "%" + searchTerm + "%");
//
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    Product product = new Product(
//                            resultSet.getString("Id"),
//                            resultSet.getString("ProductCode"),
//                            (ArrayList<String>) resultSet.getArray("Unit"),
//                            resultSet.getInt("Quantity")
//                    );
//                    products.add(product);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // Tạo dữ liệu mẫu
        products.add(new Product("1", "ABC123", new ArrayList<>(List.of("kg", "g")), 10));
        products.add(new Product("2", "DEF456", new ArrayList<>(List.of("l", "ml")), 20));
        products.add(new Product("3", "GHI789", new ArrayList<>(List.of("m", "cm")), 30));

        // Tìm kiếm ProductCode trùng hoàn toàn với searchTerm
        Product matchedProducts = new Product();
        for (Product product : products) {
            if (product.getProductCode().equals(searchTerm)) {
                return product;
            }
        }

//        return;
        return matchedProducts;
    }
}