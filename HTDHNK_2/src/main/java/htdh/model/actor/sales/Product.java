// bpbh.CreateProduct.model/Product.java
package htdh.model.actor.sales;

public class Product {
    private String productID;
    private String productName;
    private int quantity;
    private String unit;

    // Constructor
    public Product(String id, String name, int quantity, String unit) {
        this.productID = id;
        this.productName = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters
    public String getId() {
        return productID;
    }

    public String getName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    // Setters
    public void setId(String id) {
        this.productID = id;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public boolean isMatch(String keyword) {
        return this.getName().toLowerCase().contains(keyword.toLowerCase());
    }
}
