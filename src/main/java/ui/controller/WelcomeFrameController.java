package ui.controller;

import ui.view.WelcomeFrame;

import javax.swing.*;

public class WelcomeFrameController {

    private JButton loginButton;
    private JButton registerButton;

    public WelcomeFrameController() {
        initComponents();
    }

    private void initComponents() {
        WelcomeFrame welcomeFrame = new WelcomeFrame();
        loginButton = welcomeFrame.getLoginButton();
        registerButton = welcomeFrame.getRegisterButton();
        System.out.println("test method now");
    }
}
