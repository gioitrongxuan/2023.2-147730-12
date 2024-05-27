package htdh.model.actor.dhqt.orderoperation.listmodel;

import java.util.ArrayList;

import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;

public class ListOfMerchandise {
	private String listOfListID;
	private String name;
	private String ID;
	private ArrayList<Merchandise> merchandises = new ArrayList<Merchandise>();
	private String orderSentDate;

	public ListOfMerchandise(String mi2001, ArrayList<Merchandise> merchandises) {
		// TODO Auto-generated constructor stub
	}

	//
	//
	//
	
	public String getListOfListID() {
		return listOfListID;
	}
	public String getOrderSentDate() {
		return orderSentDate;
	}

	public void setOrderSentDate(String orderSentDate) {
		this.orderSentDate = orderSentDate;
	}

	public void setListOfListID(String listOfListID) {
		this.listOfListID = listOfListID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public ArrayList<Merchandise> getMerchandises() {
		return merchandises;
	}
	public void setMerchandises(ArrayList<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}
	//
	//
	//
	public ListOfMerchandise(String listOfListID, String iD, String orderSentDate, ArrayList<Merchandise> merchandises) {
		super();
		this.orderSentDate = orderSentDate;
		this.listOfListID = listOfListID;
		this.ID = iD;
		this.merchandises = merchandises;
	}
	public ListOfMerchandise(String listOfListID, String iD, ArrayList<Merchandise> merchandises) {
		super();
		this.listOfListID = listOfListID;
		this.ID = iD;
		this.merchandises = merchandises;
	}
	public ListOfMerchandise() {
		super();
	}
	
	
	
}
