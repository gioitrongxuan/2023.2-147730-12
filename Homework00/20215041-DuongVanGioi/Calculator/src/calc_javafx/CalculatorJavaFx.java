package calc_javafx;

import java.io.IOException;

import calc_swing.CalculatorSwingModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorJavaFx extends Application{
	@Override
	public void start(Stage primaryStage) throws IOException {
        final String View_Path = "CalculatorJavaFxView.fxml";
        final String Title = "Calculator JavaFx";
        CalculatorJavaFxController controller = new CalculatorJavaFxController(new CalculatorSwingModel());
        FXMLLoader loader = new FXMLLoader(getClass().getResource(View_Path));
        loader.setController(controller);
        Parent root = loader.load();
        primaryStage.setTitle(Title);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
	public static void main(String[] args) {
		launch(args);
	}
}
