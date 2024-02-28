package MVCJavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCCalculator extends Application {
    private static CalculatorModel theModel = new CalculatorModel();

    @Override
    public void start(Stage stage) throws Exception{
        final String FXML_FILE_PATH = "/MVCJavaFX/Sceen.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_FILE_PATH));
        CalculatorController theController = new CalculatorController(theModel);
        fxmlLoader.setController(theController);
        Parent root = fxmlLoader.load();

        stage.setTitle("Calculator");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
