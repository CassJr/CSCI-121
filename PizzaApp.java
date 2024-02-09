import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class PizzaApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PizzaApp::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("BigY Order");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());

        JButton orderButton = new JButton("Hello! Welcome to BigY! Begin Order Here");
        frame.add(orderButton);

        orderButton.addActionListener(e -> {
            String[] options = {"Pizza", "Sandwich"};
            int choice = JOptionPane.showOptionDialog(frame,
                    "Choose what you would like to order",
                    "Order Options",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == 0) {
                orderPizza(frame);
            } else if (choice == 1) {
               orderSandwich(frame);
            }
        });

        frame.setVisible(true);
    }

    private static void orderPizza(JFrame frame) {
        String[] sizes = {"Small($10)", "Medium($15)", "Large($20)"};
        int pizzaSize = JOptionPane.showOptionDialog(frame,
                "Choose a pizza size",
                "Pizza Size",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                sizes,
                sizes[0]);

        final double[] total = {0.00};
        if (pizzaSize == 0) {
            total[0] += 10.00;
        } else if (pizzaSize == 1) {
            total[0] += 15.00;
        } else if (pizzaSize == 2) {
            total[0] += 20.00;
        }

        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setBackground(Color.ORANGE);
        JCheckBox c1 = new JCheckBox("Pepperoni");
        JCheckBox c2 = new JCheckBox("Sausage");
        JCheckBox c3 = new JCheckBox("Chicken");
        JCheckBox c4 = new JCheckBox("Peppers");
        JCheckBox c5 = new JCheckBox("Mushrooms");
        JCheckBox c6 = new JCheckBox("Extra Cheese ($0.00)");

        toppingsPanel.add(c1);
        toppingsPanel.add(c2);
        toppingsPanel.add(c3);
        toppingsPanel.add(c4);
        toppingsPanel.add(c5);
        toppingsPanel.add(c6);

        JOptionPane.showMessageDialog(frame, toppingsPanel, "Select up to 3 toppings", JOptionPane.PLAIN_MESSAGE);

        int toppingsCount = 0;
        if (c1.isSelected()) {
            toppingsCount += 1;
        }
        if (c2.isSelected()) {
            toppingsCount += 1;
        }
        if (c3.isSelected()) {
            toppingsCount += 1;
        }
        if (c4.isSelected()) {
            toppingsCount += 1;
        }
        if (c5.isSelected()) {
            toppingsCount += 1;
        }


        if (toppingsCount > 3) {
            JOptionPane.showMessageDialog(null, "Only choose up to 3 toppings");
        }else {
            if (toppingsCount == 3) total[0] += 1.25;
            else if (toppingsCount == 2) total[0] += 1.00;
            else if (toppingsCount == 1) total[0] += 0.50;
        }

            JOptionPane.showMessageDialog(frame, "Your total for your order is $" + total[0] + ". Thank you for your order!");
    }
    private static void orderSandwich(JFrame frame) {
        String[] sizes = {"Small($5)", "Medium($10)", "Large($15)", "Super($20)"};
        int SandwichSize = JOptionPane.showOptionDialog(frame,
                "Choose a Sandwich size",
                "Sandwich Size",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                sizes,
                sizes[0]);

        final double[] total = {0.00};
        if (SandwichSize == 0) {
            total[0] += 5.00;
        } else if (SandwichSize == 1) {
            total[0] += 10.00;
        } else if (SandwichSize == 2) {
            total[0] += 15.00;
        } else if (SandwichSize == 3) {
            total[0] += 20.00;
        }


        JPanel FillingPanel = new JPanel();
        FillingPanel.setBackground(Color.BLUE);
        JCheckBox c1 = new JCheckBox("Chicken");
        JCheckBox c2 = new JCheckBox("Avocado");
        JCheckBox c3 = new JCheckBox("Eggs");
        JCheckBox c4 = new JCheckBox("Bacon");
        JCheckBox c5 = new JCheckBox("Beef");
        JCheckBox c6 = new JCheckBox("Turkey");
        JCheckBox c7 = new JCheckBox("Guacamole");
        JCheckBox c8 = new JCheckBox("Mushrooms");
        JCheckBox c9 = new JCheckBox("Lettuce ($0.00)");
        JCheckBox c10 = new JCheckBox("Tomato ($0.00)");
        JCheckBox c11 = new JCheckBox("Extra Cheese ($0.00)");

        FillingPanel.add(c1);
        FillingPanel.add(c2);
        FillingPanel.add(c3);
        FillingPanel.add(c4);
        FillingPanel.add(c5);
        FillingPanel.add(c6);
        FillingPanel.add(c7);
        FillingPanel.add(c8);
        FillingPanel.add(c9);
        FillingPanel.add(c10);
        FillingPanel.add(c11);

        JOptionPane.showMessageDialog(frame, FillingPanel, "Select your filling", JOptionPane.PLAIN_MESSAGE);

        int FillingsCount = 0;
        if (c1.isSelected()) {
            FillingsCount += 1;
        }
        if (c2.isSelected()) {
            FillingsCount += 1;
        }
        if (c3.isSelected()) {
            FillingsCount += 1;
        }
        if (c4.isSelected()) {
            FillingsCount += 1;
        }
        if (c5.isSelected()) {
            FillingsCount += 1;
        }
        if (c6.isSelected()) {
            FillingsCount += 1;
        }
        if (c7.isSelected()) {
            FillingsCount += 1;
        }
        if (c8.isSelected()) {
            FillingsCount += 1;
        }

        if (FillingsCount == 6) {
            total[0] += 2.50;
        }
            else if (FillingsCount == 5) {
                total[0] += 2.25;
        }
            else if (FillingsCount == 4) {
                total[0] += 1.75;
        }
            else if (FillingsCount == 3) {
                total[0] += 1.25;
        }
            else if (FillingsCount == 2) {
                total[0] += 1.00;
        }
            else if (FillingsCount == 1) {
                total[0] += 0.50;
        }



        JPanel CondimentPanel = new JPanel();
        CondimentPanel.setBackground(Color.RED);
        JCheckBox b1 = new JCheckBox("Ketchup");
        JCheckBox b2 = new JCheckBox("Mayo");
        JCheckBox b3 = new JCheckBox("BBQ");
        JCheckBox b4 = new JCheckBox("Mustard");
        JCheckBox b5 = new JCheckBox("Chipotle");
        JCheckBox b6 = new JCheckBox("Hot Sauce");
        JCheckBox b7 = new JCheckBox("Honey BBQ");
        JCheckBox b8 = new JCheckBox("Relish");

        CondimentPanel.add(b1);
        CondimentPanel.add(b2);
        CondimentPanel.add(b3);
        CondimentPanel.add(b4);
        CondimentPanel.add(b5);
        CondimentPanel.add(b6);
        CondimentPanel.add(b7);
        CondimentPanel.add(b8);

        JOptionPane.showMessageDialog(frame, CondimentPanel, "Select Condiments ($0.00)", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(frame, "Your total for your order is $" + total[0] + ". Thank you for your order!");
    }

}


