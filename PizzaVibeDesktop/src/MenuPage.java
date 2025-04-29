import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPage {

    public MenuPage() {
        // Create frame
        JFrame frame = new JFrame("PizzaVibe Menu");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Welcome label
        JLabel titleLabel = new JLabel("🍕 Welcome to PizzaVibe!", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Buttons panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        JButton menuButton = new JButton("View Menu");
          menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuViewPage();
                frame.dispose();
            }
        });

        JButton cartButton = new JButton("Cart");
        cartButton.setPreferredSize(new Dimension(200, 60));
        cartButton.setFont(new Font("Arial", Font.BOLD, 16));
        cartButton.setBackground(new Color(173, 216, 230));
        cartButton.setFocusPainted(false);

        cartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CartPage.showCartPage();
            }
        });

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CheckoutPage.showCheckoutPage();
            }
        });
        panel.add(menuButton);
        panel.add(cartButton);
        panel.add(checkoutButton);

        frame.add(panel, BorderLayout.CENTER);

        // Show frame
        frame.setVisible(true);
    }
}
