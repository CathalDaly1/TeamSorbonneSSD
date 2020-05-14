package ui.controller;
import rest_api_handlers.PostHandler;
import ui.model.UserRegistrationModel;
import ui.view.RegisterUserScreen;
import users.isPremium;

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
    private JCheckBox premiumUser;
    private PostHandler postHandler;
    private isPremium typeOfUser;

    public RegisterScreenController() {
        model = new UserRegistrationModel();
        typeOfUser = new isPremium();
        postHandler = new PostHandler();
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
        premiumUser = reg.getPremiumUser();
        errorLabel = reg.getErrorLabel();
        addListeners();
        reg.setVisible(true);

    }

    public void addListeners() {

        signUpButton.addActionListener((ActionEvent e) -> {
            model.setPassword(passwordField1.getText(),passwordField2.getText());
            model.setUsername(usernameField.getText());
            model.setEmail(emailField.getText());

            if(register()){
                reg.setVisible(false);
                AppMenuScreenController menu = new AppMenuScreenController();
                menu.controlMenu();
            }
            else {
                JOptionPane.showMessageDialog(null, "Sorry the register failed. Try again.");
            }
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("register");
            reg.setVisible(false);
            HomeScreenController home = new HomeScreenController();
            home.controlStart();
        });
    }

    private boolean register() {
        if (premiumUser.isSelected() == false) {
            return (postHandler.insertUser(typeOfUser.addNewUser(0, model.getUsername(), model.getemail(), model.getPassword(), false)));
        } else{
            return (postHandler.insertUser(typeOfUser.addNewUser(0, model.getUsername(), model.getemail(), model.getPassword(), true)));
        }
    }
}
