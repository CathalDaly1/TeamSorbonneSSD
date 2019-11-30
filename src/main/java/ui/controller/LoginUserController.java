package ui.controller;
import RestAPIHandlers.GetHandler;
import Users.User;
import ui.model.UserLoginModel;
import ui.view.LoginUserScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginUserController extends BaseFrameController {

    private LoginUserScreen login;
    private JButton loginButton;
    private JButton backButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;
    private UserLoginModel model ;
    private GetHandler getHandler;

    public LoginUserController() {
        model = new UserLoginModel();
        getHandler = new GetHandler();
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
            model.setPassword(passwordField.getText());
            model.setUsername(usernameField.getText());

            if(login()){
                login.setVisible(false);
                AppMenuScreenController menu = new AppMenuScreenController();
                menu.controlMenu();
            } else {
                JOptionPane.showMessageDialog(null,"Incorrect login details. Try again.");
            }
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("back button");
            login.setVisible(false);
            HomeScreenController home = new HomeScreenController();
            home.controlStart();
        });
    }

    private boolean login() {
        String username = model.getUsername();
        String password = model.getPassword();

        User user = getHandler.getUserWithName(username);

        if(user == null){
            return false;
        }

        System.out.println(password);
        System.out.println(user.getPassword());
        if(user.getPassword().equals(password)){
            System.out.print("correct password");
            return true;
        }
        System.out.println("incorrect password ");
        return false;
    }
}