import CompatibilityChecker.Case;
import CompatibilityChecker.Cpu;
import ui.coordinator.ILoginCoordinator;
import ui.coordinator.LoginCoordinator;

public class Main {

    public static void main(String[] args)

    {
        //Start Screen with Login and Registration options
        ILoginCoordinator loginCoordinator = new LoginCoordinator();
        loginCoordinator.start();

        Case caseObj = new Case("Case");

        caseObj.add(new Cpu("cpu"));

    }
}
