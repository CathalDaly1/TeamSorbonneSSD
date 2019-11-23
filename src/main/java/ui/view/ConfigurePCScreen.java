package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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


    public ConfigurePCScreen() {
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

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getSaveButton1() {
        return saveButton1;
    }
}
