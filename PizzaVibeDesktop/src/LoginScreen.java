import javax.swing.*;
import java.awt.*;

public class LoginScreen {

    public static void main(String[] args) {
        // Create the window
        JFrame frame = new JFrame("PizzaVibe Login");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Absolute positioning

        // Title
        JLabel title = new JLabel("Sign in to PizzaVibe");
        title.setBounds(100, 50, 200, 30);
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title);

        // Email field
        JTextField emailField = new JTextField();
        emailField.setBounds(100, 100, 200, 30);
        frame.add(emailField);

        // Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(100, 150, 200, 30);
        frame.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Sign In");
        loginButton.setBounds(100, 200, 200, 40);
        loginButton.setBackground(new Color(247, 233, 7)); // yellow
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(loginButton);

        // Show the window
        frame.setVisible(true);
    }
}