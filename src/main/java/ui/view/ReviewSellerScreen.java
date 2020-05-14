package ui.view;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReviewSellerScreen extends JFrame {
    private JPanel mainPanel;
    private JButton backButton;
    private JButton submitReviewButton;
    private JComboBox sellerRatingComboBox;
    private JTextField reviewSellerTextField;
    private String[] rating = {"1", "2","3", "4","5"};

    public ReviewSellerScreen() {
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
        for(int i = 0;i <rating.length;i++){
            sellerRatingComboBox.addItem(rating[i]);
        }
    }


    public JButton getBackButton() {
        return backButton;
    }

    public JButton getSubmitReviewButton() {
        return submitReviewButton;
    }

    public JTextField getReviewSellerTextField() {
        return reviewSellerTextField;
    }

    public JComboBox getSellerRatingComboBox(){
        return sellerRatingComboBox;
    }
}
