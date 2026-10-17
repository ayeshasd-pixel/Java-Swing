import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserLogin extends JFrame {

    JTextField username;
    JPasswordField password;
    JCheckBox rememberMe, notifications;

    public UserLogin() {
        setTitle("User Login");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        username = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        password = new JPasswordField();

        rememberMe = new JCheckBox("Remember Me");
        notifications = new JCheckBox("Receive Notifications");

        JButton login = new JButton("Login");

        add(userLabel);
        add(username);

        add(passLabel);
        add(password);

        add(rememberMe);
        add(notifications);

        add(new JLabel(""));
        add(login);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String user = username.getText();
                String pass = new String(password.getPassword());

                if (user.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        UserLogin.this,
                        "Please enter username and password."
                    );
                } else {
                    String message =
                        "Login Successful!\n" +
                        "Username: " + user +
                        "\nRemember Me: " + rememberMe.isSelected() +
                        "\nReceive Notifications: " + notifications.isSelected();

                    JOptionPane.showMessageDialog(
                        UserLogin.this,
                        message
                    );
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new UserLogin();
    }
}