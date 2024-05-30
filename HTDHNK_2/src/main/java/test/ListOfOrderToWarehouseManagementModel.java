package test;

public class ListOfOrderToWarehouseManagementModel {
	private String siteCode;
	private String merchandiseCode;
	private String saleCode;
	private int quanlityOrder;
	private int quanlityActual;
	private String unit;
	private String arrivalDate;
	private String note;
	private String status;
	public ListOfOrderToWarehouseManagementModel(String siteCode, String merchandiseCode, String saleCode,
			int quanlityOrder, int quanlityActual, String unit, String arrivalDate, String note, String status) {
		super();
		this.siteCode = siteCode;
		this.merchandiseCode = merchandiseCode;
		this.saleCode = saleCode;
		this.quanlityOrder = quanlityOrder;
		this.quanlityActual = quanlityActual;
		this.unit = unit;
		this.arrivalDate = arrivalDate;
		this.note = note;
		this.status = status;
	}
	
	public ListOfOrderToWarehouseManagementModel() {
		
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getMerchandiseCode() {
		return merchandiseCode;
	}

	public void setMerchandiseCode(String merchandiseCode) {
		this.merchandiseCode = merchandiseCode;
	}

	public String getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}

	public int getQuanlityOrder() {
		return quanlityOrder;
	}

	public void setQuanlityOrder(int quanlityOrder) {
		this.quanlityOrder = quanlityOrder;
	}

	public int getQuanlityActual() {
		return quanlityActual;
	}

	public void setQuanlityActual(int quanlityActual) {
		this.quanlityActual = quanlityActual;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
