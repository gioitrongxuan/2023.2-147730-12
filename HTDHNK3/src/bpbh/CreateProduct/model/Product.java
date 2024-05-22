// bpbh.CreateProduct.model/Product.java
package bpbh.CreateProduct.model;

public class Product {
    private String id;
    private String name;
    private int quantity;
    private String unit;

    // Constructor
    public Product(String id, String name, int quantity, String unit) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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
