package htdh.model.common.entity;

public class Order_Merchandise {
    //
    //
    //
    private String name;
    private String orderId;
    private String merchandiseCode;
    private String unit;
    private int quantityOrdered;
    private String deliverydate;
    //
    //
    //
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getMerchandiseCode() {
        return merchandiseCode;
    }
    public void setMerchandiseCode(String merchandiseCode) {
        this.merchandiseCode = merchandiseCode;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public int getQuantityOrdered() {
        return quantityOrdered;
    }
    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }
    public String getDeliveryDate() {
        return deliverydate;
    }
    public void setDeliveryDate(String deliveryMean) {
        this.deliverydate = deliveryMean;
    }
    //
    //

    public Order_Merchandise(String name, String orderId, String merchandiseCode, String unit, int quantityOrdered,
                       String deliverydate) {
        super();
        this.name = name;
        this.orderId = orderId;
        this.merchandiseCode = merchandiseCode;
        this.unit = unit;
        this.quantityOrdered = quantityOrdered;
        this.deliverydate = deliverydate;
    }
    public Order_Merchandise() {
        super();
    }

}
