package ui.coordinator;

import ui.controller.LoginUserController;
import ui.controller.HomeScreenController;

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

    @Override
    public void goToRegister() {
        System.out.println("Register Button Pressed - Implement");
    }

    @Override
    public void goToMainMenu() {
        System.out.print("Main Menu Page Displayed - Implement");
    }
}
