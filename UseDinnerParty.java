import java.util.Scanner;

public class UseDinnerParty{
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        DinnerParty aDinnerParty = new DinnerParty();


        String[] Theme = {"Masquerade", "'80's Jam", "Hollywood Glam", "Beach Party", "Murder Mystery"};

        System.out.println("Choose a theme:");
        for (int a = 0; a < Theme.length; a++) {
            System.out.println((a + 1) + "." + Theme[a]);
        }
        System.out.println("Type the number of the theme of your choice");
        int ThemePick;
        ThemePick = scanner.nextInt();
        aDinnerParty.setThemePick(ThemePick);
        System.out.println("The theme of the party is theme number " + aDinnerParty.getThemePick());

        int GuestAmount;
        System.out.println("Enter number of guests for the party: ");
        GuestAmount = scanner.nextInt();
        aDinnerParty.setGuests(GuestAmount);

        System.out.println("The party has " + aDinnerParty.getGuests() + " guests");
        aDinnerParty.displayInvitation();


        System.out.println("Enter number of guests for the dinner party:");
        GuestAmount = scanner.nextInt();
        aDinnerParty.setGuests(GuestAmount);

        String [] DinnerOptions = {"Braised chicken legs", "Grilled Pork Spareribs", "Caesar Salad Roast Chicken", "Tofu ricotta"};

        System.out.println("Choose a Dinner Option:");
        for (int b = 0; b < DinnerOptions.length; b++) {
            System.out.println((b + 1) + "." + DinnerOptions[b]);
        }
        System.out.println("Type the number of the Dinner of your choice");
        int Choices;
        Choices = scanner.nextInt();
        aDinnerParty.setDinnerChoice(Choices);

        String [] DessertOptions = {"Ice cream", "Fruit tart", "Cheesecake", "Mousse"};

        System.out.println("Choose a Dessert:");
        for (int c = 0; c < DessertOptions.length; c++) {
            System.out.println((c + 1) + "." + DessertOptions[c]);
        }
        System.out.println("Type the number of the Dessert of your choice");
        int Dessert;
        Dessert = scanner.nextInt();
        aDinnerParty.setDessertChoice(Dessert);


        System.out.println("The dinner party has: " + aDinnerParty.getGuests() + " guests");
        System.out.println("Dinner option " + aDinnerParty.getDinnerChoice() + " will be served");
        System.out.println("Dessert option " + aDinnerParty.getDessertChoice() + " will be served");
        aDinnerParty.displayInvitation();
    }    }
