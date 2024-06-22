import java.sql.*;

public class Main {
   static final String DB_URL = "jdbc:mysql://localhost:3306/ps"; //'ps' is the database name
   static final String USER = "root";  //MySQL username
   static final String PASS = "password";  //MySQL password
   static final String QUERY = "select * from employee";

   public static void main(String[] args) {
    // Use try-with-resources to ensure resources are closed
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY)) {

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("Name: " + rs.getString("name"));
                System.out.print(", City: " + rs.getString("city"));
                System.out.println(", Phone: " + rs.getString("phone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}