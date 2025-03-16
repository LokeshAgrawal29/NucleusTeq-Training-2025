// Q2 Implement a function to count the number of vowels in a string.

import java.util.Scanner;

public class VowelCount{
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        System.out.println("Number of vowels: " + countVowels(input));
        
        scanner.close();
    }
}
