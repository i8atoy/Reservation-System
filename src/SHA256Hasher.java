import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class SHA256Hasher {
    // Hash password with SHA-256 and salt
    public static String hashPassword(String password, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes()); // Add salt to the hash
        byte[] hashedBytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes); // Return base64 encoded hash
    }

    // Generate a random salt
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // 16 bytes for salt
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt); // Return base64 encoded salt
    }
}