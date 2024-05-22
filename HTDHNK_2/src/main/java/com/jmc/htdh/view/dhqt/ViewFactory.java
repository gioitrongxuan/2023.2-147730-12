package com.jmc.htdh.view.dhqt;

import com.jmc.htdh.controller.bpdhqt.BPDHQTController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    private AccountType loginAccountType;
    //ClientView
    private final ObjectProperty<BPDHQTMenuOptions> clientSelectedMenuItem ;
    private AnchorPane dashboardView;
    private AnchorPane orderManagement;
//     AdminView
//    ....
    public  ViewFactory(){
        this.loginAccountType = AccountType.BPDHQT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
//        this.adminSelectedMenuItem..

    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ObjectProperty<BPDHQTMenuOptions> getClientSelectedMenuItem(){
        return clientSelectedMenuItem;

    }


    public AnchorPane getDashboardView() {
       if (dashboardView == null) {
           try{
                dashboardView = new FXMLLoader(getClass().getResource("/fxml/BPDHQT/Dashboard.fxml")).load();
           }catch (Exception e) {
               e.printStackTrace();
           }
       }
       return dashboardView;
    }
    public AnchorPane getOrderManagement() {
        if (orderManagement == null) {
            try{
                orderManagement = new FXMLLoader(getClass().getResource("/fxml/BPDHQT/OrderList.fxml")).load();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orderManagement;
    }

    public  void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        createStage(loader);
    };
    public void showBPDHQTWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/BPDHQT/Client.fxml"));
        BPDHQTController clientController = new BPDHQTController();
        loader.setController(clientController);
        createStage(loader);
    }
    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/images/icon.png"))));
        stage.setResizable(false);
        stage.setTitle("BPDHQT");
        stage.show();
    }
    public void closeStage(Stage stage){
        stage.close();
    }
}

