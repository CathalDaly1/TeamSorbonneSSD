package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JButton backButton;
    private JLabel errorLabel;

    public RegisterFrame() {
        setTitle("PC Part Picker app");
        setSize(500, 500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int x = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you wish to exit PC Part Picker?",
                        "Exit PC Part Picker",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (x == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
    }

    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JPasswordField getPasswordField2() {
        return passwordField2;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
