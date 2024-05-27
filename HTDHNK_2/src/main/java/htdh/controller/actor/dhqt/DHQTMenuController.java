package htdh.controller.actor.dhqt;

import htdh.model.actor.dhqt.Model;
import htdh.view.dhqt.BPDHQTMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DHQTMenuController implements Initializable {
    public Button dashboard_btn;
    public Button order_btn;
    public Button logout_btn;
    public Button rejectOrder_btn;
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        addListeners();
    }
    private void addListeners(){
        dashboard_btn.setOnAction(event -> onDashboard());
        rejectOrder_btn.setOnAction(event -> onRejectOrder());
        order_btn.setOnAction(event->onPhanDuc());
        logout_btn.setOnAction(event -> onLogout());
    }
    private void onRejectOrder() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(BPDHQTMenuOptions.ORDER_LIST_MANAGEMENT);
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(BPDHQTMenuOptions.DASHBOARD);
    }
    private void onPhanDuc() {
    	Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(BPDHQTMenuOptions.SETTING);
    }
    private void onLogout() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(BPDHQTMenuOptions.LOGOUT);
    }

}
