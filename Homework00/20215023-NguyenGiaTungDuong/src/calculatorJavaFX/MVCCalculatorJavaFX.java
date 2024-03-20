package calculatorJavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCCalculatorJavaFX extends Application {
	private static CalculatorJavaFXModel theModel = new CalculatorJavaFXModel();
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		final String FXML_FILE_PATH = "/calculatorJavaFX/Calculator.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_FILE_PATH));
		CalculatorJavaFXController theController = new CalculatorJavaFXController(theModel);
		fxmlLoader.setController(theController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
