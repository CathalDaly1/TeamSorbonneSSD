import ui.controller.HomeScreenController;
import ui.coordinator.ILoginCoordinator;
import ui.coordinator.LoginCoordinator;
import ui.view.HomeScreen;

public class Main {

    public static void main(String[] args) {

       //ILoginCoordinator loginCoordinator = new LoginCoordinator();
       //loginCoordinator.start();

        HomeScreenController controller = new HomeScreenController();
        controller.controlStart();
    }
}
