package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BuyPCParts extends JFrame {
    private JButton BuyPCPartsButton;
    private JButton backButton;
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public BuyPCParts() {
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
                        "Exit PC Part Search",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE
                );

                if (x == JOptionPane.YES_OPTION)
                   System.exit(0);

            }
        });
    }

    public JButton getBuyPCPartsButton() {
        return BuyPCPartsButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
