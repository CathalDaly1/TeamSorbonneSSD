package ui.coordinator;

import ui.controller.HomeScreenController;
import ui.controller.LoginUserController;
import ui.controller.RegisterScreenController;

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

    public void goToMenuScreen() {
        IAppMenuScreenCoordinator menu = new AppMenuScreenCoordinator();
        menu.start();
        System.out.print("Main Menu Page Displayed - CHECK\n");
        setViewController(null);
    }

    public void closeApplication() {
        System.exit(0);
    }
}
