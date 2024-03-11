import javax.swing.*;
import java.awt.Color;

public class ShoppingTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        JTextField itemNameField = new JTextField(10);
        JTextField itemPriceField = new JTextField(5);
        JTextField itemQuantityField = new JTextField(3);

        
        JButton addButton = new JButton("Add to Cart");
        JButton searchButton = new JButton("Search");
        JButton removeButton = new JButton("Remove");
        JButton OrderButton = new JButton("Order");
        JLabel totalPriceLabel = new JLabel("Total Price: $0.00");

        panel.add(new JLabel("Item Name:"));
        panel.add(itemNameField);
        panel.add(new JLabel("Price:"));
        panel.add(itemPriceField);
        panel.add(new JLabel("Quantity:"));
        panel.add(itemQuantityField);
        panel.add(addButton);
        panel.add(searchButton);
        panel.add(removeButton);
        panel.add(totalPriceLabel);
        panel.add(OrderButton);

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

        addButton.addActionListener(e -> {
            try {
                String itemName = itemNameField.getText();
                double price = Double.parseDouble(itemPriceField.getText());
                int quantity = Integer.parseInt(itemQuantityField.getText());

                Item item = new Item(itemName, price);
                ItemOrder order = new ItemOrder(item, quantity);
                ShoppingCart.add(order);

                totalPriceLabel.setText("Total Price: $" + ShoppingCart.getTotalPrice());

                itemNameField.setText("");
                itemPriceField.setText("");
                itemQuantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter valid numbers for the price and quantity.");
            }
        });

        searchButton.addActionListener(e -> {
            String itemName = itemNameField.getText();
            JOptionPane.showMessageDialog(frame, ShoppingCart.search(itemName) ? "Item found: " + itemName : "Item not found: " + itemName);
        });

        removeButton.addActionListener(e -> {
            String itemName = itemNameField.getText();
            if (ShoppingCart.remove(itemName)) {
                JOptionPane.showMessageDialog(frame, "Item removed: " + itemName);
                totalPriceLabel.setText("Total Price: $" + ShoppingCart.getTotalPrice());
            } else {
                JOptionPane.showMessageDialog(frame, "Item not found: " + itemName);
            }
        });


            itemNameField.setText("");
            itemPriceField.setText("");
            itemQuantityField.setText("");

        totalPriceLabel.setText("Total Price: " + ShoppingCart.getTotalPrice());

        OrderButton.addActionListener(e -> {
            StringBuilder orderSummary = new StringBuilder();
            double TotalPrice= 0.00;
             for (ItemOrder itemOrder: ShoppingCart.getOrders()) {
                 String itemName = itemOrder.getItem().getName();
                 double itemPrice = itemOrder.getItem().getPrice();
                 int quantity = itemOrder.getQuantity();
                 double orderPrice = itemOrder.getPrice();
                 TotalPrice += orderPrice;
                 orderSummary.append(quantity + " " + itemName + " " + "for $" + itemPrice + " " + "Total: $" + orderPrice + "\n");
             }
                    orderSummary.append(String.format("Total Order Price: $%.2f", TotalPrice));
            JOptionPane.showMessageDialog(frame, orderSummary.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
        });


        }

    }
