package ui.view;

import RestAPIHandlers.GetHandler;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class SellPCParts extends JFrame {
    private JButton placeAdvert;
    private JButton backButton;
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JComboBox partType;
    private JTextField advertPrice;
    private JTextField advertName;
    private JLabel advertImage;
    private JLabel price1;
    private JLabel advertName1;
    private JComboBox nameComboBox;
    private GetHandler getHandler;

    public SellPCParts() {
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
                        "Are you sure you wish to PC Parts application?",
                        "Exit PC Part Picker application",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (x == JOptionPane.YES_OPTION)
                   System.exit(0);

            }
        });

        populateComboBox();
    }

    private void populateComboBox() {
        List<String> names = getHandler.getAllParts();
        for(int j = 0;j < names.size();j++){
            if(j == 0){
                nameComboBox.addItem("");
            }
            nameComboBox.addItem(names.get(j));
        }
    }

    public JButton getPlaceAdvert() {
        return placeAdvert;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JComboBox getPartName () { return nameComboBox;}

    public JComboBox getPartType () { return partType;}

    public JTextField getAdvertPrice() { return advertPrice;}

    public JLabel getAdvertImage () { return advertImage; }

}
