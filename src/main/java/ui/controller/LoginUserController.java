package ui.controller;
import ui.coordinator.ILoginCoordinator;

import ui.model.UserLoginModel;
import ui.view.LoginUserScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidParameterException;

public class LoginUserController extends BaseFrameController {

    private ILoginCoordinator coordinator;
    private JButton loginButton;
    private JButton backButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;
    UserLoginModel model;

    public LoginUserController(ILoginCoordinator coordinator) {
        this.coordinator = coordinator;
        initialiseFrameComponents();
        initialiseFrameListeners();
    }

    private void initialiseFrameComponents() {
        LoginUserScreen loginUserScreen = new LoginUserScreen();
        frame = loginUserScreen;
        loginButton = loginUserScreen.getLoginButton();
        backButton = loginUserScreen.getBackButton();
        usernameField = loginUserScreen.getUsernameField();
        passwordField = loginUserScreen.getPasswordField();
        errorLabel = loginUserScreen.getErrorLabel();
    }

    private void initialiseFrameListeners() {
        //loginButton.addActionListener(new LoginButtonListener());
        loginButton.addActionListener(e -> coordinator.goToMenuScreen());
        backButton.addActionListener(e -> coordinator.start());
    }

    private class LoginButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                model.setUsername(usernameField.getText());
                model.setPassword(passwordField.getText());
                if(model.login())
                    coordinator.goToMainMenu();
                else
                    errorLabel.setText("Invalid username or password");
            } catch (InvalidParameterException exception) {
                errorLabel.setText(exception.getMessage());
            }
        }
    }
}
