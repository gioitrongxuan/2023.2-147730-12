package test.bpdhqt.orderoperation.merchandisetest;

import java.util.ArrayList;

import controller.bpdhqt.orderoperation.merchandisecontroller.MerchandiseSiteOptController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.bpdhqt.orderoperation.merchandisemodel.Merchandise;
import model.sitemodel.Site;
public class SiteOptTest {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();

        // Thêm các phần tử vào ArrayList
//        numbers.add(10);
//        numbers.add(20);
//        numbers.add(30);
//        numbers.add(40);
//        numbers.add(50);

        // In các phần tử ra màn hình
        System.out.println("Các phần tử trong ArrayList:");
        
        	if( numbers.isEmpty() ) {
            System.out.println("0");
        }else{
        	for (Integer number : numbers) {
        	System.out.println(number);
        	}
        }
	}
}
