// Q4  Write a program to print the Fibonacci sequence up to a specified number.

import java.util.Scanner;

public class FibonacciSeries {
    public static void printFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Invalid input. Enter a positive number.");
            return;
        }

        long a = 0, b = 1;
        System.out.print("Fibonacci Sequence: " + a);

        if (n > 1) System.out.print(", " + b);

        for (int i = 2; i < n; i++) {
            long next = a + b;
            System.out.print(", " + next);
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int num = scanner.nextInt();
        printFibonacci(num);
        scanner.close();
    }
}