package htdh.controller.actor.sales.createOrder.child.management;

import htdh.controller.actor.sales.createOrder.parent.OrderPage;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import htdh.model.actor.dhqt.orderoperation.listmodel.ListOfMerchandise;
import htdh.model.actor.dhqt.orderoperation.merchandisemodel.Merchandise;

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
