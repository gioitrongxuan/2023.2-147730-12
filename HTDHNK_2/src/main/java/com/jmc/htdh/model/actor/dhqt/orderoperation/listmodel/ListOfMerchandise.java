package com.jmc.htdh.model.actor.dhqt.orderoperation.listmodel;

import java.util.ArrayList;

import com.jmc.htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;

public class ListOfMerchandise {
	private String listOfListID;
	private String name;
	private String ID;
	private ArrayList<Merchandise> merchandises = new ArrayList<Merchandise>();

	public ListOfMerchandise(String mi2001, ArrayList<Merchandise> merchandises) {
		// TODO Auto-generated constructor stub
	}

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
