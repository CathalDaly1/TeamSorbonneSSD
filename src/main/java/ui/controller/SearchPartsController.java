package ui.controller;

import Auctions.Advert;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.GetHandlerCommands.GetAdvertsByPartTypeCommand;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import RestAPIHandlers.DeleteHandler;
import RestAPIHandlers.GetHandler;
import RestAPIHandlers.PostHandler;
import ui.model.SearchPartsModel;
import ui.view.SearchPCPartsScreen;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchPartsController extends BaseFrameController {

    private SearchPCPartsScreen search;
    private JButton backButton;
    private JButton searchPCPartsButton;
    private JComboBox partType;
    private GetHandler getHandler;
    private PostHandler postHandler;
    private DeleteHandler deleteHandler;
    private SearchPartsModel model;

    public SearchPartsController() {
        model = new SearchPartsModel();
        getHandler = new GetHandler();
        deleteHandler = new DeleteHandler();
        postHandler = new PostHandler();
    }

    public void controlSearchParts() {

        search = new SearchPCPartsScreen();
        searchPCPartsButton = search.getSearchPCPartsButton();
        backButton = search.getBackButton();
        partType = search.getPartType();
        addListeners();
        search.setVisible(true);
    }

    public void addListeners() {

        searchPCPartsButton.addActionListener((ActionEvent e) -> {
            model.setPartType((String) partType.getSelectedItem());

            Command getAdvertsByPartTypeCommand = new GetAdvertsByPartTypeCommand();
            HashMap<String,Object> map = new HashMap<>();
            map.put("type",model.getPartType());
            RestParameters restParameters = new RestParameters(map);
            RestResponse response = getAdvertsByPartTypeCommand.execute(restParameters);
            ArrayList<Advert> adverts = (ArrayList<Advert>) response.getValueReturned();
            search.setVisible(false);
            AdvertListingController adListing = new AdvertListingController();
            adListing.controlSearchAds(adverts);
        });

        backButton.addActionListener((ActionEvent e) -> {

            System.out.println("Back Button");
            search.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });
    }
}
