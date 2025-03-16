// Q1  Explain the difference between primitive and reference data types with examples.

// In Java, data types are categorized into two main types:

// Primitive Data Types (store actual values)
// Reference Data Types (store memory addresses of objects)
// Example of Primitive Data Types 

// public class PrimitiveExample {
//     public static void main(String[] args) {
//         int age = 25;        // Integer (Whole number)
//         double price = 99.99; // Floating-point number
//         char grade = 'A';     // Character
//         boolean isJavaFun = true; // Boolean (true/false)

//         System.out.println("Age: " + age);
//         System.out.println("Price: " + price);
//         System.out.println("Grade: " + grade);
//         System.out.println("Is Java Fun? " + isJavaFun);
//     }
// }
// // Example of Reference Data Types 

import java.util.Arrays;

public class ReferenceExample {
    public static void main(String[] args) {
        String name = "John";  // String is a reference type
        int[] numbers = {1, 2, 3, 4, 5}; // Array (reference type)

        System.out.println("Name: " + name);
        System.out.println("Numbers: " + Arrays.toString(numbers));

        // Modifying the array (affects the original reference)
        numbers[0] = 10;
        System.out.println("Modified Numbers: " + Arrays.toString(numbers));
    }
}
