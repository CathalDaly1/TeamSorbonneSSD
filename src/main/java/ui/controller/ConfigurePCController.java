package ui.controller;

import ui.coordinator.IAppMenuScreenCoordinator;
import ui.view.ConfigurePCScreen;

import javax.swing.*;

public class ConfigurePCController extends BaseFrameController {

    private IAppMenuScreenCoordinator coordinator;
    private JButton backButton;
    private JButton saveButton1;

    public ConfigurePCController(IAppMenuScreenCoordinator coordinator) {
        this.coordinator = coordinator;
        initialiseFrameComponents();
        initialiseFrameListeners();
    }

    private void initialiseFrameComponents() {
        ConfigurePCScreen configure = new ConfigurePCScreen();
        frame = configure;
        backButton = configure.getBackButton();
        saveButton1 = configure.getSaveButton1();
    }

    private void initialiseFrameListeners() {
        backButton.addActionListener(e -> coordinator.start());
        //saveButton1.addActionListener(e -> coordinator.saveButton1());
    }
}
