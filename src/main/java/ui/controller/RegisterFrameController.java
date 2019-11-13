package ui.controller;

import ui.view.RegisterFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

public class RegisterFrameController  {

    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JButton backButton;
    private JLabel errorLabel;

    public RegisterFrameController() {
        initComponents();

    }

    private void initComponents() {
        RegisterFrame registerFrame = new RegisterFrame();
        usernameField = registerFrame.getUsernameField();
        emailField = registerFrame.getEmailField();
        passwordField1 = registerFrame.getPasswordField1();
        passwordField2 = registerFrame.getPasswordField2();
        signUpButton = registerFrame.getSignUpButton();
        backButton = registerFrame.getBackButton();
        errorLabel = registerFrame.getErrorLabel();
    }
}
