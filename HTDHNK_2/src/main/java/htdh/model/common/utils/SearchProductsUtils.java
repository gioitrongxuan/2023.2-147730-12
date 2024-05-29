package htdh.model.common.utils;

import htdh.model.common.entity.Product;

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
//

        // Tạo dữ liệu mẫu
        products.add(new Product("P0011", "ABC123", "kg",10));
        products.add(new Product("P0012", "ABC123", "kg",10));
        products.add(new Product("P0021", "DEF456", "l", 20));
        products.add(new Product("P0022", "DEF456", "ml", 20));
        products.add(new Product("P0031", "GHI789", "m", 30));
        products.add(new Product("P0032", "GHI789", "cm", 30));

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