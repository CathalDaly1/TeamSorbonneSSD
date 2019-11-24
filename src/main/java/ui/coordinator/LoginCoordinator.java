package ui.coordinator;
import ui.controller.HomeScreenController;
import ui.controller.LoginUserController;
import ui.controller.RegisterScreenController;

public class LoginCoordinator extends BaseCoordinator implements ILoginCoordinator {

   public void start() {

        HomeScreenController welcome = new HomeScreenController(this);
        setFrameController(welcome);
    }

    public void goToLogin() {

        LoginUserController login = new LoginUserController(this);
        setFrameController(login);
    }

    public void goToRegister() {

        RegisterScreenController register = new RegisterScreenController(this);
        setFrameController(register);
    }

    public void goToMenuScreen() {

        IAppMenuScreenCoordinator menu = new AppMenuScreenCoordinator();
        menu.start();
        setFrameController(null);
    }

    public void closeApplication() { System.exit(0); }
}
