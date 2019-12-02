package ui.controller;

import Auctions.Advert;
import ui.view.AppMenuScreen;
import ui.view.ViewTransactionsScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ViewTransactionsController extends  BaseFrameController{

   private ViewTransactionsScreen viewTrans;
    private JButton[] reviewButtons;
    private JButton backButton;

    public ViewTransactionsController() { }

    public void controlTransactions() {
        viewTrans = new ViewTransactionsScreen();
        reviewButtons = viewTrans.getReviewButtons();
        backButton = viewTrans.getBackButton();
        addListeners();
        viewTrans.setVisible(true);
    }

    public void addListeners() {
        backButton.addActionListener((ActionEvent e) -> {
            AppMenuScreenController appMenu = new AppMenuScreenController();
            appMenu.controlMenu();
        });
    }
}
