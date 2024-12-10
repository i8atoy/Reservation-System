import java.sql.*;
import java.util.Base64;

public class Model {
    private Connection connection;

    public Model() {
        try {
            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ReservationSystem", "postgres", "loldude12");
        } catch (SQLException e) {
            System.out.println("Connection to ReservationSystem failed - critical error");
            e.printStackTrace();
        }
    }

    public User authenticate(String inputUsername, String inputPassword) {
        try {
            // SQL query to join users and user_auth tables
            String query = "SELECT u.username, u.first_name, u.last_name, u.role, ua.password, ua.salt " +
                    "FROM users u " +
                    "JOIN user_auth ua ON u.username = ua.username " +
                    "WHERE u.username = ?";

            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, inputUsername);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Retrieve data from the result set
                String username = rs.getString("username");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String role = rs.getString("role");
                String storedHash = rs.getString("password");  // The hashed password stored in the database
                String salt = rs.getString("salt");

                // Hash the input password with the salt from the database
                String hashedInputPassword = SHA256Hasher.hashPassword(inputPassword, salt);

                // Compare the hashed password entered by the user with the stored hashed password
                if (hashedInputPassword.equals(storedHash)) {
                    // If the password matches, return a new User object
                    return new User(username, firstName, lastName, role, storedHash);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return null if authentication fails
        System.out.println("Invalid username or password.");
        return null;
    }
}
