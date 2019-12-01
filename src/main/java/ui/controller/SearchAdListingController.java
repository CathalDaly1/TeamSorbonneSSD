package ui.controller;

import ui.view.AdvertListingScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SearchAdListingController extends BaseFrameController {

    private AdvertListingScreen searchAds;
    private JButton buyPartsButton;
    private JButton viewDetails;
    private JButton watchList;

    public SearchAdListingController() { }


    public void controlSearchAds() {
        searchAds = new AdvertListingScreen();
        AdvertListingScreen search1 = new AdvertListingScreen();
        buyPartsButton = searchAds.getBuyPartsButton();
        System.out.println();
        addListeners1();
        searchAds.setVisible(true);
    }

    public void addListeners1() {
        buyPartsButton.addActionListener((ActionEvent e) -> {
            System.out.println("buy parts");
            searchAds.setVisible(false);
            //SearchAdListingController adListing = new SearchAdListingController();
            //adListing.controlSearchAds();

        });
    }
}
