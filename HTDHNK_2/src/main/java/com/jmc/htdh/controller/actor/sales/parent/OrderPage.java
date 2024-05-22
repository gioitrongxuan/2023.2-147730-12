package com.jmc.htdh.controller.actor.sales.parent;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class OrderPage {

    final String PATH_TO_LOGIN = "/view/common/login.fxml";
    final String PATH_TO_ORDER_CREATE = "/view/sales/create/search/MerchandiseSearch.fxml";
    final String PATH_TO_ORDER_MANAGEMENT = "/view/sales/manage/OrderManagement.fxml";

    @FXML
    public void logout(ActionEvent event) {

    }

    @FXML
    public void orderCreateButtonPressed(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PATH_TO_ORDER_CREATE));
            // Already setup controller in fxml file

            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void orderManagementButtonPressed(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PATH_TO_ORDER_MANAGEMENT));
            // Already setup controller in fxml file

            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
