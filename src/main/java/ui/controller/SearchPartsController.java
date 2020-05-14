package ui.controller;

import auctions.Advert;
import rest_api_handlers.DeleteHandler;
import rest_api_handlers.GetHandler;
import rest_api_handlers.PostHandler;
import ui.model.SearchPartsModel;
import ui.view.SearchPCPartsScreen;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
            ArrayList<Advert> adverts = (ArrayList<Advert>) getHandler.getAdvertByPartType(model.getPartType());
            search.setVisible(false);
            AdvertListingController adListing = new AdvertListingController();
            adListing.controlSearchAds(adverts);
        });

        backButton.addActionListener((ActionEvent e) -> {

            System.out.println("Back Button");
            search.setVisible(false);
            search.dispose();
        });
    }
}
