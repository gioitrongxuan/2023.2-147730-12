package calculatorJavaFX;

public class CalculatorJavaFXModel {
    
    private double calculationValue;

    public void addTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber + secondNumber;
    }

    public void minusTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber - secondNumber;
    }

    public void mulTwoNumbers(double firstNumber, double secondNumber){
        calculationValue = firstNumber * secondNumber;
    }

    public void divTwoNumbers(double firstNumber, double secondNumber){
        if (secondNumber != 0) {
            calculationValue = firstNumber / secondNumber;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public void modTwoNumbers(double firstNumber, double secondNumber){
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