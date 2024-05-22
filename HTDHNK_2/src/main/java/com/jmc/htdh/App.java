package com.jmc.htdh;

import com.jmc.htdh.model.actor.dhqt.Model;
import javafx.application.Application;
import javafx.stage.Stage;
public class App extends Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
