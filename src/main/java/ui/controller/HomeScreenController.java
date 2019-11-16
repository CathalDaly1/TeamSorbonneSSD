package ui.controller;

import ui.view.HomeScreen;
import ui.coordinator.ILoginCoordinator;

import javax.swing.*;


public class HomeScreenController extends BaseFrameController {

    private ILoginCoordinator coordinator;
    private JButton loginButton;
    private JButton registerButton;

    public HomeScreenController(ILoginCoordinator coordinator) {
        this.coordinator = coordinator;
        initComponents();
        initListeners();
    }

    private void initComponents() {
        HomeScreen homeScreen = new HomeScreen();
        frame = homeScreen;
        loginButton = homeScreen.getLoginButton();
        registerButton = homeScreen.getRegisterButton();
    }

    private void initListeners() {
        loginButton.addActionListener(e -> coordinator.goToLogin());
        registerButton.addActionListener(e -> coordinator.goToRegister());
    }
}
