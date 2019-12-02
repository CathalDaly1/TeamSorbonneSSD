package ui.view;

import Auctions.Advert;
import CompatibilityChecker.Configuration.CompatibilityResult;
import Users.CurrentUser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AdvertListingScreen extends JFrame{
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JButton[] buyPartsButtons;
    private JButton backButton;
    private ArrayList<Advert> adverts;


    public AdvertListingScreen() {
        mainPanel = new JPanel();
        scrollPane = new JScrollPane(mainPanel);
        add(scrollPane);
        setTitle("PC Part Picker app");
        setSize(500, 500);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));

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

    public void populateMainPanel(ArrayList<Advert> adverts) {
        this.adverts = adverts;
        //get advert details
        buyPartsButtons = new JButton[adverts.size()];
        backButton = new JButton();

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        backButton = new JButton("Back Button");

        for(int i = 0;i< adverts.size();i++){
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1,2));

            JPanel leftPanel = new JPanel();
            leftPanel.setLayout(new GridLayout(4,1));
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new GridLayout(1,1));
            Border blackline = BorderFactory.createLineBorder(Color.black);
            panel.setBorder(blackline);

            panel.add(leftPanel);
            panel.add(rightPanel);

            JLabel price = new JLabel("Price: " + adverts.get(i).getPrice());
            JLabel name = new JLabel("Name Of Part: " + adverts.get(i).getPartSelling().getName());
            JLabel user = new JLabel("User Selling: " + adverts.get(i).getUserId());

            CurrentUser currentUser = CurrentUser.getInstance();
            CompatibilityResult compatibilityResult = currentUser.insertPart(adverts.get(i).getPartSelling());
            String compatibilityMessage = "";

            if(compatibilityResult.isCompatible()){
                compatibilityMessage += "This part is compatible w/ your build";
            } else {
                compatibilityMessage += compatibilityResult.getMessage();
            }

            JLabel compatibility = new JLabel("Compatibility: " + compatibilityMessage);

            buyPartsButtons[i] = new JButton("Buy Part");

            leftPanel.add(price);
            leftPanel.add(name);
            leftPanel.add(user);
            leftPanel.add(compatibility);

            rightPanel.add(buyPartsButtons[i]);
            mainPanel.add(panel);
        }
        mainPanel.add(bottomPanel);
        bottomPanel.add(backButton);
    }

    public JButton[] getBuyPartButtons() {
        return buyPartsButtons;
    }

    public JButton getBackButton() { return backButton; }

    public ArrayList<Advert> getAdverts() {
        return adverts;
    }

}
