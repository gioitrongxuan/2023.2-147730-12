package model.bpdhqt.orderoperation.listofmerchandisemodel;

import java.util.ArrayList;

import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;

public class ListOfMerchandise {
	private String listOfListID;
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
	public ArrayList<Merchandise> getMerchandises() {
		return merchandises;
	}
	public void setMerchandises(ArrayList<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}
	//
	//
	//
	public ListOfMerchandise(String listOfListID, ArrayList<Merchandise> merchandises) {
		super();
		this.listOfListID = listOfListID;
		this.merchandises = merchandises;
	}
	public ListOfMerchandise() {
		super();
	}
	
}
