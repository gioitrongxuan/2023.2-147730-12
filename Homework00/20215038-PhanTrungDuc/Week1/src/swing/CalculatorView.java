package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField firstNumberField = new JTextField(10);
    private JTextField secondNumberField = new JTextField(10);
    private JTextField resultField = new JTextField(10);

    private JButton additionButton = new JButton("+");
    private JButton subtractionButton = new JButton("-");
    private JButton multiplicationButton = new JButton("*");
    private JButton divisionButton = new JButton("/");
    private JButton moduloButton = new JButton("%");
    private JButton clearButton = new JButton("CLEAR");
    
    
    public JTextField getFirstNumberField() {
		return firstNumberField;
	}

	public void setFirstNumberField(JTextField firstNumberField) {
		this.firstNumberField = firstNumberField;
	}

	public JTextField getSecondNumberField() {
		return secondNumberField;
	}

	public void setSecondNumberField(JTextField secondNumberField) {
		this.secondNumberField = secondNumberField;
	}

	public JTextField getResultField() {
		return resultField;
	}

	public void setResultField(JTextField resultField) {
		this.resultField = resultField;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setAdditionButton(JButton additionButton) {
		this.additionButton = additionButton;
	}

	public void setSubtractionButton(JButton subtractionButton) {
		this.subtractionButton = subtractionButton;
	}

	public void setMultiplicationButton(JButton multiplicationButton) {
		this.multiplicationButton = multiplicationButton;
	}

	public void setDivisionButton(JButton divisionButton) {
		this.divisionButton = divisionButton;
	}

	public void setModuloButton(JButton moduloButton) {
		this.moduloButton = moduloButton;
	}

	public void setClearButton(JButton clearButton) {
		this.clearButton = clearButton;
	}

	public CalculatorView() {
        JPanel calcPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 200);
        calcPanel.setLayout(new GridLayout(2,1));

        calcPanel.add(new JLabel("First Number"));
        calcPanel.add(firstNumberField);
        calcPanel.add(new JLabel("Second Number"));
        calcPanel.add(secondNumberField);
        calcPanel.add(new JLabel("Result"));
        calcPanel.add(resultField);
        calcPanel.add(additionButton);
        calcPanel.add(subtractionButton);
        calcPanel.add(multiplicationButton);
        calcPanel.add(divisionButton);
        calcPanel.add(moduloButton);
        calcPanel.add(clearButton);
        resultField.setEditable(false);

        this.add(calcPanel);
    }

    public int getFirstNumber() {
        return Integer.parseInt(firstNumberField.getText());
    }

    public int getSecondNumber() {
        return Integer.parseInt(secondNumberField.getText());
    }

    public JButton getAdditionButton() {
        return additionButton;
    }

    public JButton getSubtractionButton() {
        return subtractionButton;
    }

    public JButton getMultiplicationButton() {
        return multiplicationButton;
    }

    public JButton getDivisionButton() {
        return divisionButton;
    }

    public JButton getModuloButton() {
        return moduloButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setCalcSolution(int solution) {
        resultField.setText(Integer.toString(solution));
    }

    public void addButtonListener(ActionListener a) {
        additionButton.addActionListener(a);
    }

    public void subButtonListener(ActionListener a) {
        subtractionButton.addActionListener(a);
    }

    public void mulButtonListener(ActionListener a) {
        multiplicationButton.addActionListener(a);
    }

    public void divButtonListener(ActionListener a) {
        divisionButton.addActionListener(a);
    }

    public void modButtonListener(ActionListener a) {
        moduloButton.addActionListener(a);
    }

    public void clearButtonListener(ActionListener a) {
        clearButton.addActionListener(a);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
