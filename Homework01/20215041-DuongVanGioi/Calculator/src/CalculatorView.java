
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame{
	private JLabel firstNumberLabel = new JLabel("First Number");
	private JTextField firstNumber = new JTextField(10);
	private JLabel secondNumberLabel = new JLabel("Second Number");
	private JTextField secondNumber = new JTextField(10);
	private JLabel resultLabel = new JLabel("Result");
	private JTextField result = new JTextField(10);
	
	private JButton additionButton = new JButton("+");
	private JButton subtractionButton = new JButton("-");
	private JButton multiplicationButton = new JButton("*");
	private JButton divisionButton = new JButton("/");
	private JButton moduloButton = new JButton("%");
	private JButton clearButton = new JButton("CLEAR");
	
CalculatorView(){
		
		// Sets up the view and adds the components
		
		JPanel calcPanel = new JPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 200);
		calcPanel.setLayout(new GridLayout(6,2));
		calcPanel.add(firstNumberLabel);
		calcPanel.add(firstNumber);
		calcPanel.add(secondNumberLabel);
		calcPanel.add(secondNumber);
		calcPanel.add(resultLabel);
		calcPanel.add(result);
		calcPanel.add(additionButton);
		calcPanel.add(subtractionButton);
		calcPanel.add(multiplicationButton);
		calcPanel.add(divisionButton);
		calcPanel.add(moduloButton);
		calcPanel.add(clearButton);
		result.setEditable(false);
	
		this.add(calcPanel);
		
		// End of setting up the components --------
		
	}
	
	public int getFirstNumber(){
		
		return Integer.parseInt(firstNumber.getText());
		
	}
	
	public int getSecondNumber(){
		
		return Integer.parseInt(secondNumber.getText());
		
	}
	public void resetFirstNumber() {
		firstNumber.setText(null);
	}
	public void resetSecondNumber() {
		secondNumber.setText(null);
	}
	
	public int getCalcSolution(){
		
		return Integer.parseInt(result.getText());
		
	}
	public void resetCalcSolution(){
		
		result.setText("");
		
	}

	
	public void setCalcSolution(int solution){
		
		result.setText(Integer.toString(solution));
		
	}

	void clearButtonListener(ActionListener a){
		
		clearButton.addActionListener(a);
		
	}
	void addButtonListener(ActionListener a){
		
		additionButton.addActionListener(a);
		
	}
	void divButtonListener(ActionListener a){
		
		divisionButton.addActionListener(a);
		
	}
	void subButtonListener(ActionListener a){
		
		subtractionButton.addActionListener(a);
		
	}
	void mulButtonListener(ActionListener a){
		
		multiplicationButton.addActionListener(a);
		
	}
	void modButtonListener(ActionListener a){
		
		moduloButton.addActionListener(a);
		
	}
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
}
