package ui.controller;

import Auctions.Advert;
import RestAPIHandlers.DeleteHandler;
import RestAPIHandlers.PostHandler;
import Users.CurrentUser;
import Users.User;
import javafx.geometry.Pos;
import sun.plugin2.message.JavaObjectOpMessage;
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
    private DeleteHandler deleteHandler;
    private PostHandler postHandler;

    public AdvertListingController() { }


    public void controlSearchAds(ArrayList<Advert> adverts) {
        deleteHandler = new DeleteHandler();
        postHandler = new PostHandler();
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
                String uidSeller = String.valueOf(searchAds.getAdverts().get(finalI).getUserId());
                String pid = String.valueOf(searchAds.getAdverts().get(finalI).getPid());
                String price = String.valueOf(searchAds.getAdverts().get(finalI).getPrice());
                User currentUser = CurrentUser.getInstance();
                boolean result = true;

                result = deleteHandler.deleteAdvert(uidSeller,pid);

                result = postHandler.insertTransaction(pid,uidSeller, String.valueOf(currentUser.getuId()),price);

                if(result){
                    JOptionPane.showMessageDialog(null,"Succesfully bought part");
                } else{
                    JOptionPane.showMessageDialog(null,"Sorry there was an issue in buying part");
                }
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

