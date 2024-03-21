package calculatorjavafx;

public class CalculatorJavaFXModel {
    
    private double calculationValue;

    public void addTwoNumbers(int firstNumber, int secondNumber){
        calculationValue = firstNumber + secondNumber;
    }

    public void minusTwoNumbers(int firstNumber, int secondNumber){
        calculationValue = firstNumber - secondNumber;
    }

    public void mulTwoNumbers(int firstNumber, int secondNumber){
        calculationValue = firstNumber * secondNumber;
    }

    public void divTwoNumbers(int firstNumber, int secondNumber){
        if (secondNumber != 0) {
            calculationValue = firstNumber / secondNumber;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public void modTwoNumbers(int firstNumber, int secondNumber){
        if (secondNumber != 0) {
            calculationValue = firstNumber % secondNumber;
        } else {
            throw new ArithmeticException("Cannot take modulus by zero");
        }
    }

    public double getCalculationValue(){
        return calculationValue;
    }
}