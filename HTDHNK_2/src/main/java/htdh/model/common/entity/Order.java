package htdh.model.common.entity;

import java.util.ArrayList;

public class Order {

    private String orderID;
    private String orderDate;
    private String orderStatus;
    private ArrayList<String> merchandiseId = new ArrayList<String>();
    private String deliveryMean;

    public Order(ArrayList<String> merchandiseId , String orderID) {
        this.merchandiseId = merchandiseId;
        this.orderID = orderID;
    }

}
