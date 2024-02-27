import java.util.Scanner;

public class ArithException {
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to take its square root");
        try {
            int input = scanner.nextInt();
            if (input < 0) {
                throw new ArithmeticException("Square root cannot be negative");
            } double output = Math.sqrt(input);
            System.out.println("The square root of " + input + " is " + output);

            } catch(ArithmeticException e) {
                System.out.println("Error found: " + e.getMessage());
            }

        }
    }

