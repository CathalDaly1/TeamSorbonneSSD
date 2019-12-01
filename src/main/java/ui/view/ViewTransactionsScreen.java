package ui.view;

import ui.controller.ReviewSellerController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class ViewTransactionsScreen extends JFrame {

    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JButton review;
    private JLabel buyer;
    private JLabel seller;
    private JLabel price;
    private JLabel partName;


    public ViewTransactionsScreen() {
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

            price = new JLabel("Price :");
            seller = new JLabel("name :");
            partName = new JLabel("user :");
            buyer = new JLabel("Buyer :");

            review = new JButton("Leave review for seller");


            leftPanel.add(seller);
            leftPanel.add(buyer);
            leftPanel.add(partName);
            leftPanel.add(price);

            rightPanel.add(review);
            addListeners();
            mainPanel.add(panel);
        }
    }

   public void addListeners() {

        review.addActionListener((ActionEvent e) -> {
            System.out.println("IMPLEMENT - review");
            review.setVisible(false);
            ReviewSellerController rev = new ReviewSellerController();
            rev.controlReviewSeller();
        });
    }

    public JButton getReview() {
        return review;
    }

}


