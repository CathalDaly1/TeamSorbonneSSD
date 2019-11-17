package ui.controller;

import javax.swing.*;
import ui.coordinator.IAppMenuScreenCoordinator;
import ui.view.AppMenuScreen;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMenuScreenController extends BaseFrameController {
    private IAppMenuScreenCoordinator coordinator;
    private JPanel mainPanel;
    private JButton buyPartsButton;
    private JButton searchPartsButton;
    private JButton sellPartsButton;
    private JButton exitApplicationButton;
    private JButton logoutButton;

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
        exitApplicationButton = menu.getExitApplicationButton();
        logoutButton = menu.getLogoutButton();
    }
    
    private void initListeners() {
        buyPartsButton.addActionListener(e -> coordinator.buyParts());
        sellPartsButton.addActionListener(e -> coordinator.sellParts());
        searchPartsButton.addActionListener(e -> coordinator.searchParts());
        exitApplicationButton.addActionListener(e -> coordinator.exitApplication());
        logoutButton.addActionListener(e-> coordinator.logoutUser());
    }

    private class SearchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("PC Parts Search Button");

        }
    }
}