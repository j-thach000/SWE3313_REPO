import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemInserter {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.connect();

        if (conn != null) {
            String insertSQL = "INSERT INTO Items (ItemID, Item_Name, ImageFile, Price, Default_Amount) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

                // First item
                pstmt.setInt(1, 1);
                pstmt.setString(2, "Pepperoni Feast");
                pstmt.setString(3, "pepPizza.jpg");
                pstmt.setDouble(4, 14.99);
                pstmt.setInt(5, 1);
                pstmt.executeUpdate();

                // Second item
                pstmt.setInt(1, 2);
                pstmt.setString(2, "Margherita Classic");
                pstmt.setString(3, "margPizza.jpg");
                pstmt.setDouble(4, 12.99);
                pstmt.setInt(5, 1);
                pstmt.executeUpdate();

                // Third item
                pstmt.setInt(1, 3);
                pstmt.setString(2, "Buffalo Chicken");
                pstmt.setString(3, "buffPizza.jpg");
                pstmt.setDouble(4, 16.99);
                pstmt.setInt(5, 1);
                pstmt.executeUpdate();

                System.out.println("Pizza items inserted successfully!");
            } catch (SQLException e) {
                System.out.println("Insert failed: " + e.getMessage());
            }
        }
    }
}
