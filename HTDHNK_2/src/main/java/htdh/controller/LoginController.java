package htdh.controller;

import htdh.model.actor.dhqt.Model;
import htdh.model.actor.sales.ViewModel;
import htdh.view.dhqt.AccountType;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public ChoiceBox<AccountType> acc_seclector;
    public TextField username_fld;
    public TextField password_fld;
    public Label error_lbl;
    public Button login_btn;

    @Override
    public  void initialize(URL url, ResourceBundle resourceBundle) {
        acc_seclector.setItems(FXCollections.observableArrayList(AccountType.values()));
        acc_seclector.setValue(Model.getInstance().getViewFactory().getLoginAccountType());
        acc_seclector.valueProperty().addListener(observable -> Model.getInstance().getViewFactory().setLoginAccountType(acc_seclector.getValue()));
        login_btn.setOnAction(event -> onLogin());
    }

    private  void   onLogin (){
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        switch (Model.getInstance().getViewFactory().getLoginAccountType()){
            case BPDHQT-> {
                Model.getInstance().evalueteBPDHQTCred(username_fld.getText(),password_fld.getText());
                if(Model.getInstance().getBPDHQTLoginSuccessFlag()){
                    Model.getInstance().getViewFactory().showBPDHQTWindow();
                    //Close the login state
                    Model.getInstance().getViewFactory().closeStage(stage);
                } else{
                    username_fld.setText("");
                    password_fld.setText("");
                    error_lbl.setText("No such login credentials.");
                }
            }
            case ADMIN -> Model.getInstance().getViewFactory().showLoginWindow();
            case SALE -> {
                ViewModel.getInstance().getSaleViewFactory().showSaleWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            }
            case QLK -> Model.getInstance().getViewFactory().showLoginWindow();
            case SITE -> Model.getInstance().getViewFactory().showLoginWindow();
        }
    }
}
