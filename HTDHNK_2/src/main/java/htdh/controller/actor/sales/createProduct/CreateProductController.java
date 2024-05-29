package htdh.controller.actor.sales.createProduct;

import htdh.model.actor.sales.Product;
import htdh.subsystem.salesSubsystem.CreateProductSubsystem;
import htdh.subsystem.salesSubsystem.GetProductsSubsystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CreateProductController {
    private ObservableList<Product> productList = FXCollections.observableArrayList();
    private GetProductsSubsystem getProductsSubsystem = new GetProductsSubsystem();
    private CreateProductSubsystem createProductSubsystem = new CreateProductSubsystem();

    public ObservableList<Product> getProductList() {
        return productList;
    }

    public void getAllProducts() {
        List<Product> products = getProductsSubsystem.getAllProducts();
        productList.setAll(products);
    }

    public boolean createProduct(String id, String name, int quantity, String unit) {
        Product newProduct = new Product(id, name, quantity, unit);
        boolean isCreated = createProductSubsystem.createProduct(newProduct);
        if (isCreated) {
            productList.add(newProduct);
        }
        return isCreated;
    }
}
