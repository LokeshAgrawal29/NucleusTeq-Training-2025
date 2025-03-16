// Q3 Create a program to convert a temperature from Celsius to Fahrenheit and vice versa.
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Convert to (Celsius or Fahrenheit)? Enter C/F: ");
        char choice = scanner.next().toUpperCase().charAt(0);

       
        if (choice == 'C') {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.println("Temperature in Celsius: " + String.format("%.2f", celsius) + "°C");
        } else if (choice == 'F') {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println("Temperature in Fahrenheit: " + String.format("%.2f", fahrenheit) + "°F");
        } else {
            System.out.println("Invalid choice. Please enter 'C' or 'F'.");
        }

        scanner.close();
    }
}
