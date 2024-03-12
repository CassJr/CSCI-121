public class Pizza {
    private String[] toppings;
    public double price;

    public Pizza(String[] toppings, int numberOfToppings) {
        this.toppings = new String[10];

        StringBuilder pizzaDesc = new StringBuilder();
        for (int i = 0; i < numberOfToppings; i++) {
            this.toppings[i] = toppings[i];
            pizzaDesc.append(toppings[i]);
            if (i < numberOfToppings - 1) {
                pizzaDesc.append(", ");
            }
        }

        this.price = 14 + 2 * numberOfToppings;
    }

    public String toString() {
        StringBuilder toppingsList = new StringBuilder();
        for (String topping : toppings) {
            if (topping != null) {
                toppingsList.append(topping).append(", ");
            }
        }

        if (toppingsList.length() > 0) {
            toppingsList.setLength(toppingsList.length() - 2);
        }

        return "Pizza toppings: " + toppingsList + " " + "\nPrice: $" + price;
    }
}

