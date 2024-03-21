package MVCSwing;

public class CalculatorModel {
    
    private double answer;

    public void addNumber(double firstNumber, double secondNumber){
        answer = firstNumber + secondNumber;
    }

    public void subNumber(double firstNumber, double secondNumber){
        answer = firstNumber - secondNumber;
    }

    public void mulNumber(double firstNumber, double secondNumber){
        answer = firstNumber * secondNumber;
    }

    public void divNumber(double firstNumber, double secondNumber){
        if (secondNumber != 0) {
            answer = firstNumber / secondNumber;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public void modTwoNumbers(double firstNumber, double secondNumber){
        if (secondNumber != 0) {
            answer = firstNumber % secondNumber;
        } else {
            throw new ArithmeticException("Cannot take modulus by zero");
        }
    }

    public double getAnswer(){
        return answer;
    }
}