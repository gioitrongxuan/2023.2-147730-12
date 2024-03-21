package calculatorjavaswing;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorJavaSwingView extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField firstNumber  = new JTextField(10);
	private JTextField secondNumber = new JTextField(10);
	private JTextField calcSolution = new JTextField(10);
	private JButton addButton = new JButton("+");
	private JButton minusButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton("/");
	private JButton modButton = new JButton("%");
	private JButton clearButton = new JButton("CLEAR");
	
	CalculatorJavaSwingView(){
		
		JPanel calcPanel = new JPanel(new GridLayout(6, 2));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		
		calcPanel.add(new JLabel("First number"));
		calcPanel.add(firstNumber);
		calcPanel.add(new JLabel("Second number"));
		calcPanel.add(secondNumber);
		calcPanel.add(new JLabel("Result"));
		calcPanel.add(calcSolution);
		calcSolution.setEditable(false);
		calcPanel.add(addButton);
		calcPanel.add(minusButton);
		calcPanel.add(mulButton);
		calcPanel.add(divButton);
		calcPanel.add(modButton);
		calcPanel.add(clearButton);
		
		this.add(calcPanel);
		
	}
	
	public int getFirstNumber() {
		
        return Integer.parseInt(firstNumber.getText());
        
    }

    public int getSecondNumber() {
    	
        return Integer.parseInt(firstNumber.getText());
        
    }

    public double getCalcSolution() {
    	
        return Double.parseDouble(calcSolution.getText());
        
    }

    public void setFirstNumber(String str) {
    	
        firstNumber.setText(str);
        
    }

    public void setSecondNumber(String str) {
    	
        secondNumber.setText(str);
        
    }

    public void setCalcSolution(double solution) {
    	
        calcSolution.setText(Double.toString(solution));
        
    }

    public void setCalcSolution(String solution) {
    	
        calcSolution.setText(solution);
        
    }
	
	void addAddListener(ActionListener listenForAddButton){
		
		addButton.addActionListener(listenForAddButton);
		
	}
	
	void addMinusListener(ActionListener listenForMinusButton){
		
		minusButton.addActionListener(listenForMinusButton);
		
	}
	
	void addMulListener(ActionListener listenForMulButton){
		
		mulButton.addActionListener(listenForMulButton);
		
	}
	
	void addDivListener(ActionListener listenForDivButton){
		
		divButton.addActionListener(listenForDivButton);
		
	}
	
	void addModListener(ActionListener listenForModButton){
		
		modButton.addActionListener(listenForModButton);
		
	}
	
	void addClearListener(ActionListener listenForClearButton){
		
		clearButton.addActionListener(listenForClearButton);
		
	}
	
	void displayErrorMessage(String errorMessage){
		
		JOptionPane.showMessageDialog(this, errorMessage);
		
	}
	
}
