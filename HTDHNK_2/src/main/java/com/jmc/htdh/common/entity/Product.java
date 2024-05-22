package com.jmc.htdh.common.entity;

import java.util.ArrayList;

public class Product {
    //
    //
    //
    private String name;
    private String productCode;
    private ArrayList<String> unit;
    private int quantity;
    //
    //
    //
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public ArrayList<String> getUnit() {
        return unit;
    }
    public void setUnit(ArrayList<String> unit) {
        this.unit = unit;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //
    //
    //
    public Product(String name, String productCode, ArrayList<String> unit, int quantity) {
        super();
        this.name = name;
        this.productCode = productCode;
        this.unit = unit;
        this.quantity = quantity;
    }
    public Product() {
        super();
    }

}

