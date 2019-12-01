package ui.controller;

import CompatibilityChecker.Parts.Part;
import RestAPIHandlers.DeleteHandler;
import RestAPIHandlers.GetHandler;
import RestAPIHandlers.PostHandler;
import Users.CurrentUser;
import Users.User;
import org.restlet.resource.Post;
import ui.model.PartComboBoxModel;
import ui.view.ConfigurePCScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ConfigurePCController extends BaseFrameController  {

    private ConfigurePCScreen config;
    private JComboBox GPUComboBox;
    private JComboBox CPUComboBox;
    private JButton backButton;
    private JButton saveButton1;
    private JComboBox CoolerComboBox;
    private JComboBox RAMComboBox;
    private JComboBox HardDriveComboBox;
    private JComboBox MotherboardComboBox;
    private String[] types = {"CPU", "GPU","Motherboard", "Ram","Cooler", "Harddrive"};
    private JComboBox[] comboBoxes = new JComboBox[6];
    private GetHandler getHandler;
    private PostHandler postHandler;
    private DeleteHandler deleteHandler;

    public ConfigurePCController() {
        getHandler = new GetHandler();
        deleteHandler = new DeleteHandler();
        postHandler = new PostHandler();
    }

    public void controlConfigurePC() {
        config = new ConfigurePCScreen();
        ConfigurePCScreen config1 = new ConfigurePCScreen();
        saveButton1 = config.getSaveButton1();
        backButton = config.getBackButton();
        GPUComboBox = config.getGPUComboBox();
        CPUComboBox = config.getCPUComboBox();
        CoolerComboBox = config.getCoolerComboBox();
        RAMComboBox = config.getRAMComboBox();
        HardDriveComboBox = config.getHardDriveComboBox();
        MotherboardComboBox = config.getMotherboardComboBox();
        comboBoxes[0] = CPUComboBox;
        comboBoxes[1] = GPUComboBox;
        comboBoxes[2] = MotherboardComboBox;
        comboBoxes[3] = RAMComboBox;
        comboBoxes[4] = CoolerComboBox;
        comboBoxes[5] = HardDriveComboBox;
        addListeners();
        config.setVisible(true);

    }

    public void addListeners() {

        saveButton1.addActionListener((ActionEvent e) -> {
            for(int i = 0;i<comboBoxes.length;i++){
                comboBoxes[i].getSelectedItem();
                if(!comboBoxes[i].getSelectedItem().equals("")){
                    addPartToPc((String)comboBoxes[i].getSelectedItem(),types[i]);
                }


            }

            config.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();

            CurrentUser currentUser = CurrentUser.getInstance();
            currentUser.updatePc();
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("back button");
            config.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });
    }

    private void addPartToPc(String selectedItem,String partType) {
        String pid = getHandler.getPartIdWithName(selectedItem);
        User currentUser = CurrentUser.getInstance();
        String uid = String.valueOf(currentUser.getuId());

        deleteHandler.deletePcBuild(uid,partType);

        postHandler.insertPcBuild(pid,uid,partType);
    }
}
