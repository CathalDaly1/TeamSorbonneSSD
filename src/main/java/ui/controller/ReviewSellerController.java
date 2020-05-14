package ui.controller;

import Auctions.Transaction;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.PostHandlerCommands.InsertAdvertCommand;
import RestAPIHandlers.Command.PostHandlerCommands.InsertReviewCommand;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.DeleteHandler;
import RestAPIHandlers.GetHandler;
import RestAPIHandlers.PostHandler;
import ui.view.ReviewSellerScreen;
import ui.view.SearchPCPartsScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

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


            Command insertReivewCommand = new InsertReviewCommand();
            HashMap<String,Object> map = new HashMap<>();
            map.put("tid",String.valueOf(transaction.getTid()));
            map.put("rating",String.valueOf(sellerRatingComboBox.getSelectedItem()));
            map.put("buyerComment",reviewSellerTextField.getText());
            RestParameters restParameters = new RestParameters(map);
            insertReivewCommand.execute(restParameters);

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
