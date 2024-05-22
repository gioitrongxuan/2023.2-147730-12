package com.jmc.htdh.common.utils.searchTools;

import java.util.ArrayList;
import java.util.List;
import com.jmc.htdh.common.entity.Product;

public class SearchProducts {
    private SearchProducts() {} // Constructor private để ngăn tạo instance

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
        products.add(new Product("Name1", "001", new ArrayList<>(List.of("kg", "g")), 10));
        products.add(new Product("Name2", "002", new ArrayList<>(List.of("l", "ml")), 20));
        products.add(new Product("Name3", "003", new ArrayList<>(List.of("m", "cm")), 30));

        // Tìm kiếm ProductCode trùng hoàn toàn với searchTerm
        Product matchedProducts = new Product();
        for (Product product : products) {
            if (product.getProductCode().equals(searchTerm)) {
                return product;
            }
        }
        return matchedProducts;
    }
}