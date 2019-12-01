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
        ViewTransactionsScreen tra = new ViewTransactionsScreen();
        review = viewTrans.getReview();
        viewTrans.setVisible(true);
    }

    public void addListeners() {

        review.addActionListener((ActionEvent e) -> {
            System.out.println("IMPLEMENT - Search Parts");
            review.setVisible(false);
            //set new view for review screen

        });

    }
}
