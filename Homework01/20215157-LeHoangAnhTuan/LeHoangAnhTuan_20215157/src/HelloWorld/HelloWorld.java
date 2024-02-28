package HelloWorld;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        // Ask user to enter name then display hello to that name
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is your name? ");
        String name = scanner.nextLine();
        scanner.close();

        System.out.println("Hello " + name);
    }
}