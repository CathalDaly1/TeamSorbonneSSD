package ui.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdvertListingScreen extends JFrame{
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JButton buyPartsButton;
    private JButton viewDetails;
    private JButton watchList;


    public AdvertListingScreen() {
        mainPanel = new JPanel();
        scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);
        setTitle("PC Part Picker app");
        setSize(500, 500);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

        populateMainPanel();
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

    private void populateMainPanel() {
        //get advert details

        for(int i = 0;i< 9;i++){
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1,2));

            JPanel leftPanel = new JPanel();
            leftPanel.setLayout(new GridLayout(3,1));
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new GridLayout(3,1));
            Border blackline = BorderFactory.createLineBorder(Color.black);
            panel.setBorder(blackline);


            panel.add(leftPanel);
            panel.add(rightPanel);

            JLabel price = new JLabel("Price :");
            JLabel name = new JLabel("name :");
            JLabel user = new JLabel("user :");

            buyPartsButton = new JButton("Buy Part");
            viewDetails = new JButton("View Details");
            watchList = new JButton("Add to WatchList");

            leftPanel.add(price);
            leftPanel.add(name);
            leftPanel.add(user);

            rightPanel.add(buyPartsButton);
            rightPanel.add(viewDetails);
            rightPanel.add(watchList);
            addListeners1();
            mainPanel.add(panel);
        }
    }

    public void addListeners1() {
        buyPartsButton.addActionListener((ActionEvent e) -> {
            System.out.println("buy parts - Implement");
            //Implement screen
        });

        viewDetails.addActionListener((ActionEvent e) -> {
            System.out.println("View Details - Implement");

        });

        watchList.addActionListener((ActionEvent e) -> {
            System.out.println("Watch List Implement");

        });
    }

    public JButton getBuyPartsButton() {
        return buyPartsButton;
    }

}
