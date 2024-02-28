package MVCJavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    private CalculatorModel theModel;
    CalculatorController(CalculatorModel theModel){
        this.theModel = theModel;
    }
    @FXML
    private Button addButton;

    @FXML
    private TextField answer;

    @FXML
    private Button clearButton;

    @FXML
    private Button divButton;

    @FXML
    private TextField firstNum;

    @FXML
    private Button modButton;

    @FXML
    private Button mulButton;

    @FXML
    private TextField secondNum;

    @FXML
    private Button subButton;

//    private void setAnswer(String string){
//        this.answer.setText(string);
//    }

    @FXML
    void addNumber(ActionEvent event) {
        double num1 = Double.parseDouble(firstNum.getText());
        double num2 = Double.parseDouble(secondNum.getText());
        theModel.addTwoNum(num1, num2);
        answer.setText(String.valueOf(theModel.getAnswer()));
    }

    @FXML
    void clearNumber(ActionEvent event) {
        firstNum.setText("");
        secondNum.setText("");
        answer.setText("");
    }

    @FXML
    void divNumber(ActionEvent event) {
        double num1 = Double.parseDouble(firstNum.getText());
        double num2 = Double.parseDouble(secondNum.getText());
        theModel.divTwoNum(num1, num2);
        answer.setText(String.valueOf(theModel.getAnswer()));
    }

    @FXML
    void modNumber(ActionEvent event) {
        double num1 = Double.parseDouble(firstNum.getText());
        double num2 = Double.parseDouble(secondNum.getText());
        theModel.modTwoNum(num1, num2);
        answer.setText(String.valueOf(theModel.getAnswer()));
    }

    @FXML
    void mulNumber(ActionEvent event) {
        double num1 = Double.parseDouble(firstNum.getText());
        double num2 = Double.parseDouble(secondNum.getText());
        theModel.addTwoNum(num1, num2);
        answer.setText(String.valueOf(theModel.getAnswer()));
    }

    @FXML
    void subNumber(ActionEvent event) {
        double num1 = Double.parseDouble(firstNum.getText());
        double num2 = Double.parseDouble(secondNum.getText());
        theModel.subTwoNum(num1, num2);
        answer.setText(String.valueOf(theModel.getAnswer()));
    }

}
