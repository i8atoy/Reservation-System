import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        this.view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = view.getUsername();
        String password = view.getPassword();

        User user = model.authenticate(username, password);

        if (user != null) {
            view.setMessage("Login successful! Welcome " + user.getRole());
            openMenu(user.getRole());
        } else {
            view.setMessage("Wrong username or password");
        }
    }

    private void openMenu(String role) {
        view.dispose(); // Close the login window

        if (role.equalsIgnoreCase("Admin")) {
            new AdminView().setVisible(true);
        } else if (role.equalsIgnoreCase("Member")) {
            new MemberView().setVisible(true);
        }
    }
}