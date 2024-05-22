package com.jmc.htdh.controller.bpdhqt;

import com.jmc.htdh.model.actor.dhqt.Order;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderListCellController implements Initializable{
    private final Order order;
    public OrderListCellController(Order order) {
        this.order = order;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
