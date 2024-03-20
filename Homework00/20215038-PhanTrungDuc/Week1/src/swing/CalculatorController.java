package swing;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        view.addButtonListener(this);
        view.subButtonListener(this);
        view.mulButtonListener(this);
        view.divButtonListener(this);
        view.modButtonListener(this);
        view.clearButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int firstNumber = view.getFirstNumber();
            int secondNumber = view.getSecondNumber();

            if (e.getSource() == view.getAdditionButton()) {
                model.addTwoNumbers(firstNumber, secondNumber);
            } else if (e.getSource() == view.getSubtractionButton()) {
                model.subtractTwoNumbers(firstNumber, secondNumber);
            } else if (e.getSource() == view.getMultiplicationButton()) {
                model.multiplyTwoNumbers(firstNumber, secondNumber);
            } else if (e.getSource() == view.getDivisionButton()) {
                model.divideTwoNumbers(firstNumber, secondNumber);
            } else if (e.getSource() == view.getModuloButton()) {
                model.calculateRemainder(firstNumber, secondNumber);
            } else if (e.getSource() == view.getClearButton()) {
                model.clear(view.getFirstNumberField(), view.getSecondNumberField());
            }

            view.setCalcSolution(model.getCalculationValue());
        } catch (NumberFormatException ex) {
            view.displayErrorMessage("Invalid input. Please enter valid numbers.");
        } catch (ArithmeticException ex) {
            view.displayErrorMessage(ex.getMessage());
        }
    }
}
