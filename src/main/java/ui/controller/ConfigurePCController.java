package ui.controller;

import ui.view.ConfigurePCScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigurePCController extends BaseFrameController {

    private ConfigurePCScreen config;
    private JComboBox GPUComboBox;
    private JButton backButton;
    private JButton saveButton1;
    private JComboBox CoolerComboBox;
    private JComboBox RAMComboBox;
    private JComboBox HardDriveComboBox;
    private JComboBox MotherboardComboBox;

    public ConfigurePCController() {

    }

    public void controlConfigurePC() {
        config = new ConfigurePCScreen();
        ConfigurePCScreen config1 = new ConfigurePCScreen();
        saveButton1 = config.getSaveButton1();
        backButton = config.getBackButton();
        GPUComboBox = config.getGPUComboBox();
        CoolerComboBox = config.getCoolerComboBox();
        RAMComboBox = config.getRAMComboBox();
        HardDriveComboBox = config.getHardDriveComboBox();
        MotherboardComboBox = config.getMotherboardComboBox();
        addListeners();
        config.setVisible(true);
    }

    public void addListeners() {

        saveButton1.addActionListener((ActionEvent e) -> {
            System.out.println("Save configuration");
            config.setVisible(false);
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("back button");
            config.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });
    }
}
