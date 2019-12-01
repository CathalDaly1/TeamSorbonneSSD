package ui.view;

import Auctions.Advert;

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
    private JButton[] viewDetailButtons;
    private JButton[] watchlistButtons;
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
        viewDetailButtons = new JButton[adverts.size()];
        watchlistButtons = new JButton[adverts.size()];

        for(int i = 0;i< adverts.size();i++){
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

            JLabel price = new JLabel("Price :" + adverts.get(i).getPrice());
            JLabel name = new JLabel("name :" + adverts.get(i).getPartSelling().getName());
            JLabel user = new JLabel("user :" + adverts.get(i).getUserId());

            buyPartsButtons[i] = new JButton("Buy Part");
            viewDetailButtons[i] = new JButton("View Details");
            watchlistButtons[i] = new JButton("Add to WatchList");

            leftPanel.add(price);
            leftPanel.add(name);
            leftPanel.add(user);

            rightPanel.add(buyPartsButtons[i]);
            rightPanel.add(viewDetailButtons[i]);
            rightPanel.add(watchlistButtons[i]);
            mainPanel.add(panel);
        }
    }

    public JButton[] getBuyPartButtons() {
        return buyPartsButtons;
    }

    public JButton[] getViewDetailButtons() {
        return viewDetailButtons;
    }

    public JButton[] getWatchlistButtons() {
        return watchlistButtons;
    }

    public ArrayList<Advert> getAdverts() {
        return adverts;
    }

}
