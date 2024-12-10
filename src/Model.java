import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Base64;


public class Model {
    private Connection connection;

    public Model() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ReservationSystem", "postgres", "loldude12");
        } catch (SQLException e) {
            System.out.println("Connection to ReservationSystem failed - critical error");
            e.printStackTrace();
        }
    }

    public User authenticate(String inputUsername, String inputPassword) {
        try {
            // Fetch user details by username
            String query = "SELECT username, password, salt, role FROM users WHERE username = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, inputUsername);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String storedHash = rs.getString("password");
                String salt = rs.getString("salt");
                String role = rs.getString("role");

                // Hash the input password with the stored salt
                String hashedInputPassword = SHA256Hasher.hashPassword(inputPassword, salt);

                // Verify if the hashed input password matches the stored hash
                if (hashedInputPassword.equals(storedHash)) {
                    return new User(username, storedHash, role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Invalid username or password - critical error");
        return null;
    }
}
