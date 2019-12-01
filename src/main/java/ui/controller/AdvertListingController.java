package ui.controller;

import Auctions.Advert;
import ui.view.AdvertListingScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AdvertListingController extends BaseFrameController {

    private AdvertListingScreen searchAds;
    private JButton[] buyPartsButtons;
    private JButton[] viewDetailsButtons;
    private JButton[] watchListButtons;

    public AdvertListingController() { }


    public void controlSearchAds(ArrayList<Advert> adverts) {
        searchAds = new AdvertListingScreen();
        searchAds.populateMainPanel(adverts);
        buyPartsButtons = searchAds.getBuyPartButtons();
        viewDetailsButtons = searchAds.getViewDetailButtons();
        watchListButtons = searchAds.getWatchlistButtons();
        addListeners();
        searchAds.setVisible(true);
    }

    public void addListeners() {
        for(int i=0;i<buyPartsButtons.length;i++) {
            int finalI = i;
            buyPartsButtons[i].addActionListener((ActionEvent e) -> {
                System.out.println(searchAds.getAdverts().get(finalI).getPrice());

            });

            viewDetailsButtons[i].addActionListener((ActionEvent e) -> {
                System.out.println("View Details - Implement");
                //try and view details of part

            });

            watchListButtons[i].addActionListener((ActionEvent e) -> {

                System.out.println("Watch List Implement");
            });

        }
    }
}

