import javax.swing.*;

public class AdminView extends JFrame {
    public AdminView() {
        setTitle("Admin Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Welcome Admin!", SwingConstants.CENTER);
        add(label);
    }
}
