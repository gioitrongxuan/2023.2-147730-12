package model.bpdhqt.orderoperation.listofmerchandisemodel;

import java.util.ArrayList;

import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;

public class ListOfMerchandise {
	private String listOfListID;
	private String name;
	private String ID;
	private ArrayList<Merchandise> merchandises = new ArrayList<Merchandise>();
	//
	//
	//
	public String getListOfListID() {
		return listOfListID;
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
	public ListOfMerchandise(String listOfListID, String name, String iD, ArrayList<Merchandise> merchandises) {
		super();
		this.listOfListID = listOfListID;
		this.name = name;
		ID = iD;
		this.merchandises = merchandises;
	}
	public ListOfMerchandise(String listOfListID, String iD, ArrayList<Merchandise> merchandises) {
		super();
		this.listOfListID = listOfListID;
		ID = iD;
		this.merchandises = merchandises;
	}
	public ListOfMerchandise() {
		super();
	}
	
	
	
}
