package calc_swing;

public class CalculatorSwing {
	public static void main(String[] args) {
		CalculatorSwingModel calculatorModel = new CalculatorSwingModel();
		CalculatorSwingView calculatorView = new CalculatorSwingView();
		CalculatorSwingController calculatorController = new CalculatorSwingController(calculatorModel, calculatorView);
		calculatorView.setVisible(true);
	}
}
