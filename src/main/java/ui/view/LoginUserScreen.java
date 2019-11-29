package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginUserScreen extends JFrame {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel errorLabel;
    private JButton backButton;

    public LoginUserScreen() {
        setTitle("PC Part Picker app");
        setSize(500, 500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing window");
                int x = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you wish to exit PC Part Piecer?",
                        "Exit PC Part Piecer application",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (x == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }
}
