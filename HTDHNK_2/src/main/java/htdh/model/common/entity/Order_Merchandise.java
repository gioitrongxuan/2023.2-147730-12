package htdh.model.common.entity;

public class Order_Merchandise {
    private String merchandiseCode;
    private String name;
    private String site;
    private int quantity;
    private String unit;
    private String deliveryMean;
    private String orderOfSale;
    private int needOrderedQuantity;
    private String orderSentDate;
    private String desiredDeliveryDate;

    public Order_Merchandise(String merchandiseCode, String name, String site, int quantity, String unit, String deliveryMean, String orderOfSale, int needOrderedQuantity, String orderSentDate, String desiredDeliveryDate) {
        this.merchandiseCode = merchandiseCode;
        this.name = name;
        this.site = site;
        this.quantity = quantity;
        this.unit = unit;
        this.deliveryMean = deliveryMean;
        this.orderOfSale = orderOfSale;
        this.needOrderedQuantity = needOrderedQuantity;
        this.orderSentDate = orderSentDate;
        this.desiredDeliveryDate = desiredDeliveryDate;
    }

    public String getMerchandiseCode() {
        return merchandiseCode;
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

    public String getDesiredDeliveryDate() {
        return desiredDeliveryDate;
    }
}
