package ui.controller;
import ui.model.UserRegistrationModel;
import ui.view.RegisterUserScreen;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegisterScreenController extends BaseFrameController {

    private RegisterUserScreen reg;
    private UserRegistrationModel model;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton signUpButton;
    private JButton backButton;
    private JLabel errorLabel;

    public RegisterScreenController() {

    }

    public void controlReg() {
        reg = new RegisterUserScreen();
        RegisterUserScreen rv1 = new RegisterUserScreen();
        signUpButton = reg.getSignUpButton();
        backButton = reg.getBackButton();
        usernameField = reg.getUsernameField();
        emailField = reg.getEmailField();
        passwordField1 = reg.getPasswordField1();
        passwordField2 = reg.getPasswordField2();
        errorLabel = reg.getErrorLabel();
        addListeners();
        reg.setVisible(true);

    }

    public void addListeners() {

        signUpButton.addActionListener((ActionEvent e) -> {
            System.out.println("Login");
            reg.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("register");
            reg.setVisible(false);
            HomeScreenController home = new HomeScreenController();
            home.controlStart();
        });
    }
}
