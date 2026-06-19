 import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/expense_tracker","root","24112005"
            );
            System.out.println("Database connected successfully");

        } catch (Exception e) {
            System.out.println("Database Error: " + e);
        }

        return con;
    }
} 
}
