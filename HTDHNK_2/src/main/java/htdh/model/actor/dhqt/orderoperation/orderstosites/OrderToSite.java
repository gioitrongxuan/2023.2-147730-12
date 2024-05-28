package htdh.model.actor.dhqt.orderoperation.orderstosites;

import java.util.ArrayList;

import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;

public class OrderToSite {
	
	//
	//
	//
	
	private String orderToSiteID;
	private String fromWhatSale;
	private String siteID;
	private String siteName;
	private String deliveryMean;
	private String orderSentDate;
	private ArrayList<String> desiredDeliveryDate = new ArrayList<String>();
	
	private ArrayList<Merchandise> merchandisesNeedToOrder = new ArrayList<Merchandise>();
	private ArrayList<Integer> amountOfMerchandisesNeedToOrder = new ArrayList<Integer>();
	
	private String status;

	//
	//
	//
	
	public String getFromWhatSale() {
		return fromWhatSale;
	}

	public String getOrderToSiteID() {
		return orderToSiteID;
	}

	public void setOrderToSiteID(String orderToSiteID) {
		this.orderToSiteID = orderToSiteID;
	}

	public void setFromWhatSale(String fromWhatSale) {
		this.fromWhatSale = fromWhatSale;
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

	public ArrayList<String> getDesiredDeliveryDate() {
		return desiredDeliveryDate;
	}

	public void setDesiredDeliveryDate(ArrayList<String> desiredDeliveryDate) {
		this.desiredDeliveryDate = desiredDeliveryDate;
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
	
//	public OrderToSite(String fromWhatSale, String siteID, String siteName, String deliveryMean, String orderSentDate,
//			ArrayList<String> desiredDeliveryDate, ArrayList<Merchandise> merchandisesNeedToOrder,
//			ArrayList<Integer> amountOfMerchandisesNeedToOrder, String status) {
//		super();
//		this.fromWhatSale = fromWhatSale;
//		this.siteID = siteID;
//		this.siteName = siteName;
//		this.deliveryMean = deliveryMean;
//		this.orderSentDate = orderSentDate;
//		this.desiredDeliveryDate = desiredDeliveryDate;
//		this.merchandisesNeedToOrder = merchandisesNeedToOrder;
//		this.amountOfMerchandisesNeedToOrder = amountOfMerchandisesNeedToOrder;
//		this.status = status;
//	}

	public OrderToSite(String fromWhatSale, String siteID, String deliveryMean, ArrayList<String> desiredDeliveryDate,
			ArrayList<Merchandise> merchandisesNeedToOrder, ArrayList<Integer> amountOfMerchandisesNeedToOrder,
			String status) {
		super();
		this.fromWhatSale = fromWhatSale;
		this.siteID = siteID;
		this.deliveryMean = deliveryMean;
		this.desiredDeliveryDate = desiredDeliveryDate;
		this.merchandisesNeedToOrder = merchandisesNeedToOrder;
		this.amountOfMerchandisesNeedToOrder = amountOfMerchandisesNeedToOrder;
		this.status = status;
	}

	
	public OrderToSite(String orderToSiteID, String siteID, String siteName, String deliveryMean, String orderSentDate,
			ArrayList<String> desiredDeliveryDate, ArrayList<Merchandise> merchandisesNeedToOrder,
			ArrayList<Integer> amountOfMerchandisesNeedToOrder, String status) {
		super();
		this.orderToSiteID = orderToSiteID;
		this.siteID = siteID;
		this.siteName = siteName;
		this.deliveryMean = deliveryMean;
		this.orderSentDate = orderSentDate;
		this.desiredDeliveryDate = desiredDeliveryDate;
		this.merchandisesNeedToOrder = merchandisesNeedToOrder;
		this.amountOfMerchandisesNeedToOrder = amountOfMerchandisesNeedToOrder;
		this.status = status;
	}

	public OrderToSite() {
		super();
	}
	
	//
	//
	//
	
	
}
