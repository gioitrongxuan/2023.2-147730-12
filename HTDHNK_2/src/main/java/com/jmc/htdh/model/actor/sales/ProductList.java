package com.jmc.htdh.model.actor.sales;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductList {
	private ObservableList<Product> items = FXCollections.observableArrayList();
	
	public void addProduct(Product product) {
        items.add(product);
	}
	
    public ObservableList<Product> getItems() {
    	return items;
    }
}
