package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class HomeScreen extends JFrame {
    private JButton loginButton;
    private JButton registerButton;
    private  JButton exitButton;
    private JPanel mainPanel;

    public HomeScreen() {
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
                        "Are you sure you wish to exit PC Part Piecer app?",
                        "Exit PC Part Piecer application",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (x == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
    }

    public JButton getLoginButton() { return loginButton; }

    public void setLoginButton(JButton loginButton) {
        this.loginButton=loginButton;
    }

    public JButton getRegisterButton() { return registerButton; }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton=registerButton;
    }

    public JButton getExitButton() { return exitButton; }

    public void setExitButton(JButton exitButton) {
        this.exitButton=exitButton;
    }


}