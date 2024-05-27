package htdh.model.actor.dhqt.orderoperation.merchandisemodel;

import java.util.ArrayList;
import htdh.model.actor.sitemodel.Site;

public class Merchandise {
	//
	//
	//
	private String merchandiseCode;
	private String name;
	
	private ArrayList<Site> sites = new ArrayList<Site>();
	private ArrayList<Integer> quantityOrdered = new ArrayList<Integer>();
	
	private String unit;
	
	private ArrayList<String> deliveryMean = new ArrayList<String>();
	
	private String orderOfSale;
	private int needOrderedQuantity;
	private String orderSentDate;
	private ArrayList<String> desiredDeliveryDate = new ArrayList<String>();
	//
	//
	//
	
	public String getName() {
		return name;
	}
	public int getNeedOrderedQuantity() {
		return needOrderedQuantity;
	}
	public void setNeedOrderedQuantity(int needOrderedQuantity) {
		this.needOrderedQuantity = needOrderedQuantity;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Site> getSites() {
		return sites;
	}
	public void setSites(ArrayList<Site> sites) {
		this.sites = sites;
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
	public ArrayList<Integer> getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(ArrayList<Integer> quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public ArrayList<String> getDeliveryMean() {
		return deliveryMean;
	}
	public void setDeliveryMean(ArrayList<String> deliveryMean) {
		this.deliveryMean = deliveryMean;
	}
	public String getBoPhanDatHangQuocTe() {
		return orderOfSale;
	}
	public void setBoPhanDatHangQuocTe(String boPhanDatHangQuocTe) {
		this.orderOfSale = boPhanDatHangQuocTe;
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
	//
	//
	//
	public Merchandise(String name, ArrayList<Site> sites, String merchandiseCode, String unit, ArrayList<Integer> quantityOrdered,
			 ArrayList<String> deliveryMean, String orderOfSale, int needOrderedQuantity,
			String orderSentDate, ArrayList<String> desiredDeliveryDate) {
		super();
		this.merchandiseCode = merchandiseCode;
		this.name = name;
		this.sites = sites;
		this.quantityOrdered = quantityOrdered;
		this.unit = unit;
		this.deliveryMean = deliveryMean;
		this.orderOfSale = orderOfSale;
		this.needOrderedQuantity = needOrderedQuantity;
		this.orderSentDate = orderSentDate;
		this.desiredDeliveryDate = desiredDeliveryDate;
	}
	public Merchandise() {
		super();
	}
	//
	//
	//	
}
