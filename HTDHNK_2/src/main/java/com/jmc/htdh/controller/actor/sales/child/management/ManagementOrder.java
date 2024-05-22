package com.jmc.htdh.controller.actor.sales.child.management;

import com.jmc.htdh.controller.actor.sales.parent.OrderPage;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import com.jmc.htdh.model.actor.internationalOrder.orderoperation.listofmerchandisemodel.ListOfMerchandise;
import com.jmc.htdh.model.actor.internationalOrder.orderoperation.merchandisemodel.Merchandise;

import java.util.ArrayList;

public class ManagementOrder extends OrderPage {

    @FXML
    private TableView<ListOfMerchandise> table;
    @FXML
    private TableColumn<ListOfMerchandise, String> orderID;

    @FXML
    private TableColumn<?, ?> orderCreateTime;

    @FXML
    private TableColumn<?, ?> orderDescrip;

    @FXML
    private TableColumn<?, ?> orderReceived;

    @FXML
    private TableColumn<?, ?> orderState;

    private ObservableList<ListOfMerchandise> listOfMerchandise;

    public void initialize() {
        listOfMerchandise = FXCollections.observableArrayList(
                new ListOfMerchandise("MI2001", new ArrayList<Merchandise>()),
                new ListOfMerchandise("MI2002", new ArrayList<Merchandise>()),
                new ListOfMerchandise("MI2003", new ArrayList<Merchandise>()),
                new ListOfMerchandise("MI2004", new ArrayList<Merchandise>())
        );
        orderID.setCellValueFactory(new PropertyValueFactory<ListOfMerchandise, String>("listOfListID"));

        table.setItems(listOfMerchandise);

    }
}
