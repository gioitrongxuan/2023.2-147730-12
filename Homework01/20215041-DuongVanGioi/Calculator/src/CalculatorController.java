import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CalculatorController {
	private CalculatorModel calculatorModel;
	private CalculatorView calculatorView;
	public CalculatorController(CalculatorModel calculatorModel, CalculatorView calculatorView) {
		this.calculatorModel = calculatorModel;
		this. calculatorView = calculatorView;
		
		this.calculatorView.addButtonListener(new AddTwoNumbersListener());
		this.calculatorView.subButtonListener(new SubTwoNumbersListener());
		this.calculatorView.mulButtonListener(new MulTwoNumbersListener());
		this.calculatorView.divButtonListener(new DivTwoNumbersListener());
		this.calculatorView.modButtonListener(new ModTwoNumbersListener());
		this.calculatorView.clearButtonListener(new ClearListener());
	}
	class AddTwoNumbersListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int firstNumber, secondNumber = 0;
			
			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered
			
			try{
			
				firstNumber = calculatorView.getFirstNumber();
				secondNumber = calculatorView.getSecondNumber();
				
				calculatorModel.addTwoNumbers(firstNumber, secondNumber);
				
				calculatorView.setCalcSolution(calculatorModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				calculatorView.displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	class SubTwoNumbersListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int firstNumber, secondNumber = 0;		
			try{
			
				firstNumber = calculatorView.getFirstNumber();
				secondNumber = calculatorView.getSecondNumber();
				
				calculatorModel.subtractTwoNumbers(firstNumber, secondNumber);
				
				calculatorView.setCalcSolution(calculatorModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				calculatorView.displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	class MulTwoNumbersListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int firstNumber, secondNumber = 0;
			
			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered
			
			try{
			
				firstNumber = calculatorView.getFirstNumber();
				secondNumber = calculatorView.getSecondNumber();
				
				calculatorModel.multiplyTwoNumbers(firstNumber, secondNumber);
				
				calculatorView.setCalcSolution(calculatorModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				calculatorView.displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	class DivTwoNumbersListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int firstNumber, secondNumber = 0;
			
			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered
			
			try{
			
				firstNumber = calculatorView.getFirstNumber();
				secondNumber = calculatorView.getSecondNumber();
				
				calculatorModel.divideTwoNumbers(firstNumber, secondNumber);
				
				calculatorView.setCalcSolution(calculatorModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				calculatorView.displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	class ModTwoNumbersListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			int firstNumber, secondNumber = 0;
			
			// Surround interactions with the view with
			// a try block in case numbers weren't
			// properly entered
			
			try{
			
				firstNumber = calculatorView.getFirstNumber();
				secondNumber = calculatorView.getSecondNumber();
				
				calculatorModel.moduloTwoNumbers(firstNumber, secondNumber);
				
				calculatorView.setCalcSolution(calculatorModel.getCalculationValue());
			
			}

			catch(NumberFormatException ex){
				
				System.out.println(ex);
				
				calculatorView.displayErrorMessage("You Need to Enter 2 Integers");
				
			}
			
		}
		
	}
	class ClearListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			calculatorView.resetFirstNumber();
			calculatorView.resetSecondNumber();
			calculatorView.resetCalcSolution();
			
		}
		
	}
	
}