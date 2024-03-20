package HelloWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
    private JButton greetButton;

    public HelloWorld() {
        setTitle("Greeting App");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JLabel nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField();
        greetButton = new JButton("Hello");

        greetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    JOptionPane.showMessageDialog(HelloWorld.this, "Hello, " + name + "!");
                } else {
                    JOptionPane.showMessageDialog(HelloWorld.this, "Please enter your name.");
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(greetButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	HelloWorld greetingApp = new HelloWorld();
                greetingApp.setVisible(true);
            }
        });
    }
}
