import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create the window
        JFrame frame = new JFrame("PizzaVibe Login");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Absolute positioning

        // Logo image
        ImageIcon logoIcon = new ImageIcon("src/logo.png");
        Image scaledImage = logoIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage));
        logoLabel.setBounds(160, 10, 80, 80);
        frame.add(logoLabel);

        // Title
        JLabel title = new JLabel("Sign in to PizzaVibe");
        title.setBounds(100, 100, 200, 30);
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);

        // Email field
        JTextField emailField = new JTextField();
        emailField.setBounds(100, 150, 200, 30);
        frame.add(emailField);

        // Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 200, 200, 30);
        frame.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Sign In");
        loginButton.setBounds(100, 250, 200, 40);
        loginButton.setBackground(new Color(247, 233, 7)); // yellow
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(loginButton);
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter both email and password.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } else {
                frame.dispose();
                new MenuPage();
            }
        });

        frame.setVisible(true);
    }
}
