package ui.controller;

import ui.view.SearchPCPartsScreen;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SearchPartsController extends BaseFrameController {

    private SearchPCPartsScreen search;
    private JButton backButton;
    private JButton searchPCPartsButton;
    private JComboBox partType;
    private JComboBox partBrand;
    private JComboBox partPriceRange;

    public SearchPartsController() {

    }

    public void controlSearchParts() {

        search = new SearchPCPartsScreen();
        SearchPCPartsScreen search1 = new SearchPCPartsScreen();
        searchPCPartsButton = search.getSearchPCPartsButton();
        backButton = search.getBackButton();
        partType = search.getPartType();
        partBrand = search.getPartBrand();
        partPriceRange = search.getPartPriceRange();
        addListeners();
        search.setVisible(true);
    }

    public void addListeners() {

        searchPCPartsButton.addActionListener((ActionEvent e) -> {
            System.out.println("Login");
            search.setVisible(false);
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("Back Button");
            search.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });
    }
}
