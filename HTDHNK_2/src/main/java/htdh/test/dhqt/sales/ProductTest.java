package htdh.test.dhqt.sales;

import htdh.model.actor.sales.Product;
import htdh.subsystem.salesSubsystem.CreateProductSubsystem;
import htdh.subsystem.salesSubsystem.GetProductsSubsystem;

import java.util.List;

public class ProductTest {

    public static void main(String[] args) {
        GetProductsSubsystem getProductsSubsystem = new GetProductsSubsystem();
        List<Product> products = getProductsSubsystem.getAllProducts();
        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() +
                    ", Quantity: " + product.getQuantity() + ", Unit: " + product.getUnit());
        }

        CreateProductSubsystem createProductSubsystem = new CreateProductSubsystem();
        Product newProduct = new Product("P216", "New Product", 100, "piece");
        boolean isCreated = createProductSubsystem.createProduct(newProduct);

        if (isCreated) {
            System.out.println("New product created successfully.");
        } else {
            System.out.println("Failed to create new product.");
        }

        products = getProductsSubsystem.getAllProducts();
        System.out.println("All Products After Adding New Product:");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() +
                    ", Quantity: " + product.getQuantity() + ", Unit: " + product.getUnit());
        }
    }
}
