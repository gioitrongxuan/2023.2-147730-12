package model.bpdhqt.orderoperation.merchandisemodel;

import java.util.ArrayList;
import model.sitemodel.Site;

public class Merchandise {
	//
	//
	//
	private String name;
	private ArrayList<Site> sites = new ArrayList<Site>();
	private String merchandiseCode;
	private String unit;
	private int quantityOrdered;
	private String deliveryMean;
	//
	//
	//
	public String getName() {
		return name;
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
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public String getDeliveryMean() {
		return deliveryMean;
	}
	public void setDeliveryMean(String deliveryMean) {
		this.deliveryMean = deliveryMean;
	}
	//
	//
	//
	public Merchandise(String name, ArrayList<Site> sites, String merchandiseCode, String unit, int quantityOrdered,
			String deliveryMean) {
		super();
		this.name = name;
		this.sites = sites;
		this.merchandiseCode = merchandiseCode;
		this.unit = unit;
		this.quantityOrdered = quantityOrdered;
		this.deliveryMean = deliveryMean;
	}
	public Merchandise() {
		super();
	}
	
}
