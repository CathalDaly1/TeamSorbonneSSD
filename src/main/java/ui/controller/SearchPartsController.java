package ui.controller;

import RestAPIHandlers.DeleteHandler;
import RestAPIHandlers.GetHandler;
import RestAPIHandlers.PostHandler;
import ui.view.SearchPCPartsScreen;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SearchPartsController extends BaseFrameController {

    private SearchPCPartsScreen search;
    private JButton backButton;
    private JButton searchPCPartsButton;
    private JComboBox partType;
    private GetHandler getHandler;
    private PostHandler postHandler;
    private DeleteHandler deleteHandler;

    public SearchPartsController() {
        getHandler = new GetHandler();
        deleteHandler = new DeleteHandler();
        postHandler = new PostHandler();
    }

    public void controlSearchParts() {

        search = new SearchPCPartsScreen();
        SearchPCPartsScreen search1 = new SearchPCPartsScreen();
        searchPCPartsButton = search.getSearchPCPartsButton();
        backButton = search.getBackButton();
        partType = search.getPartType();
        addListeners();
        search.setVisible(true);
    }

    public void addListeners() {

        searchPCPartsButton.addActionListener((ActionEvent e) -> {
            System.out.println("IMPLEMENT - Search Parts");
            search.setVisible(false);
            SearchAdListingController adListing = new SearchAdListingController();
            adListing.controlSearchAds();

        });

        backButton.addActionListener((ActionEvent e) -> {

            System.out.println("Back Button");
            search.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });
    }
}
