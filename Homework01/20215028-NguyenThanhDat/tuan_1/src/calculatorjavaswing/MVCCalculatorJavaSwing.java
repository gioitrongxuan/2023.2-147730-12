package calculatorjavaswing;

public class MVCCalculatorJavaSwing {
    
    public static void main(String[] args) {
    	
    	CalculatorJavaSwingView theView = new CalculatorJavaSwingView();
        
    	CalculatorJavaSwingModel theModel = new CalculatorJavaSwingModel();
        
        CalculatorJavaSwingController theController = new CalculatorJavaSwingController(theView,theModel);
        
        theView.setVisible(true);
        
    }
}
