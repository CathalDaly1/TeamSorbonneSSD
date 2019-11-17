package ui.controller;

import ui.coordinator.IAppMenuScreenCoordinator;
import ui.view.BuyPCParts;

import javax.swing.*;

public class BuyPartsController extends BaseFrameController {

    private IAppMenuScreenCoordinator coordinator;
    private JButton backButton;
    private JButton buyPCPartsButton;

    public BuyPartsController(IAppMenuScreenCoordinator coordinator) {
        this.coordinator = coordinator;
        initComponents();
        initListeners();
    }

    private void initComponents() {
        BuyPCParts buyPCParts = new BuyPCParts();
        frame = buyPCParts;
        System.out.println("PC Buy Parts page displayed");
        backButton = buyPCParts.getBackButton();
        buyPCPartsButton = buyPCParts.getBuyPCPartsButton();
    }

    private void initListeners() {
        backButton.addActionListener(e -> coordinator.start());
        buyPCPartsButton.addActionListener(e -> coordinator.buyParts());
    }
}
