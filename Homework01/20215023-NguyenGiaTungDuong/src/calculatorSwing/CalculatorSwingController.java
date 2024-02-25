package calculatorSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorSwingController {
	
	private CalculatorSwingView theView;
	private CalculatorSwingModel theModel;
	
	public CalculatorSwingController(CalculatorSwingView theView, CalculatorSwingModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addAddListener(new AddListener());
        this.theView.addMinusListener(new MinusListener());
        this.theView.addMulListener(new MulListener());
        this.theView.addDivListener(new DivListener());
        this.theView.addModListener(new ModListener());
        this.theView.addClearListener(new ClearListener());
	}
	
	class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calculate("+");
        }
    }

    class MinusListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calculate("-");
        }
    }

    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calculate("*");
        }
    }

    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calculate("/");
        }
    }

    class ModListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calculate("%");
        }
    }
    
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	theView.setFirstNumber("");
            theView.setSecondNumber("");
            theView.setCalcSolution("");
        }
    }

    private void calculate(String operator) {
        double firstNumber, secondNumber = 0;

        try {
            firstNumber = theView.getFirstNumber();
            secondNumber = theView.getSecondNumber();

            switch (operator) {
                case "+":
                    theModel.addTwoNumbers(firstNumber, secondNumber);
                    break;
                case "-":
                    theModel.minusTwoNumbers(firstNumber, secondNumber);
                    break;
                case "*":
                    theModel.mulTwoNumbers(firstNumber, secondNumber);
                    break;
                case "/":
                    theModel.divTwoNumbers(firstNumber, secondNumber);
                    break;
                case "%":
                    theModel.modTwoNumbers(firstNumber, secondNumber);
                    break;
            }

            theView.setCalcSolution(theModel.getCalculationValue());
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            theView.displayErrorMessage("You Need to Enter 2 Integers");
        } catch (ArithmeticException ex) {
            System.out.println(ex);
            theView.displayErrorMessage(ex.getMessage());
        }
    }
}
