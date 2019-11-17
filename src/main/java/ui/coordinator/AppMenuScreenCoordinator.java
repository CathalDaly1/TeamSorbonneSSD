package ui.coordinator;
import ui.controller.AppMenuScreenController;
import ui.controller.SearchPartsController;

import javax.swing.*;

public class AppMenuScreenCoordinator extends BaseCoordinator implements IAppMenuScreenCoordinator {

    @Override
    public void start() {
        AppMenuScreenController mainMenu = new AppMenuScreenController(this);
        setViewController(mainMenu);
    }

    @Override
    public void buyParts() {
        System.out.println("Buy Parts Button Clicked - Implement");
    }

    @Override
    public void sellParts() {
        System.out.println("Sell Parts Button Clicked - Implement");
    }

    @Override
    public void searchParts() {
        System.out.println("Search parts button clicked - IMPLEMENT");
        System.out.println("Need to fix this");
        SearchPartsController searchParts = new SearchPartsController(this);
        setViewController(searchParts);
    }

    @Override
    public void logoutUser() {
        int userLogout = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to logout of PC Part Picker?",
                "Logout", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (userLogout == JOptionPane.YES_NO_OPTION) {
            System.out.println("USER LOGOUT - Implement");
            System.exit(0);
        }
    }

    @Override
    public void exitApplication() {
        System.out.println("Exiting application");
        System.exit(0);
    }

    @Override
    public void searchForParts() {
        System.out.println("Search for parts button pressed");
    }
}
