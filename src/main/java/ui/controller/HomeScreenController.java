package ui.controller;
import ui.view.HomeScreen;
import ui.view.LoginUserScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class HomeScreenController extends BaseFrameController {

    private HomeScreen home;
    private JButton loginButton;
    private JButton registerButton;
    private JButton exitButton;

    public void controlStart() {

        home = new HomeScreen();
        LoginUserScreen rv = new LoginUserScreen();
        loginButton = home.getLoginButton();
        registerButton = home.getRegisterButton();
        exitButton = home.getExitButton();
        addListeners();
        home.setVisible(true);
    }

    public  void addListeners() {

        loginButton.addActionListener((ActionEvent e) -> {
            System.out.println("Login");
            home.setVisible(false);
            LoginUserController login = new LoginUserController();
            login.controlLogin();
        });

        registerButton.addActionListener((ActionEvent e) -> {
            System.out.println("register");
            home.setVisible(false);
            RegisterScreenController register = new RegisterScreenController();
            register.controlReg();
        });

        exitButton.addActionListener((ActionEvent e) -> {
            System.out.println("exit");
            System.exit(0);
        });
    }

}