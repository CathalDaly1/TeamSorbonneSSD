package ui.controller;
import RestAPIHandlers.PostHandler;
import Users.User;
import Users.UserFactory;
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
    private UserFactory userFactory;
    private PostHandler postHandler;

    public RegisterScreenController() {
        model = new UserRegistrationModel();
        userFactory = new UserFactory();
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
        return (postHandler.insertUser(userFactory.addNewUser(0,model.getUsername(),model.getemail(),model.getPassword(),false)));
    }
}
