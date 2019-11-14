package ui.controller;
import ui.view.LoginFrame;

import javax.swing.*;


public class LoginFrameController {

    private JButton loginButton, backButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;

    public LoginFrameController() {
        initComponents();
    }

    private void initComponents() {
        LoginFrame loginFrame = new LoginFrame();
        loginButton = loginFrame.getLoginButton();
        backButton = loginFrame.getBackButton();
        usernameField = loginFrame.getUsernameField();
        passwordField = loginFrame.getPasswordField();
        errorLabel = loginFrame.getErrorLabel();
    }
}
