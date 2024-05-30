package htdh.model.common.entity;

import java.util.Date;

public class CanceledOrder {
    private String OrderID;
    private Date rejectDate;
    public CanceledOrder(String orderId, Date rejectDate) {
        this.OrderID = orderId;
        this.rejectDate = rejectDate;
    }
    public String getRejectOrderID() {
        return OrderID;
    }
}
