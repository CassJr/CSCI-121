import java.util.Scanner;

public class BadSubscriptCaught {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] FirstName = {"James", "Robert", "John", "Michael", "David", "William", "Richard", "Joseph", "Thomas", "Charles"};
        System.out.println("Enter a number between 0 and 9 to display chosen name");

        try {
            int input = scanner.nextInt();
            System.out.println("First name chosen is: " + FirstName[input]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: The number you entered is not valid. Enter a number between 0 and 9.");
        }
    }
}
