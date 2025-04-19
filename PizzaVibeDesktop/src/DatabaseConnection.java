import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:C:/Users/biswa/Desktop/SWE/PizzaVibeDesktop/database/PizzaDB.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected to SQLite successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        connect();
    }
}
