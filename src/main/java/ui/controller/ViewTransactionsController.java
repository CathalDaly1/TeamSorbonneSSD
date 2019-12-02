package ui.controller;

import Auctions.Advert;
import ui.view.ViewTransactionsScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ViewTransactionsController extends  BaseFrameController{

   private ViewTransactionsScreen viewTrans;
    private JButton[] reviewButtons;

    public ViewTransactionsController() { }

    public void controlTransactions() {
        viewTrans = new ViewTransactionsScreen();
        reviewButtons = viewTrans.getReviewButtons();
        viewTrans.setVisible(true);
    }
}
