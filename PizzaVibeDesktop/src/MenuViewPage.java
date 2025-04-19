import javax.swing.*;
import java.awt.*;

public class MenuViewPage extends JFrame {
    public MenuViewPage() {
        setTitle("PizzaVibe Menu");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Our Delicious Pizzas", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Pizzas Section
        JPanel productPanel = new JPanel(new GridLayout(1, 3, 20, 10));
        productPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        productPanel.add(createPizzaCard("Pepperoni Feast", "pepPizza.jpg", "$14.99"));
        productPanel.add(createPizzaCard("Margherita Classic", "margPizza.jpg", "$12.99"));
        productPanel.add(createPizzaCard("Buffalo Chicken", "buffPizza.jpg", "$16.99"));

        mainPanel.add(productPanel);

        // Beverages Section Title
        JLabel drinkLabel = new JLabel("Beverages", SwingConstants.CENTER);
        drinkLabel.setFont(new Font("Arial", Font.BOLD, 18));
        drinkLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
        mainPanel.add(drinkLabel);

        // Beverage Cards
        JPanel beveragePanel = new JPanel(new GridLayout(1, 5, 15, 10));
        beveragePanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        beveragePanel.add(createBeverageCard("Coke"));
        beveragePanel.add(createBeverageCard("Sprite"));
        beveragePanel.add(createBeverageCard("Fanta"));
        beveragePanel.add(createBeverageCard("Water"));
        beveragePanel.add(createBeverageCard("Lemonade"));

        mainPanel.add(beveragePanel);

        add(new JScrollPane(mainPanel), BorderLayout.CENTER);

        // View Cart button at bottom
        JButton viewCartButton = new JButton("View Cart");
        viewCartButton.addActionListener(e -> CartPage.showCartPage());
        add(viewCartButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createPizzaCard(String name, String imageFile, String basePrice) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        ImageIcon image = new ImageIcon("src/images/" + imageFile);
        Image scaled = image.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaled));

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel priceLabel = new JLabel("Base Price: " + basePrice, SwingConstants.CENTER);

        String[] sizes = {"Small", "Medium", "Large", "Extra Large"};
        JComboBox<String> sizeBox = new JComboBox<>(sizes);

        String[] crusts = {"Thin", "Thick", "Stuffed"};
        JComboBox<String> crustBox = new JComboBox<>(crusts);

        JPanel toppingsPanel = new JPanel(new GridLayout(4, 2));
        String[] toppings = {"Pepperoni", "Mushrooms", "Onions", "Olives", "Green Peppers", "Bacon", "Spinach", "Sausage"};
        JCheckBox[] toppingChecks = new JCheckBox[toppings.length];
        for (int i = 0; i < toppings.length; i++) {
            toppingChecks[i] = new JCheckBox(toppings[i]);
            toppingsPanel.add(toppingChecks[i]);
        }

        JButton addBtn = new JButton("Add to Cart");
        addBtn.addActionListener(e -> {
            String size = (String) sizeBox.getSelectedItem();
            String crust = (String) crustBox.getSelectedItem();

            StringBuilder selectedToppings = new StringBuilder();
            int toppingCount = 0;
            for (JCheckBox checkBox : toppingChecks) {
                if (checkBox.isSelected()) {
                    if (toppingCount >= 4) break;
                    selectedToppings.append(checkBox.getText()).append(", ");
                    toppingCount++;
                }
            }

            String itemDescription = name + " | Size: " + size + " | Crust: " + crust;
            if (selectedToppings.length() > 0) {
                itemDescription += " | Toppings: " + selectedToppings.substring(0, selectedToppings.length() - 2);
            }

            SharedCart.addItem(itemDescription + " | Price: " + basePrice);
            JOptionPane.showMessageDialog(null, name + " customized and added to cart!");
        });

        card.add(imageLabel);
        card.add(nameLabel);
        card.add(priceLabel);
        card.add(sizeBox);
        card.add(crustBox);
        card.add(toppingsPanel);
        card.add(addBtn);

        return card;
    }

    private JPanel createBeverageCard(String name) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JLabel nameLabel = new JLabel(name, SwingConstants.CENTER);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        String[] sizes = {"Small", "Medium", "Large"};
        JComboBox<String> sizeBox = new JComboBox<>(sizes);

        JButton addBtn = new JButton("Add to Cart");
        addBtn.addActionListener(e -> {
            String size = (String) sizeBox.getSelectedItem();
            double base = 1.00;
            double price = switch (size) {
                case "Small" -> base;
                case "Medium" -> base + 0.50;
                case "Large" -> base + 1.00;
                default -> base;
            };

            String description = name + " (" + size + ") | Price: $" + String.format("%.2f", price);
            SharedCart.addItem(description);
            JOptionPane.showMessageDialog(null, name + " added to cart!");
        });

        card.add(Box.createVerticalStrut(10));
        card.add(nameLabel);
        card.add(sizeBox);
        card.add(addBtn);

        return card;
    }
}
