package ui.controller;
import javax.swing.*;
import ui.coordinator.IAppMenuScreenCoordinator;
import ui.view.AppMenuScreen;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMenuScreenController extends BaseFrameController {
    private IAppMenuScreenCoordinator coordinator;
    private JPanel mainPanel;
    private JButton searchPartsButton;
    private JButton sellPartsButton;
    private JButton logoutButton;
    private JButton configurePCButton;

    public AppMenuScreenController(IAppMenuScreenCoordinator coordinator) {
        this.coordinator = coordinator;
        initialiseFrameComponents();
        initialiseFrameListeners();
    }

    private void initialiseFrameComponents() {
        AppMenuScreen menu = new AppMenuScreen();
        frame = menu;
        sellPartsButton = menu.getSellPartsButton();
        searchPartsButton = menu.getSearchPartsButton();
        configurePCButton = menu.getConfigurePCButton();
        logoutButton = menu.getLogoutButton();
    }
    
    private void initialiseFrameListeners() {
        sellPartsButton.addActionListener(e -> coordinator.sellParts());
        configurePCButton.addActionListener(e -> coordinator.configurePC());
        searchPartsButton.addActionListener(e -> coordinator.searchParts());
        logoutButton.addActionListener(e-> coordinator.logoutUser());
    }

    private class SearchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("PC Parts Search Button");
        }
    }
}
