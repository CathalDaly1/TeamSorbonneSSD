package ui.controller;

import ui.coordinator.IAppMenuScreenCoordinator;
import ui.view.SearchPCPartsScreen;

import javax.swing.*;

public class SearchPartsController extends BaseFrameController {

    private IAppMenuScreenCoordinator coordinator;
    private JButton backButton;
    private JButton searchPCPartsButton;

    public SearchPartsController(IAppMenuScreenCoordinator coordinator) {
        this.coordinator = coordinator;
        initialiseComponents();
        initialiseListeners();
    }

    private void initialiseComponents() {
        SearchPCPartsScreen searchPCPartsScreen = new SearchPCPartsScreen();
        frame = searchPCPartsScreen;
        System.out.println("PC Search page displayed");
        backButton = searchPCPartsScreen.getBackButton();
        searchPCPartsButton = searchPCPartsScreen.getSearchPCPartsButton();
    }

    private void initialiseListeners() {
        backButton.addActionListener(e -> coordinator.start());
        searchPCPartsButton.addActionListener(e -> coordinator.searchForParts());
    }
}
