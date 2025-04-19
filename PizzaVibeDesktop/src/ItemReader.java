import java.sql.*;

public class ItemReader {
    public static void main(String[] args) {
        String query = "SELECT * FROM Items";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("ItemID");
                String name = rs.getString("Item_Name");
                String price = rs.getString("Price");

                System.out.println(id + " | " + name + " | $" + price);
            }

        } catch (SQLException e) {
            System.out.println("DB read failed: " + e.getMessage());
        }
    }
}
