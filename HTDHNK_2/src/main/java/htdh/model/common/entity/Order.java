package htdh.model.common.entity;



import java.util.ArrayList;
import java.util.List;

import htdh.model.common.entity.Merchandise;
import javafx.collections.FXCollections;

public class Order {

    //
    //
    //
    private String orderID;
    private String listfromsiteID;
    private String siteID;
    private String siteName;
    private String deliveryMean;
    private String orderSentDate;

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    private String deliverydate;
    public String getDesiredDeliveryDate() {
        return desiredDeliveryDate;
    }

    public void setDesiredDeliveryDate(String desiredDeliveryDate) {
        this.desiredDeliveryDate = desiredDeliveryDate;
    }

    private String desiredDeliveryDate;
    private List<Order_Merchandise> orderMerchandiseList = FXCollections.observableArrayList();

    private ArrayList<Merchandise> merchandisesNeedToOrder = new ArrayList<Merchandise>();
    private ArrayList<Integer> amountOfMerchandisesNeedToOrder = new ArrayList<Integer>();

    private String status;

    //
    //
    //


    public String getListfromsiteID() {
        return listfromsiteID;
    }

    public void setListfromsiteID(String listfromsiteID) {
        this.listfromsiteID = listfromsiteID;
    }

    public String getSiteID() {
        return siteID;
    }

    public void setSiteID(String siteID) {
        this.siteID = siteID;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDeliveryMean() {
        return deliveryMean;
    }

    public void setDeliveryMean(String deliveryMean) {
        this.deliveryMean = deliveryMean;
    }

    public String getOrderSentDate() {
        return orderSentDate;
    }

    public void setOrderSentDate(String orderSentDate) {
        this.orderSentDate = orderSentDate;
    }


  

    public ArrayList<Merchandise> getMerchandisesNeedToOrder() {
        return merchandisesNeedToOrder;
    }

    public void setMerchandisesNeedToOrder(ArrayList<Merchandise> merchandisesNeedToOrder) {
        this.merchandisesNeedToOrder = merchandisesNeedToOrder;
    }

    public ArrayList<Integer> getAmountOfMerchandisesNeedToOrder() {
        return amountOfMerchandisesNeedToOrder;
    }

    public void setAmountOfMerchandisesNeedToOrder(ArrayList<Integer> amountOfMerchandisesNeedToOrder) {
        this.amountOfMerchandisesNeedToOrder = amountOfMerchandisesNeedToOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    //
    //
    //

    public Order(String fromWhatSale, String siteID, String siteName, String deliveryMean, String orderSentDate,
                       String desiredDeliveryDate, ArrayList<Merchandise> merchandisesNeedToOrder,
                       ArrayList<Integer> amountOfMerchandisesNeedToOrder, String status) {
        super();
        this.listfromsiteID = fromWhatSale;
        this.siteID = siteID;
        this.siteName = siteName;
        this.deliveryMean = deliveryMean;
        this.orderSentDate = orderSentDate;
        this.desiredDeliveryDate = desiredDeliveryDate;
        this.merchandisesNeedToOrder = merchandisesNeedToOrder;
        this.amountOfMerchandisesNeedToOrder = amountOfMerchandisesNeedToOrder;
        this.status = status;
    }

    public Order(String fromWhatSale, String siteID, String deliveryMean, String desiredDeliveryDate,
                       ArrayList<Merchandise> merchandisesNeedToOrder, ArrayList<Integer> amountOfMerchandisesNeedToOrder,
                       String status) {
        super();
        this.listfromsiteID = fromWhatSale;
        this.siteID = siteID;
        this.deliveryMean = deliveryMean;
        this.desiredDeliveryDate = desiredDeliveryDate;
        this.merchandisesNeedToOrder = merchandisesNeedToOrder;
        this.amountOfMerchandisesNeedToOrder = amountOfMerchandisesNeedToOrder;
        this.status = status;
    }

    public Order() {
        super();
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public List<Order_Merchandise> getOrderMerchandiseList() {
        return orderMerchandiseList;
    }

    public void setOrderMerchandiseList(List<Order_Merchandise> orderMerchandiseList) {
        this.orderMerchandiseList = orderMerchandiseList;
    }
//
    //
    //


}

