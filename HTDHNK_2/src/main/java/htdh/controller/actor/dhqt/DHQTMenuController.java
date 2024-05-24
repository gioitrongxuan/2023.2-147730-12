package htdh.controller.actor.dhqt;

import htdh.model.actor.dhqt.Model;
import htdh.view.dhqt.BPDHQTMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class DHQTMenuController implements Initializable {
    public Button dashboard_btn;
    public Button setting_btn;
    public Button logout_btn;
    public Button management_btn;
    @Override
    public void initialize(URL url, ResourceBundle resources) {
        addListeners();
    }
    private void addListeners(){
        dashboard_btn.setOnAction(event -> onDashboard());
        management_btn.setOnAction(event -> onManagement());
        setting_btn.setOnAction(event->onPhanDuc());
    }
    private void onManagement() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(BPDHQTMenuOptions.ORDER_LIST_MANAGEMENT);
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(BPDHQTMenuOptions.DASHBOARD);
    }
    private void onPhanDuc() {
    	Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(BPDHQTMenuOptions.SETTING);
    }
}
