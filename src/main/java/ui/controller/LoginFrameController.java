package ui.controller;
import ui.view.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

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
