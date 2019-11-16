package ui.coordinator;

import ui.controller.LoginUserController;
import ui.controller.HomeScreenController;
import ui.controller.RegisterScreenController;
import ui.view.HomeScreen;

public class LoginCoordinator extends BaseCoordinator implements ILoginCoordinator {

    public void start() {
        HomeScreenController welcome = new HomeScreenController(this);
        System.out.println("Home Page Displayed - CHECK");
        setViewController(welcome);
    }

    public void goToLogin() {
        LoginUserController login = new LoginUserController(this);
        System.out.println("Login Button Pressed - CHECK");
        setViewController(login);
    }

    public void goToRegister() {
        RegisterScreenController register = new RegisterScreenController(this);
        System.out.println("Register Button Pressed - CHECK");
        setViewController(register);
    }

    public void goToMainMenu() {
        System.out.print("Main Menu Page Displayed - Implement next");
    }

    public void closeApplication() {
        System.exit(0);
    }
}
