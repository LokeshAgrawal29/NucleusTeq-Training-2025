// Q3 Use a for loop to print a multiplication table.

public class MultiplicationTable {
    public static void main(String[] args) {
        int number = 2; 

        System.out.println("Multiplication Table of " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
}
