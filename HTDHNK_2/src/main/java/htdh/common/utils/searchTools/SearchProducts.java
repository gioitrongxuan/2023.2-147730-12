package htdh.common.utils.searchTools;

import java.util.ArrayList;
import java.util.List;
import htdh.common.entity.Product;
import htdh.model.actor.sales.ViewModel;

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
        products.add(new Product("Quan wibu", "P001", new ArrayList<>(List.of("White", "Black", "Blue")), 10));
        products.add(new Product("Bim bim can", "P002", new ArrayList<>(List.of("500g", "200g")), 20));
        products.add(new Product("Da quy", "P003", new ArrayList<>(List.of("Topaz", "Jade", "Aventurine")), 30));

        // Tìm kiếm ProductCode trùng hoàn toàn với searchTerm
        Product matchedProducts = new Product();
        for (Product product : products) {
            if (product.getProductCode().equals(searchTerm)) {
                return product;
            }
        }

        return ViewModel.getInstance().searchProduct(searchTerm);
    }
}