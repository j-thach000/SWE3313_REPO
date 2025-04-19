import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CartPage {
    public static void showCartPage() {
        JFrame frame = new JFrame("Your Cart");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Items in Your Cart", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title, BorderLayout.NORTH);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        List<String> cartItems = SharedCart.getItems();
        double subtotal = 0.0;

        for (String item : cartItems) {
            listModel.addElement(item);
            String[] parts = item.split("\\| Price: ");
            if (parts.length == 2) {
                try {
                    String priceString = parts[1].replace("$", "").trim();
                    subtotal += Double.parseDouble(priceString);
                } catch (NumberFormatException ignored) {}
            }
        }

        JList<String> itemList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(itemList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Summary panel
        JPanel summaryPanel = new JPanel();
        summaryPanel.setLayout(new BoxLayout(summaryPanel, BoxLayout.Y_AXIS));
        double tax = subtotal * 0.08;
        double total = subtotal + tax;

        JLabel subtotalLabel = new JLabel("Subtotal: $" + String.format("%.2f", subtotal));
        JLabel taxLabel = new JLabel("Tax (8%): $" + String.format("%.2f", tax));
        JLabel totalLabel = new JLabel("Total: $" + String.format("%.2f", total));
        subtotalLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        taxLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));

        summaryPanel.add(subtotalLabel);
        summaryPanel.add(taxLabel);
        summaryPanel.add(totalLabel);

        panel.add(summaryPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
