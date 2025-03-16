//  Q1 Write a program to calculate the area of a circle, rectangle, or triangle based on user input.
import java.util.Scanner;

public class AreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a shape (circle, rectangle, triangle): ");
        String shape = scanner.nextLine().toLowerCase();

        switch (shape) {
            case "circle":
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                System.out.println("Area of Circle: " + (Math.PI * radius * radius));
                break;
            case "rectangle":
                System.out.print("Enter length and breadth: ");
                double length = scanner.nextDouble();
                double breadth = scanner.nextDouble();
                System.out.println("Area of Rectangle: " + (length * breadth));
                break;
            case "triangle":
                System.out.print("Enter base and height: ");
                double base = scanner.nextDouble();
                double height = scanner.nextDouble();
                System.out.println("Area of Triangle: " + (0.5 * base * height));
                break;
            default:
                System.out.println("Invalid shape");
        }
        scanner.close();
    }
}

