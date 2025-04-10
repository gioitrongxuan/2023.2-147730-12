package calc_swing;

public class CalculatorSwingModel {
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

    public void divideTwoNumbers(int firstNumber, int secondNumber) throws ArithmeticException{
        calculationValue = firstNumber / secondNumber;
    }

    public void moduloTwoNumbers(int firstNumber, int secondNumber) throws ArithmeticException{
        calculationValue = firstNumber % secondNumber;
    }

    public int getCalculationValue() {
        return calculationValue;
    }
}
