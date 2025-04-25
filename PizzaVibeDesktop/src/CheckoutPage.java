import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CheckoutPage {

    public static void showCheckoutPage() {
        JFrame frame = new JFrame("PizzaVibe - Checkout Receipt");
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("PizzaVibe Receipt", SwingConstants.CENTER);
        title.setFont(new Font("Courier New", Font.BOLD, 20));
        panel.add(title, BorderLayout.NORTH);

        List<String> cartItems = SharedCart.getItems();
        double subtotal = 0.0;

        StringBuilder receiptBuilder = new StringBuilder();
        for (String item : cartItems) {
            receiptBuilder.append(item).append("\n");

            String[] parts = item.split("\\| Price: ");
            if (parts.length == 2) {
                try {
                    String priceString = parts[1].replace("$", "").trim();
                    subtotal += Double.parseDouble(priceString);
                } catch (NumberFormatException ignored) {}
            }
        }

        double tax = subtotal * 0.08;
        double total = subtotal + tax;

        receiptBuilder.append("\n");
        receiptBuilder.append(String.format("Subtotal:      $%.2f%n", subtotal));
        receiptBuilder.append(String.format("Tax (8%%):      $%.2f%n", tax));
        receiptBuilder.append(String.format("Total:         $%.2f%n", total));
        receiptBuilder.append("\nThank you for choosing PizzaVibe!");

        JTextArea receiptArea = new JTextArea(receiptBuilder.toString());
        receiptArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        receiptArea.setEditable(false);
        receiptArea.setLineWrap(true);
        receiptArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Confirm Order button
        JButton confirmButton = new JButton("Confirm Order");
        confirmButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmButton.setBackground(new Color(173, 216, 230)); // Light blue
        confirmButton.setFocusPainted(false);

        confirmButton.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to place this order?", "Confirm Order", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                SharedCart.clearCart();        // Clear the cart
                frame.dispose();           // Close receipt window
                new MenuViewPage();        // Go back to menu
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(confirmButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }
}
