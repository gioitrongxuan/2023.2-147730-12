package swing;
import javax.swing.JTextField;

public class CalculatorModel {
    private int calculationValue;

    public void addTwoNumbers(int firstNumber, int secondNumber) {
        calculationValue = firstNumber + secondNumber;
    }

    public void subtractTwoNumbers(int firstNumber, int secondNumber) {
        calculationValue = firstNumber - secondNumber;
    }

    public void multiplyTwoNumbers(int firstNumber, int secondNumber) {
        calculationValue = firstNumber * secondNumber;
    }

    public void divideTwoNumbers(int firstNumber, int secondNumber) throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        calculationValue = firstNumber / secondNumber;
    }

    public void calculateRemainder(int firstNumber, int secondNumber) throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("Cannot calculate remainder for division by zero");
        }
        calculationValue = firstNumber % secondNumber;
    }

    public int getCalculationValue() {
        return calculationValue;
    }

    public void clear(JTextField firstNumberField, JTextField secondNumberField) {
        calculationValue = 0;
        firstNumberField.setText("");
        secondNumberField.setText("");
    }
}
