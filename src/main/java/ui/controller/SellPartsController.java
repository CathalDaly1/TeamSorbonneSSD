package ui.controller;
import ui.coordinator.IAppMenuScreenCoordinator;
import ui.view.SellPCParts;
import javax.swing.*;

public class SellPartsController extends BaseFrameController {

    private IAppMenuScreenCoordinator coordinator;
    private JButton backButton;
    private JButton sellPCPartsButton;

    public SellPartsController(IAppMenuScreenCoordinator coordinator) {
        this.coordinator = coordinator;
        initialiseComponents();
        initialiseListeners();
    }

    private void initialiseComponents() {
        SellPCParts sellPCParts = new SellPCParts();
        frame = sellPCParts;
        System.out.println("Sell parts button pressed");
        backButton = sellPCParts.getBackButton();
        sellPCPartsButton = sellPCParts.getPlaceAdvert();
    }

    private void initialiseListeners() {
        backButton.addActionListener(e -> coordinator.start());
        sellPCPartsButton.addActionListener(e -> coordinator.placeAdvert());
    }
}
