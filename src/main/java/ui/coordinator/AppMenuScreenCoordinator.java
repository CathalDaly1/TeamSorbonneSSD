package ui.coordinator;
import ui.controller.AppMenuScreenController;
import ui.controller.SellPartsController;
import ui.controller.SearchPartsController;

import javax.swing.*;

public class AppMenuScreenCoordinator extends BaseCoordinator implements IAppMenuScreenCoordinator {

    @Override
    public void start() {
        AppMenuScreenController mainMenu = new AppMenuScreenController(this);
        setFrameController(mainMenu);
    }

    @Override
    public void sellParts() {
        SellPartsController sellParts = new SellPartsController(this);
        setFrameController(sellParts);
    }

    @Override
    public void placeAdvert() {

        System.out.println("Place Advert button pressed");
    }

    @Override
    public void searchParts() {
        SearchPartsController searchParts = new SearchPartsController(this);
        setFrameController(searchParts);
    }

    @Override
    public void searchForParts() {
        System.out.println("Search for parts button pressed");
    }

    @Override
    public void logoutUser() {
        int userLogout = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to logout of PC Part Piecer?",
                "Logout", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (userLogout == JOptionPane.YES_NO_OPTION) {
            System.out.println("USER LOGOUT - Implement");
        }
    }

    @Override
    public void exitApplication() {
        System.out.println("Exiting application");
        System.exit(0);
    }
}
