package htdh.model.actor.dhqt.orderoperation.listmodel;

import java.util.ArrayList;

public class ListOfList {
	
	private String listOfListID;
	private String name;
	private ArrayList<ListOfMerchandise> listOfMerchandises = new ArrayList<ListOfMerchandise>();
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
	public ArrayList<ListOfMerchandise> getListOfMerchandise() {
		return listOfMerchandises;
	}
	public void setListOfMerchandise(ArrayList<ListOfMerchandise> listOfMerchandise) {
		this.listOfMerchandises = listOfMerchandise;
	}
	//
	//
	//
	public ListOfList(String listOfListID, String name, ArrayList<ListOfMerchandise> listOfMerchandise) {
		super();
		this.listOfListID = listOfListID;
		this.name = name;
		this.listOfMerchandises = listOfMerchandise;
	}
	public ListOfList(String listOfListID, ArrayList<ListOfMerchandise> listOfMerchandise) {
		super();
		this.listOfListID = listOfListID;
		this.listOfMerchandises = listOfMerchandise;
	}
	public ListOfList() {
		super();
	}
	//
	//
	//
	public void addListOfMerchandise(ListOfMerchandise listOfMerchandise) {
        this.listOfMerchandises.add(listOfMerchandise);
    }
}
