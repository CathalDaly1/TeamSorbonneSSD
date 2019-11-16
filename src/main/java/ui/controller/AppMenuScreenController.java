package ui.controller;

import javax.swing.*;
import ui.coordinator.IAppMenuScreenCoordinator;
import ui.view.AppMenuScreen;

public class AppMenuScreenController extends BaseFrameController {
    private IAppMenuScreenCoordinator coordinator;
    private JPanel mainPanel;
    private JButton buyPartsButton;
    private JButton searchPartsButton;
    private JButton sellPartsButton;

    public AppMenuScreenController(IAppMenuScreenCoordinator coordinator) {
        this.coordinator = coordinator;
        initComponents();
        initListeners();
    }

    private void initComponents() {
        AppMenuScreen menu = new AppMenuScreen();
        frame = menu;
        buyPartsButton = menu.getBuyPartsButton();
        sellPartsButton = menu.getSellPartsButton();
        searchPartsButton = menu.getSearchPartsButton();
        
    }
    
    private void initListeners() {
        buyPartsButton.addActionListener(e -> coordinator.buyParts());
        sellPartsButton.addActionListener(e -> coordinator.sellParts());
        searchPartsButton.addActionListener(e -> coordinator.searchParts());
    }
}
