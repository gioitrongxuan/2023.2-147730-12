package MVCSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
	
	private CalculatorView theView;
	private CalculatorModel theModel;
	
	public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addAddListener(new AddListener());
        this.theView.addSubListener(new SubListener());
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

    class SubListener implements ActionListener {
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
                    theModel.addNumber(firstNumber, secondNumber);
                    break;
                case "-":
                    theModel.subNumber(firstNumber, secondNumber);
                    break;
                case "*":
                    theModel.mulNumber(firstNumber, secondNumber);
                    break;
                case "/":
                    theModel.divNumber(firstNumber, secondNumber);
                    break;
                case "%":
                    theModel.modTwoNumbers(firstNumber, secondNumber);
                    break;
            }

            theView.setCalcSolution(theModel.getAnswer());
        } catch (NumberFormatException ex) {
            System.out.println(ex);
            theView.displayErrorMessage("You Need to Enter 2 Integers");
        } catch (ArithmeticException ex) {
            System.out.println(ex);
            theView.displayErrorMessage(ex.getMessage());
        }
    }
}
