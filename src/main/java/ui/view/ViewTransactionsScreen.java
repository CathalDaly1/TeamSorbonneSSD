package ui.view;

import Auctions.Transaction;
import RestAPIHandlers.GetHandler;
import Users.CurrentUser;
import Users.User;
import org.omg.CORBA.Current;
import ui.controller.ReviewSellerController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class ViewTransactionsScreen extends JFrame {

    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private JButton[] reviewButtons;
    private JLabel buyer;
    private JLabel seller;
    private JLabel price;
    private JLabel partName;
    private GetHandler getHandler;
    private JButton backButton;
    List<Transaction> transactions;


    public ViewTransactionsScreen() {
        getHandler = new GetHandler();
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
        CurrentUser currentUser = CurrentUser.getInstance();
        transactions = getHandler.getTransactionsByUid(String.valueOf(currentUser.getuId()));
        reviewButtons = new JButton[transactions.size()];
        backButton = new JButton();

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        backButton = new JButton("Back Button");

        for(int i = 0;i< transactions.size();i++){
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

            User buyerUser = getHandler.getUserById(String.valueOf(transactions.get(i).getBuyerId()));
            User sellerUser = getHandler.getUserById(String.valueOf(transactions.get(i).getSellerId()));

            price = new JLabel("Price: " + transactions.get(i).getPrice());
            seller = new JLabel("Buyer: " + buyerUser.getUsername());
            buyer = new JLabel("Seller: " + sellerUser.getUsername());

            reviewButtons[i] = new JButton("Leave review for seller");


            leftPanel.add(seller);
            leftPanel.add(buyer);
            leftPanel.add(price);

            if(!sellerUser.getUsername().equals(currentUser.getUsername()))
                rightPanel.add(reviewButtons[i]);
            addListeners();
            mainPanel.add(panel);
        }
        mainPanel.add(bottomPanel);
        bottomPanel.add(backButton);
    }

   public void addListeners() {
       for (int i = 0; i < reviewButtons.length; i++) {
           int finalI = i;
           if(reviewButtons[i] != null) {
               reviewButtons[i].addActionListener((ActionEvent e) -> {
                   reviewButtons[finalI].setVisible(false);
                   ReviewSellerController rev = new ReviewSellerController(transactions.get(finalI));
                   rev.controlReviewSeller();
               });
           }
       }
   }

   public JButton[] getReviewButtons(){
        return this.reviewButtons;
    }

    public JButton getBackButton() {
        return backButton;
    }

}


