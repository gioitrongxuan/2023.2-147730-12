package htdh.controller.actor.dhqt;

import htdh.model.actor.dhqt.Model;
import htdh.view.dhqt.BPDHQTMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DHQTController implements Initializable {
    public BorderPane client_parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldVal, newVal)->{
            switch (newVal){
                case  ORDER_LIST_MANAGEMENT -> client_parent.setCenter(Model.getInstance().getViewFactory().getOrderManagement());
                case SETTING -> client_parent.setCenter(Model.getInstance().getViewFactory().getPhanDuc());
                case LOGOUT -> onLogout();
                default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
            }
        });
    }
    private  void onLogout(){
        Stage stage = (Stage) client_parent.getScene().getWindow();
        Model.getInstance().getViewFactory().showLoginWindow();
        stage.close();
    }
}
