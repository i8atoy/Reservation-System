import javax.swing.*;

public class MemberView extends JFrame {
    public MemberView() {
        setTitle("Member Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("Welcome Member!", SwingConstants.CENTER);
        add(label);
    }
}