package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SearchPCPartsScreen extends JFrame {
    private JButton searchPCPartsButton;
    private JButton backButton;
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JComboBox partType;
    private String[] types = {"CPU", "GPU","Motherboard", "Ram","Cooler", "Harddrive","PowerSupply"};


    public SearchPCPartsScreen() {
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
                        "Are you sure you wish to PC Parts search?",
                        "Exit PC Part Piecer application",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (x == JOptionPane.YES_OPTION)
                   System.exit(0);

            }
        });

        populatePartComboBoxs();
    }


    private void populatePartComboBoxs() {
        for(int i = 0;i <types.length;i++){
            partType.addItem(types[i]);
        }
    }


    public JButton getSearchPCPartsButton() {
        return searchPCPartsButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JComboBox getPartType() { return partType; }

}
