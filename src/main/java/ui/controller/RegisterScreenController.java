package ui.controller;

import ui.coordinator.ILoginCoordinator;
import ui.coordinator.LoginCoordinator;
import ui.view.RegisterUserScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterScreenController extends BaseFrameController {

    private ILoginCoordinator coordinator;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JButton backButton;
    private JLabel errorLabel;

    public RegisterScreenController(LoginCoordinator coordinator)
    {
        this.coordinator = coordinator;
        initComponents();
        initListeners();
    }

    private void initComponents() {
        RegisterUserScreen registerScreen = new RegisterUserScreen();
        frame = registerScreen;
        usernameField = registerScreen.getUsernameField();
        emailField = registerScreen.getEmailField();
        passwordField1 = registerScreen.getPasswordField1();
        passwordField2 = registerScreen.getPasswordField2();
        signUpButton = registerScreen.getSignUpButton();
        backButton = registerScreen.getBackButton();
        errorLabel = registerScreen.getErrorLabel();
    }

    private void initListeners() {
        signUpButton.addActionListener(e -> coordinator.goToMenuScreen());
       // signUpButton.addActionListener(new SignUpButtonListener());
        backButton.addActionListener(e -> coordinator.start());
    }

    private class SignUpButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Sign up button clicked");
        }
    }
}
