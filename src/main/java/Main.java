import ui.coordinator.ILoginCoordinator;
import ui.coordinator.LoginCoordinator;

public class Main {

    public static void main(String[] args)

    {
        ILoginCoordinator loginCoordinator = new LoginCoordinator();
        loginCoordinator.start();


    }
}
