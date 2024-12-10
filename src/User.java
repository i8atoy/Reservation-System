public class User {
    private String username;
    private String firstName;
    private String lastName;
    private String role;
    private String password;

    // Constructor
    public User(String username, String firstName, String lastName, String role, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.password = password;  // Store the hashed password (optional for display, usually not needed)
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}