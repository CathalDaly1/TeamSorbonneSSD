package ui.controller;

import compatibility_checker.configuration.CompatibilityResult;
import compatibility_checker.parts.Part;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.DeleteHandlerCommands.deletePcBuildCommand;
import RestAPIHandlers.Command.GetHandlerCommands.GetPartIdWithNameCommand;
import RestAPIHandlers.Command.PostHandlerCommands.InsertPcBuildCommand;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;

import users.CurrentUser;
import users.User;
import jdk.nashorn.internal.scripts.JO;
import org.restlet.resource.Post;
import ui.model.PartComboBoxModel;
import ui.view.ConfigurePCScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

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
    private JComboBox PowerSupplyComboBox;
    private String[] types = {"CPU", "GPU","Motherboard", "Ram","Cooler", "Harddrive","PowerSupply"};
    private JComboBox[] comboBoxes = new JComboBox[7];

    public ConfigurePCController() {

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
        PowerSupplyComboBox = config.getPowerSupplyComboBox();
        comboBoxes[0] = CPUComboBox;
        comboBoxes[1] = GPUComboBox;
        comboBoxes[2] = MotherboardComboBox;
        comboBoxes[3] = RAMComboBox;
        comboBoxes[4] = CoolerComboBox;
        comboBoxes[5] = HardDriveComboBox;
        comboBoxes[6] = PowerSupplyComboBox;
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

            CurrentUser currentUser = CurrentUser.getInstance();
            CompatibilityResult compatibilityResult = currentUser.updatePc();
            if(compatibilityResult.isCompatible()){
                JOptionPane.showMessageDialog(null,"PC is compatible");
                config.setVisible(false);
                AppMenuScreenController menu = new AppMenuScreenController();
                menu.controlMenu();
            }else{
                JOptionPane.showMessageDialog(null,"Unfortunately this configuration is not compatible:\n" + compatibilityResult.getMessage());
            }
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("back button");
            config.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });
    }

    private void addPartToPc(String selectedItem,String partType) {

        Command getUserWithNameCommand = new GetPartIdWithNameCommand();
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",selectedItem);
        RestParameters restParameters = new RestParameters(map);
        RestResponse response = getUserWithNameCommand.execute(restParameters);
        String pid = (String) response.getValueReturned();

        User currentUser = CurrentUser.getInstance();
        String uid = String.valueOf(currentUser.getuId());

        Command deletePcBuildCommand = new deletePcBuildCommand();
        map = new HashMap<>();
        map.put("uid",uid);
        map.put("type",partType);
        restParameters = new RestParameters(map);
        response = deletePcBuildCommand.execute(restParameters);


        Command insertPcBuildCommand = new InsertPcBuildCommand();
        map = new HashMap<>();
        map.put("uid",uid);
        map.put("pid",pid);
        map.put("type",partType);
        restParameters = new RestParameters(map);
        response = insertPcBuildCommand.execute(restParameters);
    }
}
