package htdh;

import htdh.model.actor.dhqt.Model;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @SuppressWarnings("exports")
	@Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    public static void main(String[] args) {
    	launch(args);
    }
}
