import java.util.Scanner;

public class HelloWorld {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        scanner.close();
        
        System.out.println("Hello " + name);
    }
}
