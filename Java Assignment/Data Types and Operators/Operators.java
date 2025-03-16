// Q2 2) Write a program to demonstrate the use of arithmetic, logical, and relational operators.
import java.util.Scanner;

public class Operators{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //  Taking input from user
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();

        //  Arithmetic Operators
        System.out.println("\n Arithmetic Operators:");
        System.out.println("Addition (a + b): " + (a + b));
        System.out.println("Subtraction (a - b): " + (a - b));
        System.out.println("Multiplication (a * b): " + (a * b));
        System.out.println("Division (a / b): " + (a / b));
        System.out.println("Modulus (a % b): " + (a % b));

        //  Relational Operators
        System.out.println("\n Relational Operators:");
        System.out.println("a == b : " + (a == b)); // Equal to
        System.out.println("a != b : " + (a != b)); // Not equal to
        System.out.println("a > b  : " + (a > b));  // Greater than
        System.out.println("a < b  : " + (a < b));  // Less than
        System.out.println("a >= b : " + (a >= b)); // Greater than or equal to
        System.out.println("a <= b : " + (a <= b)); // Less than or equal to

        //  Logical Operators
        System.out.println("\n Logical Operators:");
        boolean cond1 = (a > 0);
        boolean cond2 = (b > 0);
        System.out.println("a > 0 && b > 0 : " + (cond1 && cond2)); // AND
        System.out.println("a > 0 || b > 0 : " + (cond1 || cond2)); // OR
        System.out.println("!(a > 0)       : " + (!cond1));         // NOT

        scanner.close();
    }
}
