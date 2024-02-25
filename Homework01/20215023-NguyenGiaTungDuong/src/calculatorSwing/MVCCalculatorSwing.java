package calculatorSwing;

public class MVCCalculatorSwing {
    
    public static void main(String[] args) {
    	
    	CalculatorSwingView theView = new CalculatorSwingView();
        
    	CalculatorSwingModel theModel = new CalculatorSwingModel();
        
        CalculatorSwingController theController = new CalculatorSwingController(theView,theModel);
        
        theView.setVisible(true);
        
    }
}
