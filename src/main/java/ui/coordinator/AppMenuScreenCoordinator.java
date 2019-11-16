package ui.coordinator;
import ui.controller.AppMenuScreenController;


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
        System.out.println("Search Parts Button Clicked - Implement");
    }

}
