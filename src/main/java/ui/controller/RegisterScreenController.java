package ui.controller;

import ui.coordinator.LoginCoordinator;
import ui.view.RegisterUserScreen;

import javax.swing.*;

public class RegisterScreenController {

    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JButton backButton;
    private JLabel errorLabel;

    public RegisterScreenController(LoginCoordinator loginCoordinator) {
        initComponents();
    }

    private void initComponents() {
        RegisterUserScreen registerUserScreen = new RegisterUserScreen();
        usernameField = registerUserScreen.getUsernameField();
        emailField = registerUserScreen.getEmailField();
        passwordField1 = registerUserScreen.getPasswordField1();
        passwordField2 = registerUserScreen.getPasswordField2();
        signUpButton = registerUserScreen.getSignUpButton();
        backButton = registerUserScreen.getBackButton();
        errorLabel = registerUserScreen.getErrorLabel();

    }
}
