package calculatorjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorJavaFXController {

	private CalculatorJavaFXModel theModel;
	
	public CalculatorJavaFXController(CalculatorJavaFXModel theModel) {
		this.theModel = theModel;
	}
	
	@FXML
    private TextField firstNumber;

    @FXML
    private TextField result;

    @FXML
    private TextField secondNumber;

    @FXML
    void addButton(ActionEvent event) {
    	int num1 = Integer.parseInt(firstNumber.getText());
		int num2 = Integer.parseInt(secondNumber.getText());
        theModel.addTwoNumbers(num1, num2);
        result.setText(String.valueOf(theModel.getCalculationValue()));
    }

    @FXML
    void minusButton(ActionEvent event) {
    	int num1 = Integer.parseInt(firstNumber.getText());
		int num2 = Integer.parseInt(secondNumber.getText());
        theModel.minusTwoNumbers(num1, num2);
        result.setText(String.valueOf(theModel.getCalculationValue()));
    }

    @FXML
    void mulButton(ActionEvent event) {
    	int num1 = Integer.parseInt(firstNumber.getText());
		int num2 = Integer.parseInt(secondNumber.getText());
        theModel.mulTwoNumbers(num1, num2);
        result.setText(String.valueOf(theModel.getCalculationValue()));
    }

    @FXML
    void divButton(ActionEvent event) {
    	int num1 = Integer.parseInt(firstNumber.getText());
		int num2 = Integer.parseInt(secondNumber.getText());
        try {
            theModel.divTwoNumbers(num1, num2);
            result.setText(String.valueOf(theModel.getCalculationValue()));
        } catch (ArithmeticException e) {
            result.setText(e.getMessage());
        }
    }
    
    @FXML
    void modButton(ActionEvent event) {
    	int num1 = Integer.parseInt(firstNumber.getText());
		int num2 = Integer.parseInt(secondNumber.getText());
        try {
            theModel.modTwoNumbers(num1, num2);
            result.setText(String.valueOf(theModel.getCalculationValue()));
        } catch (ArithmeticException e) {
            result.setText(e.getMessage());
        }
    }

    @FXML
    void clearButton(ActionEvent event) {
        firstNumber.clear();
        secondNumber.clear();
        result.clear();
    }
}