import javax.swing.*;

public class DemoPizza {
    public static void main(String[] args) {
        final int MaxToppings = 10;
        String[] toppings = new String[MaxToppings];
        int toppingCount = 0;
        String input = "";
        boolean DeliveryOp;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Select the size of your pizza:"));

        JRadioButton smallSize = new JRadioButton("Small");
        JRadioButton mediumSize = new JRadioButton("Medium");
        JRadioButton largeSize = new JRadioButton("Large");


        ButtonGroup group = new ButtonGroup();
        group.add(smallSize);
        group.add(mediumSize);
        group.add(largeSize);

        panel.add(smallSize);
        panel.add(mediumSize);
        panel.add(largeSize);


        int result = JOptionPane.showConfirmDialog(null, panel, "Pizza Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String selectedSize;
            if (smallSize.isSelected()) {
                selectedSize = "Small";
            } else if (mediumSize.isSelected()) {
                selectedSize = "Medium";
            } else {
                selectedSize = "Large";
            }

            JOptionPane.showMessageDialog(null, "You selected: " + selectedSize);
        } else {
            JOptionPane.showMessageDialog(null, "Order canceled.");
        }

        while (!"QUIT".equalsIgnoreCase(input) && toppingCount < MaxToppings) {
            input = JOptionPane.showInputDialog(null, "Enter a topping or QUIT to stop:");
            if (input != null && !"QUIT".equalsIgnoreCase(input)) {
                toppings[toppingCount++] = input;
            }
        }

        DeliveryOp = JOptionPane.showConfirmDialog(null, "Would you like to order delivery?", "Delivery Option", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        StringBuilder orderSummary = new StringBuilder("Order Summary:\nToppings: ");
        if (toppingCount == 0) {
            orderSummary.append("None\n");
        } else {
            for (int i = 0; i < toppingCount; i++) {
                orderSummary.append(toppings[i]).append("\n");
            }
        }
        orderSummary.append("Delivery: ").append(DeliveryOp ? "Yes" : "No");


        int confirm = JOptionPane.showConfirmDialog(null, orderSummary.toString(), "Is this order correct?", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (DeliveryOp) {
                String deliveryAddress = JOptionPane.showInputDialog(null, "Enter the delivery address:");
                showPizzaDetails(new DeliveryPizza(toppings, toppingCount, deliveryAddress));
            } else {
                showPizzaDetails(new Pizza(toppings, toppingCount));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Order canceled. Please start over.");
        }
    }

    private static void showPizzaDetails(Pizza pizza) {
        JOptionPane.showMessageDialog(null, pizza.toString());
    }
}
