package model.sitemodel;

import java.util.ArrayList;

import model.productmodel.Product;

public class Site {
	//
	//
	//
	private String siteCode;
	private ArrayList<Product> productsInSite = new ArrayList<Product>();
	//
	//
	//
	public String getSiteCode() {
		return siteCode;
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
