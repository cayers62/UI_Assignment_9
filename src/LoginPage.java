import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("User Authentication Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.MAGENTA); // Set background color to purple

        // Set an image to the title bar
        ImageIcon icon = new ImageIcon("\\UI_Assignment_9\\userauth.jpg");
        frame.setIconImage(icon.getImage());

        // Font for text components
        Font textFont = new Font("Times New Roman", Font.PLAIN, 12);

        // Username label and text field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 100, 25);
        frame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(150, 50, 180, 25);
        frame.add(usernameField);

        // Password label and password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 90, 100, 25);
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 90, 180, 25);
        frame.add(passwordField);

        // Checkbox for "Remember Me" feature
        JCheckBox rememberMeCheckBox = new JCheckBox("Remember Me");
        rememberMeCheckBox.setBounds(150, 130, 150, 25);
        frame.add(rememberMeCheckBox);

        // Login button
        JButton loginButton = new JButton("Log In");
        loginButton.setBounds(150, 170, 100, 30);
        frame.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(150, 220, 250, 25);
        frame.add(messageLabel);

        // Stored credentials in arrays
        String[] usernames = {"user1", "admin"};
        String[] passwords = {"pass123", "adminpass"};

        // Add ActionListener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                boolean authenticated = false;

                // Empty field validation
                if (username.isEmpty() || password.isEmpty()) {
                    messageLabel.setText("Fields cannot be empty!");
                    messageLabel.setForeground(Color.ORANGE);
                    return;
                }
                // Check credentials
                for (int i = 0; i < usernames.length; i++) {
                    if (username.equals(usernames[i]) && password.equals(passwords[i])) {
                        authenticated = true;
                        break;
                    }
                }
                // Update JLabel based on authentication result
                if (authenticated) {
                    messageLabel.setText("Successfully logged in!");
                    messageLabel.setForeground(Color.GREEN);
                } else {
                    messageLabel.setText("Incorrect username/password.");
                    messageLabel.setForeground(Color.WHITE);}
            }
        });

        // Finalize frame
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
