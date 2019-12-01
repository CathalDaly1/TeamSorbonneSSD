package ui.controller;

import ui.view.ViewTransactionsScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ViewTransactionsController extends  BaseFrameController{

   private ViewTransactionsScreen viewTrans;
    private JButton review;

    public ViewTransactionsController() {

    }

    public void controlTransactions() {

        viewTrans = new ViewTransactionsScreen();
        review = viewTrans.getReview();
        addListeners();
        viewTrans.setVisible(true);
    }

    public void addListeners() {

        review.addActionListener((ActionEvent e) -> {
            System.out.println("IMPLEMENT - review");
            review.setVisible(false);
            //ReviewSellerController rev = new ReviewSellerController();
            //rev.controlReviewSeller();
        });
    }
}
