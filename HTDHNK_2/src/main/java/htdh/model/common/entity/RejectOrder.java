package htdh.model.common.entity;

import java.util.Date;

public class RejectOrder {
    private String OrderID;
    private Date rejectDate;
    public RejectOrder(String orderId, Date rejectDate) {
        this.OrderID = orderId;
        this.rejectDate = rejectDate;
    }
    public String getRejectOrderID() {
        return OrderID;
    }
}
