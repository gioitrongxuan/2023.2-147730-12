import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MessageView extends JFrame{
	
	private JTextField nameField;
	private JButton helloButton;
	
	public MessageView() {
		setTitle("Hello World");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,100);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		nameField = new JTextField(15);
		helloButton = new JButton("Say Hello");
		
		add(new JLabel("Enter your name:"));
		add(nameField);
		add(helloButton);
		
	}
	
	public String getName() {
		return nameField.getText();
	}
	void addHelloListener(ActionListener a) {
		helloButton.addActionListener(a);
	}
	void displayHelloMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
