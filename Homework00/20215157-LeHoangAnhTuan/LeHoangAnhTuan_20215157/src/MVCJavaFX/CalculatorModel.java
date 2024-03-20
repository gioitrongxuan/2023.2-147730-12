package MVCJavaFX;

public class CalculatorModel {
    private double answer;

    public void addTwoNum(double firstNumber, double secondNumber){
        answer = firstNumber + secondNumber;
    }

    public void subTwoNum(double firstNumber, double secondNumber){
        answer = firstNumber - secondNumber;
    }

    public void mulTwoNum(double firstNumber, double secondNumber){
        answer = firstNumber * secondNumber;
    }

    public void divTwoNum(double firstNumber, double secondNumber){
        if (secondNumber != 0) {
            answer = firstNumber / secondNumber;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }

    public void modTwoNum(double firstNumber, double secondNumber){
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
