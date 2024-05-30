package htdh.test.dhqt.sales;

import htdh.model.actor.sales.Product;
import htdh.subsystem.salesSubsystem.CreateProductSubsystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateProductSubsystemTest {

    private CreateProductSubsystem createProductSubsystem;

    @BeforeEach
    public void setUp() {
        createProductSubsystem = new CreateProductSubsystem();
    }

    @Test
    public void testCreateValidProduct() {
        Product product = new Product("1", "Test Product", 10, "pcs");
        assertTrue(createProductSubsystem.createProduct(product));
    }

    @Test
    public void testCreateEmptyProductID() {
        Product product = new Product("", "Test Product", 10, "pcs");
        assertThrows(RuntimeException.class, () -> createProductSubsystem.createProduct(product));
    }

    @Test
    public void testCreateEmptyProductName() {
        Product product = new Product("3", "", 10, "pcs");
        assertThrows(RuntimeException.class, () -> createProductSubsystem.createProduct(product));
    }

    @Test
    public void testCreateEmptyUnit() {
        Product product = new Product("4", "Test Product", 10, "");
        assertThrows(RuntimeException.class, () -> createProductSubsystem.createProduct(product));
    }

    @Test
    public void testCreateNegativeQuantity() {
        Product product = new Product("5", "Test Product", -1, "pcs");
        assertThrows(RuntimeException.class, () -> createProductSubsystem.createProduct(product));
    }

    @Test
    public void testCreate0Quantity() {
        Product product = new Product("6", "Test Product", 0, "pcs");
        assertTrue(createProductSubsystem.createProduct(product));
    }

    @Test
    public void testCreatePositiveQuantity() {
        Product product = new Product("7", "Test Product", 1, "pcs");
        assertTrue(createProductSubsystem.createProduct(product));
    }

//    @Test
//    public void testCreateNonIntQuantity() {
//        Product product = new Product("8", "Test Product", 1.5, "pcs");
//        assertThrows(RuntimeException.class, () -> createProductSubsystem.createProduct(product));
//    }

    @Test
    public void testCreateDuplicateProductID() {
        Product product1 = new Product("9", "Test Product 1", 10, "pcs");
        Product product2 = new Product("9", "Test Product 2", 5, "pcs");
        createProductSubsystem.createProduct(product1);
        assertThrows(RuntimeException.class, () -> createProductSubsystem.createProduct(product2));
    }

//    @Test
//    public void testCreateEmpty() {
//        Product product = new Product("", "", null, "");
//        assertThrows(RuntimeException.class, () -> createProductSubsystem.createProduct(product));
//    }

}
