import java.util.Scanner;
public class ArrayLab {
    public static void main(String[]args) {
        System.out.println("Enter any number of double values up to 20");
        Scanner scanner = new Scanner(System.in);
        double[] values= new double[20];
        for (int i = 0; i < 20; i++) {
            System.out.println("Enter a double value. Type '/done' when finished");
            String input = scanner.next();

            if (input.contains("/done")) {
                break;
            }
            values[i] = Double.parseDouble(input);
        }
            for (int i = 0; i < 20; i++) {
                System.out.println("Your values:" + values[i]);
            }






    }
}
