package calc_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import calc_swing.CalculatorSwingModel;

public class CalculatorJavaFxController {
	private CalculatorSwingModel theModel;
	public CalculatorJavaFxController(CalculatorSwingModel theModel) {
		this.theModel = theModel;
	}

    @FXML
    private Button additionButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button divisionButton;

    @FXML
    private TextField firstNumber;

    @FXML
    private Button moduloButton;

    @FXML
    private Button multiplicationButton;

    @FXML
    private TextField result;

    @FXML
    private TextField secondNumber;

    @FXML
    private Button subtractionButton;

    @FXML
    void addButtonListener(ActionEvent event) {
		try{
		
			int first = Integer.parseInt(firstNumber.getText());
			int second = Integer.parseInt(secondNumber.getText());
			theModel.addTwoNumbers(first, second);
			result.setText(Integer.toString(theModel.getCalculationValue()));
		
		}

		catch(NumberFormatException ex){
			
			System.out.println(ex);
			
			displayErrorMessage("You Need to Enter 2 Integers");
			
		}
    }

    @FXML
    void clearButtonListener(ActionEvent event) {
    		firstNumber.setText(null);
    		secondNumber.setText(null);
    		result.setText(null);
    }

    @FXML
    void divButtonListener(ActionEvent event) {
    	try{
    		
			int first = Integer.parseInt(firstNumber.getText());
			int second = Integer.parseInt(secondNumber.getText());
			theModel.divideTwoNumbers(first, second);
			result.setText(Integer.toString(theModel.getCalculationValue()));
		
		}

		catch(NumberFormatException ex){
			
			System.out.println(ex);
			
			displayErrorMessage("You Need to Enter 2 Integers");
			
		}
    	catch (ArithmeticException ex) {
			System.out.println(ex);
			displayErrorMessage("Cannot divide by zero");
		}
    }

    @FXML
    void modButtonListener(ActionEvent event) {
    	try{
    		
			int first = Integer.parseInt(firstNumber.getText());
			int second = Integer.parseInt(secondNumber.getText());
			theModel.moduloTwoNumbers(first, second);
			result.setText(Integer.toString(theModel.getCalculationValue()));
		
		}

		catch(NumberFormatException ex){
			
			System.out.println(ex);
			
			displayErrorMessage("You Need to Enter 2 Integers");
			
		}
    	catch (ArithmeticException ex) {
			System.out.println(ex);
			displayErrorMessage("Cannot take modulus by zero");
		}
    }

    @FXML
    void mulButtonListener(ActionEvent event) {
    	try{
    		
			int first = Integer.parseInt(firstNumber.getText());
			int second = Integer.parseInt(secondNumber.getText());
			theModel.multiplyTwoNumbers(first, second);
			result.setText(Integer.toString(theModel.getCalculationValue()));
		
		}

		catch(NumberFormatException ex){
			
			System.out.println(ex);
			
			displayErrorMessage("You Need to Enter 2 Integers");
			
		}
    }

    @FXML
    void subButtonListener(ActionEvent event) {
    	try{
    		
			int first = Integer.parseInt(firstNumber.getText());
			int second = Integer.parseInt(secondNumber.getText());
			theModel.subtractTwoNumbers(first, second);
			result.setText(Integer.toString(theModel.getCalculationValue()));
		
		}

		catch(NumberFormatException ex){
			
			System.out.println(ex);
			
			displayErrorMessage("You Need to Enter 2 Integers");
			
		}
    }
    void displayErrorMessage(String errorMessage) {
    	Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

}
