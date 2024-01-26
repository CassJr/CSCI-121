//this code converts money into quarters, dimes, and nickels based on user input
import java.util.Scanner; //imports the scanner
public class MoneyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //The scanner variable is created
        String RESET = "\u001B[0m"; //changes the color back to normal for the next text
        String RED = "\u001B[31m"; //makes the text red
        String GREEN = "\u001B[32m"; //makes the text green
        String BLUE = " \u001B[34m"; //makes the text blue
        String YELLOW = "\u001B[33m"; //makes the text yellow

        System.out.println(BLUE + "Enter the total amount of money" + RESET);
        double amount = sc.nextDouble();

        int cents = (int) (amount * 100);
        int quarters = (cents / 25);
        int dimes = ((cents % 25) /10);
        int nickels = (((cents % 25) % 10) / 5);
        int pennies = (((cents % 25) % 10) % 5);

        System.out.println(RED + "Quarters:" + quarters + RESET);
        System.out.println(GREEN + "Dimes:" + dimes + RESET);
        System.out.println(YELLOW + "Nickels:" + nickels + RESET);
        System.out.println(BLUE + "Pennies:" + pennies);
    }
}
