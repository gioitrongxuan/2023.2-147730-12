package htdh.view.test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class A {

    @FXML
    private Button b;

    @FXML
    private TableColumn<?, ?> button;

    @FXML
    private TableColumn<?, ?> text;

    @FXML
    private CheckBox check;

    @FXML
    private TableColumn<?, ?> checkbox;

    @FXML
    private ChoiceBox<?> choice;

    @FXML
    private TableColumn<?, ?> choicebox;

    @FXML
    private ComboBox<?> combo;

    @FXML
    private TableColumn<?, ?> combobox;

    @FXML
    private Text t;

    @FXML
    private TableView<Datatype> table;

    ObservableList<Datatype> data;

    public void initialize() {
        data = FXCollections.observableArrayList(
                new Datatype("0001"),
                new Datatype("0002"),
                new Datatype("0003"),
                new Datatype("0004")

                );
        text.setCellValueFactory(
                new PropertyValueFactory<>("text")
        );

        button.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        checkbox.setCellValueFactory(
                new PropertyValueFactory<>("check")
        );

        choicebox.setCellValueFactory(
                new PropertyValueFactory<>("choice")
        );

        combobox.setCellValueFactory(
                new PropertyValueFactory<>("combo")
        );






        table.setItems(data);

    }

}
