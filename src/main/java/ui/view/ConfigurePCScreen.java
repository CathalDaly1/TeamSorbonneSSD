package ui.view;

import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.GetHandlerCommands.GetPartNamesWithTypeCommand;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import RestAPIHandlers.GetHandler;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ConfigurePCScreen extends JFrame {
    private JPanel mainPanel;
    private JComboBox CPUComboBox;
    private JComboBox GPUComboBox;
    private JButton backButton;
    private JButton saveButton1;
    private JComboBox CoolerComboBox;
    private JComboBox RAMComboBox;
    private JComboBox HardDriveComboBox;
    private JComboBox MotherboardComboBox;
    private JComboBox PowerSupplyComboBox;
    private GetHandler getHandler;
    private String[] types = {"CPU", "GPU","Motherboard", "Ram","Cooler", "Harddrive","PowerSupply"};
    private JComboBox[] comboBoxes =  {CPUComboBox,GPUComboBox,MotherboardComboBox,RAMComboBox, CoolerComboBox,HardDriveComboBox, PowerSupplyComboBox};

    public ConfigurePCScreen() {
        getHandler = new GetHandler();
        setTitle("PC Part Picker");
        setSize(500, 500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int x = JOptionPane.showConfirmDialog(
                        null,
                        "You are currently in the process of configuring your PC.\nAre you sure you wish to exit PC Part Picker? Any changes will be lost.",
                        "Exit PC Part Picker",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (x == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });

        populatePartComboBoxs();
    }

    private void populatePartComboBoxs() {
        for(int i = 0;i <types.length;i++){
            Command getPartNamesWithTypeCommand = new GetPartNamesWithTypeCommand();
            HashMap<String,Object> map = new HashMap<>();
            map.put("type",types[i]);
            RestParameters restParameters = new RestParameters(map);
            RestResponse response = getPartNamesWithTypeCommand.execute(restParameters);
            List<String> names = (List<String>) response.getValueReturned();

            for(int j = 0;j < names.size();j++){
                if(j == 0){
                    comboBoxes[i].addItem("");
                }
                comboBoxes[i].addItem(names.get(j));
            }
        }
    }

    public JComboBox getCPUComboBox() {
        return CPUComboBox;
    }

    public JComboBox getGPUComboBox() {
        return GPUComboBox;
    }

    public JComboBox getCoolerComboBox() {
        return CoolerComboBox;
    }

    public JComboBox getMotherboardComboBox() {
        return MotherboardComboBox;
    }

    public JComboBox getRAMComboBox() {
        return RAMComboBox;
    }

    public JComboBox getHardDriveComboBox() {
        return HardDriveComboBox;
    }

    public JComboBox getPowerSupplyComboBox() {
        return PowerSupplyComboBox;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getSaveButton1() {
        return saveButton1;
    }
}
