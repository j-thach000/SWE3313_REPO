import java.util.ArrayList;
import java.util.List;

public class SharedCart {
    private static final List<String> items = new ArrayList<>();

    public static void addItem(String item) {
        items.add(item);
    }

    public static List<String> getItems() {
        return new ArrayList<>(items);
    }

    public static void clearCart() {
        items.clear();
    }
}