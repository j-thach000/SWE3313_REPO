import javax.swing.*;
import java.awt.*;



public class CreateAccountScreen {

    public static void main(String[] args) {
        // Create the window
        JFrame frame = new JFrame("PizzaVibe - Create Account");
        frame.setSize(400, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Absolute positioning

        // Title
        JLabel title = new JLabel("Create Your PizzaVibe Account");
        title.setBounds(50, 30, 300, 30);
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);

        // Name field
        JTextField nameField = new JTextField();
        nameField.setBounds(100, 80, 200, 30);
        frame.add(nameField);
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 60, 200, 20);
        frame.add(nameLabel);

        // Email field
        JTextField emailField = new JTextField();
        emailField.setBounds(100, 140, 200, 30);
        frame.add(emailField);
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 120, 200, 20);
        frame.add(emailLabel);

        // Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 200, 200, 30);
        frame.add(passwordField);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 180, 200, 20);
        frame.add(passwordLabel);

        // Confirm password field
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(100, 260, 200, 30);
        frame.add(confirmPasswordField);
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(100, 240, 200, 20);
        frame.add(confirmPasswordLabel);

        // Create Account button
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(100, 320, 200, 40);
        createAccountButton.setBackground(new Color(247, 233, 7)); // yellow
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(createAccountButton);

        JButton alreadyHaveAccountButton = new JButton("Already have an account?");
        alreadyHaveAccountButton.setBounds(100, 390, 200, 20);
        alreadyHaveAccountButton.setFont(new Font("Arial", Font.PLAIN, 12));
        alreadyHaveAccountButton.addActionListener(e -> {
            frame.dispose();
            Main.main(null);
        });


        frame.add(alreadyHaveAccountButton);

        createAccountButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter both email and password.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                frame.dispose();
                new MenuPage();
            }
        });
        // Show the window
        frame.setVisible(true);
    }
}
