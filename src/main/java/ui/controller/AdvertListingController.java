package ui.controller;

import auctions.Advert;
import rest_api_handlers.DeleteHandler;
import rest_api_handlers.PostHandler;
import users.CurrentUser;
import users.User;
//import javafx.geometry.Pos;
//import sun.plugin2.message.JavaObjectOpMessage;
import ui.view.AdvertListingScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AdvertListingController extends BaseFrameController {

    private AdvertListingScreen searchAds;
    private JButton[] buyPartsButtons;
    private DeleteHandler deleteHandler;
    private PostHandler postHandler;
    private JButton backButton;

    public void controlSearchAds(ArrayList<Advert> adverts) {
        deleteHandler = new DeleteHandler();
        postHandler = new PostHandler();
        searchAds = new AdvertListingScreen();
        searchAds.populateMainPanel(adverts);
        buyPartsButtons = searchAds.getBuyPartButtons();
        backButton = searchAds.getBackButton();
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
                System.out.println("User type: " + currentUser.getUserType());

                if (currentUser.getUserType()) {
                    Double discountedPrice, regularPrice;
                    regularPrice = Double.valueOf(searchAds.getAdverts().get(finalI).getPrice());
                    discountedPrice = regularPrice - (regularPrice * 0.15);
                    price = discountedPrice.toString();
                    System.out.println(regularPrice);
                    System.out.println(discountedPrice);

                    boolean result = true;

                    result = deleteHandler.deleteAdvert(uidSeller,pid);

                    result = postHandler.insertTransaction(pid,uidSeller, String.valueOf(currentUser.getuId()),price);

                    if(result){
                        JOptionPane.showMessageDialog(null,"Succesfully bought part\n You received a discounted price:" + price);
                    } else{
                        JOptionPane.showMessageDialog(null,"Sorry there was an issue in buying part");
                    }
                }
                else {
                    price = String.valueOf(searchAds.getAdverts().get(finalI).getPrice());

                    boolean result = true;

                    result = deleteHandler.deleteAdvert(uidSeller, pid);

                    result = postHandler.insertTransaction(pid, uidSeller, String.valueOf(currentUser.getuId()), price);

                    if (result) {
                        JOptionPane.showMessageDialog(null, "Succesfully bought part\n You paid: " + price);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sorry there was an issue in buying part");
                    }
                }
            });

            backButton.addActionListener((ActionEvent e) -> {
                SearchPartsController searchParts = new SearchPartsController();
                searchParts.controlSearchParts();
            });
        }
    }
}

