package ui.controller;
import ui.coordinator.ILoginCoordinator;

import ui.view.LoginUserScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUserController extends BaseFrameController {
    private ILoginCoordinator coordinator;
    private JButton loginButton, backButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;

    public LoginUserController(ILoginCoordinator coordinator) {
        this.coordinator = coordinator;
        initComponents();
        initListeners();
    }

    private void initComponents() {
        LoginUserScreen loginUserScreen = new LoginUserScreen();
        frame = loginUserScreen;
        loginButton = loginUserScreen.getLoginButton();
        backButton = loginUserScreen.getBackButton();
        usernameField = loginUserScreen.getUsernameField();
        passwordField = loginUserScreen.getPasswordField();
        errorLabel = loginUserScreen.getErrorLabel();
    }

    private void initListeners() {
        loginButton.addActionListener(new LoginButtonListener());
        backButton.addActionListener(e -> coordinator.start());
    }

    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            System.out.println("Test now now now");

        }
    }
}
