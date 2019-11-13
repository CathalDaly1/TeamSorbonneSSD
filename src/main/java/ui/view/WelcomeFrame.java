package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WelcomeFrame extends JFrame {
    private JButton loginButton;
    private JButton registerButton;
    private JLabel titleLabel;
    private JPanel mainPanel;

    public WelcomeFrame() {
        setTitle("PC Part Picker");
        setSize(500, 500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int x = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you wish to exit PC Part Picker application?",
                        "Exit PC Part Picker application",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (x == JOptionPane.YES_OPTION)
                   System.exit(0);

            }
        });
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }
}
