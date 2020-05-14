package ui.controller;

import auctions.Transaction;
import rest_api_handlers.DeleteHandler;
import rest_api_handlers.GetHandler;
import rest_api_handlers.PostHandler;
import ui.view.ReviewSellerScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReviewSellerController {

    private ReviewSellerScreen reviewSeller;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton submitReviewButton;
    private JComboBox sellerRatingComboBox;
    private JLabel reviewSellerLabel;
    private JLabel ratingLabel;
    private JTextField reviewSellerTextField;
    private JComboBox partType;
    private GetHandler getHandler;
    private PostHandler postHandler;
    private DeleteHandler deleteHandler;
    Transaction transaction;


    public ReviewSellerController(Transaction transaction) {
        this.transaction = transaction;
        getHandler = new GetHandler();
        deleteHandler = new DeleteHandler();
        postHandler = new PostHandler();
    }

    public void controlReviewSeller() {

        reviewSeller = new ReviewSellerScreen();
        submitReviewButton = reviewSeller.getSubmitReviewButton();
        sellerRatingComboBox = reviewSeller.getSellerRatingComboBox();
        reviewSellerTextField = reviewSeller.getReviewSellerTextField();
        backButton = reviewSeller.getBackButton();
        addListeners();
        reviewSeller.setVisible(true);
    }

    public void addListeners() {

        submitReviewButton.addActionListener((ActionEvent e) -> {
            reviewSeller.setVisible(false);
            postHandler.insertReview(String.valueOf(transaction.getTid()),String.valueOf(sellerRatingComboBox.getSelectedItem()),reviewSellerTextField.getText());

            AppMenuScreenController review = new AppMenuScreenController();
            review.controlMenu();
        });

        backButton.addActionListener((ActionEvent e) -> {

            System.out.println("Back Button");
            reviewSeller.setVisible(false);
            SearchPartsController menu = new SearchPartsController();
            menu.controlSearchParts();
        });
    }
}
