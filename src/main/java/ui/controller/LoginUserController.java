package ui.controller;
import ui.model.UserLoginModel;
import ui.view.LoginUserScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

public class LoginUserController extends BaseFrameController {

    private LoginUserScreen login;
    private JButton loginButton;
    private JButton backButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;
    UserLoginModel model;

    public LoginUserController() {

    }

    public void controlLogin() {

        login = new LoginUserScreen();
        LoginUserScreen rv = new LoginUserScreen();
        loginButton = login.getLoginButton();
        backButton = login.getBackButton();
        errorLabel = login.getErrorLabel();
        passwordField = login.getPasswordField();
        usernameField = login.getUsernameField();
        addListeners();
        login.setVisible(true);
    }

    public void addListeners() {

        loginButton.addActionListener((ActionEvent e) -> {
            System.out.println("Login user");
            login.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("back button");
            login.setVisible(false);
            HomeScreenController home = new HomeScreenController();
            home.controlStart();
        });
    }
}