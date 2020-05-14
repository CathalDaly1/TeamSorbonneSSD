package ui.controller;

import ui.view.ViewTransactionsScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ViewTransactionsController extends  BaseFrameController{

   private ViewTransactionsScreen viewTrans;
    private JButton[] reviewButtons;
    private JButton backButton;


    public void controlTransactions() {
        viewTrans = new ViewTransactionsScreen();
        reviewButtons = viewTrans.getReviewButtons();
        backButton = viewTrans.getBackButton();
        addListeners();
        viewTrans.setVisible(true);
    }

    public void addListeners() {
        backButton.addActionListener((ActionEvent e) -> {
            viewTrans.dispose();
        });
    }
}
