package ui.controller;

import Auctions.Advert;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.DeleteHandlerCommands.deleteAdvertCommand;
import RestAPIHandlers.Command.DeleteHandlerCommands.deletePcBuildCommand;
import RestAPIHandlers.Command.PostHandlerCommands.InsertTransactionCommand;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
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
import java.util.HashMap;
import java.util.List;

public class AdvertListingController extends BaseFrameController {

    private AdvertListingScreen searchAds;
    private JButton[] buyPartsButtons;
    private DeleteHandler deleteHandler;
    private PostHandler postHandler;
    private JButton backButton;

    public AdvertListingController() { }


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
                boolean result = true;


                Command deleteAdvertCommand = new deleteAdvertCommand();
                HashMap<String,Object> map = new HashMap<>();
                map.put("uid",uidSeller);
                map.put("pid",pid);
                RestParameters restParameters = new RestParameters(map);
                deleteAdvertCommand.execute(restParameters);

                result = deleteHandler.deleteAdvert(uidSeller,pid);


                Command insertTransactionCommand = new InsertTransactionCommand();
                map = new HashMap<>();
                map.put("uid1",uidSeller);
                map.put("uid2",String.valueOf(currentUser.getuId()));
                map.put("pid",pid);
                map.put("price",price);
                restParameters = new RestParameters(map);
                insertTransactionCommand.execute(restParameters);

                if(result){
                    JOptionPane.showMessageDialog(null,"Succesfully bought part");
                } else{
                    JOptionPane.showMessageDialog(null,"Sorry there was an issue in buying part");
                }
            });

            backButton.addActionListener((ActionEvent e) -> {
                SearchPartsController searchParts = new SearchPartsController();
                searchParts.controlSearchParts();
            });
        }
    }
}

