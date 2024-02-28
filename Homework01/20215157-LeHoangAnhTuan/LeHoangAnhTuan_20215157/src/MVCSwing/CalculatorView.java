package MVCSwing;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame{

	private JTextField firstNumber  = new JTextField(10);
	private JTextField secondNumber = new JTextField(10);
	private JTextField answer = new JTextField(10);

	private JButton addButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton("/");
	private JButton modButton = new JButton("%");
	private JButton clearButton = new JButton("CLEAR");
	
	CalculatorView(){
		// Setup the view and add the components
        JPanel calcPanel = new JPanel(new GridLayout(6, 2));
		
        calcPanel.add(new JLabel("First number"));
        calcPanel.add(firstNumber);
        calcPanel.add(new JLabel("Second number"));
        calcPanel.add(secondNumber);
        calcPanel.add(new JLabel("Result"));
        calcPanel.add(answer);
        answer.setEditable(false);

        calcPanel.add(addButton);
        calcPanel.add(subButton);
        calcPanel.add(mulButton);
        calcPanel.add(divButton);
        calcPanel.add(modButton);
        calcPanel.add(clearButton);
        
        this.add(calcPanel);

        // Set the position of the frame to the center of the screen
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
	}
	
	public double getFirstNumber() {
		
        return Double.parseDouble(firstNumber.getText());
        
    }

    public double getSecondNumber() {
    	
        return Double.parseDouble(secondNumber.getText());
        
    }

    public double getAnswer() {
    	
        return Double.parseDouble(answer.getText());
        
    }

    public void setFirstNumber(String str) {
    	
        firstNumber.setText(str);
        
    }

    public void setSecondNumber(String str) {
    	
        secondNumber.setText(str);
        
    }

    public void setCalcSolution(double solution) {
    	
        answer.setText(Double.toString(solution));
        
    }

    public void setCalcSolution(String solution) {
    	
        answer.setText(solution);
        
    }
	
	void addAddListener(ActionListener listenForAddButton){
		
		addButton.addActionListener(listenForAddButton);
		
	}
	
	void addSubListener(ActionListener listenForMinusButton){
		
		subButton.addActionListener(listenForMinusButton);
		
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
