package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AppMenuScreen extends JFrame {
    private JPanel mainPanel;
    private JButton searchPartsButton;
    private JButton sellPartsButton;
    private JButton logoutButton;
    private JButton configurePCButton;
    private JButton viewTransactionsButton;
    private JButton warehouseButton;



    public AppMenuScreen() {
        setTitle("PC Part Picker app");
        setSize(500, 500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int x = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you wish to exit PC Part Piecer?",
                        "Exit PC Part Piecer application",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (x == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });


    }

    public JButton getSearchPartsButton() {
        return searchPartsButton;
    }

    public JButton getSellPartsButton() {
        return sellPartsButton;
    }

    public JButton getLogoutButton() { return  logoutButton; }

    public JButton getConfigurePCButton() { return configurePCButton; }

    public JButton getWarehouseButton() { return warehouseButton; }

    public JButton getViewTransactionsButton() { return viewTransactionsButton; }
}
