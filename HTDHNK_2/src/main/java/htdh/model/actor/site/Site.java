package htdh.model.actor.site;

import java.util.ArrayList;
import java.util.Date;

import htdh.model.common.entity.Product;

public class Site {
	//
	//
	//
	private String siteCode;
	private String siteName;
	private ArrayList<Product> productsInSite = new ArrayList<Product>();
	private int byAirTime;
	private int byShipTime;
	//
	//
	//
	
	public String getSiteCode() {
		return siteCode;
	}
	public int getByAirTime() {
		return byAirTime;
	}
	public void setByAirTime(int byAirTime) {
		this.byAirTime = byAirTime;
	}
	public int getByShipTime() {
		return byShipTime;
	}
	public void setByShipTime(int byShipTime) {
		this.byShipTime = byShipTime;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public ArrayList<Product> getProductsInSite() {
		return productsInSite;
	}
	public void setProductsInSite(ArrayList<Product> productsInSite) {
		this.productsInSite = productsInSite;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public ArrayList<Product> getMerchandisesInSite() {
		return productsInSite;
	}
	public void setMerchandisesInSite(ArrayList<Product> merchandisesInSite) {
		this.productsInSite = merchandisesInSite;
	}
	//
	//
	//
	public Site(String siteCode, String siteName, int byAirTime, int byShipTime) {
		super();
		this.siteName = siteName;
		this.siteCode = siteCode;
		this.byAirTime = byAirTime;
		this.byShipTime = byShipTime;
	}
	public Site(String siteCode, String siteName, ArrayList<Product> merchandisesInSite) {
		super();
		this.siteName = siteName;
		this.siteCode = siteCode;
		this.productsInSite = merchandisesInSite;
	}
	public Site(String siteCode, ArrayList<Product> merchandisesInSite) {
		super();
		this.siteCode = siteCode;
		this.productsInSite = merchandisesInSite;
	}
	public Site() {
		super();
	}
	public Site(String siteCode) {
		super();
		this.siteCode = siteCode;
	}
	//
	//
	//
	public int getMerchandiseQuantityByName(String merchandiseName) {
        for (Product merchandise : productsInSite) {
            if (merchandise.getName().equalsIgnoreCase(merchandiseName)) {
                return merchandise.getQuantity();
            }
        }
        return -1;
    }
	
	public int getMerchandiseQuantityByCode(String productCode) {
        for (Product merchandise : productsInSite) {
            if (merchandise.getProductCode().equalsIgnoreCase(productCode)) {
                return merchandise.getQuantity();
            }
        }
        return -1;
    }
}
