package ui.controller;

import RestAPIHandlers.DeleteHandler;
import RestAPIHandlers.GetHandler;
import RestAPIHandlers.PostHandler;
import ui.view.ReviewSellerScreen;
import ui.view.SearchPCPartsScreen;

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


    public ReviewSellerController() {

        getHandler = new GetHandler();
        deleteHandler = new DeleteHandler();
        postHandler = new PostHandler();
    }

    public void controlReviewSeller() {

        reviewSeller = new ReviewSellerScreen();
        submitReviewButton = reviewSeller.getSubmitReviewButton();
        backButton = reviewSeller.getBackButton();
        addListeners();
        reviewSeller.setVisible(true);
    }

    public void addListeners() {

        submitReviewButton.addActionListener((ActionEvent e) -> {
            System.out.println("IMPLEMENT - Search Parts");
            reviewSeller.setVisible(false);
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
