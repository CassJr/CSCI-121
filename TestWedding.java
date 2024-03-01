import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.awt.Color;

public class TestWedding {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Wedding Plan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.orange);
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(5, 5, 5, 5);


        JTextField brideFirstNameText = new JTextField(20);
        JTextField brideLastNameText = new JTextField(20);
        JTextField groomFirstNameText = new JTextField(20);
        JTextField groomLastNameText = new JTextField(20);
        JTextField weddingDateText = new JTextField(10);
        JTextField locationText = new JTextField(50);
        JButton submitButton = new JButton("Submit");


        panel.add(new JLabel("Enter bride's first name:"), c);
        panel.add(brideFirstNameText, c);
        panel.add(new JLabel("Enter bride's last name:"), c);
        panel.add(brideLastNameText, c);
        panel.add(new JLabel("Enter groom's first name:"), c);
        panel.add(groomFirstNameText, c);
        panel.add(new JLabel("Enter groom's last name:"), c);
        panel.add(groomLastNameText, c);
        panel.add(new JLabel("Enter wedding date (YYYY-MM-DD):"), c);
        panel.add(weddingDateText, c);
        panel.add(new JLabel("Enter wedding location:"), c);
        panel.add(locationText, c);
        panel.add(submitButton, c);


        c.fill = GridBagConstraints.NONE;

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(e -> {
            String brideFirstName = brideFirstNameText.getText();
            String brideLastName = brideLastNameText.getText();
            Person bride = new Person(brideFirstName, brideLastName);

            String groomFirstName = groomFirstNameText.getText();
            String groomLastName = groomLastNameText.getText();
            Person groom = new Person(groomFirstName, groomLastName);

            Couple couple = new Couple(bride, groom);

            LocalDate weddingDate = LocalDate.parse(weddingDateText.getText());
            String location = locationText.getText();

            Wedding wedding = new Wedding(couple, weddingDate, location);

            String BrideEmail = wedding.getCouple().getBride().getFirstName() + "." +
                    wedding.getCouple().getBride().getLastName() + "@gmail.com";
            String GroomEmail = wedding.getCouple().getGroom().getFirstName() + "." +
                    wedding.getCouple().getGroom().getLastName() + "@gmail.com";

             String message = "You're invited to the wedding of:\n" +
                    "Bride: " + wedding.getCouple().getBride().getFirstName() + " " + wedding.getCouple().getBride().getLastName() + " " + "and" +
                    "\nGroom: " + wedding.getCouple().getGroom().getFirstName() + " " + wedding.getCouple().getGroom().getLastName() +
                    "\nDate: " + wedding.getWeddingDate() +
                    "\nLocation: " + wedding.getLocation() +
                    "\nContact " + BrideEmail + " " + "or" + " " + GroomEmail + " " + " with any questions." +
                     "\nWe hope to see you there!";

            JOptionPane.showMessageDialog(frame, message);
        });

    }
}
