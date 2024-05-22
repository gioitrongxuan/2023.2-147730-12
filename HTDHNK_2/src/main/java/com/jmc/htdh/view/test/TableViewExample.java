package com.jmc.htdh.view.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class TableViewExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        final String PROGRAM_PATH = "/fxml/a.fxml";
        URL url = getClass().getResource(PROGRAM_PATH);
        FXMLLoader fxmlLoader = new FXMLLoader(url);

//        đã setup controller tại fxml
//        OrderManagement orderPage = new OrderManagement();
//        fxmlLoader.setController(orderPage);

        Parent root = fxmlLoader.load();
        stage.setTitle("Order Management");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
