package ui.controller;
import javax.swing.*;
import ui.view.AppMenuScreen;
import java.awt.event.ActionEvent;

public class AppMenuScreenController extends BaseFrameController {

    private AppMenuScreen menu;
    private JPanel mainPanel;
    private JButton searchPartsButton;
    private JButton sellPartsButton;
    private JButton logoutButton;
    private JButton configurePCButton;
    private JButton viewTransactionsButton;

    public AppMenuScreenController() {

    }

    public void controlMenu() {
        menu = new AppMenuScreen();
        AppMenuScreen mv1 = new AppMenuScreen();
        sellPartsButton = menu.getSellPartsButton();
        searchPartsButton = menu.getSearchPartsButton();
        configurePCButton = menu.getConfigurePCButton();
        logoutButton = menu.getLogoutButton();
        viewTransactionsButton = menu.getViewTransactionsButton();
        addListeners();
        menu.setVisible(true);
    }

    public void addListeners() {

        sellPartsButton.addActionListener((ActionEvent e) -> {
            System.out.println("Sell parts button pressed");
            menu.setVisible(false);
            SellPartsController sellParts = new SellPartsController();
            sellParts.ControlSellParts();
        });

        searchPartsButton.addActionListener((ActionEvent e) -> {
            System.out.println("Search Parts Button Pressed");
            menu.setVisible(false);
            SearchPartsController searchParts = new SearchPartsController();
            searchParts.controlSearchParts();
        });

        configurePCButton.addActionListener((ActionEvent e) -> {
            System.out.println("Configure PC Button pressed");
            menu.setVisible(false);
            ConfigurePCController configure = new ConfigurePCController();
            configure.controlConfigurePC();
        });

        viewTransactionsButton.addActionListener((ActionEvent e) -> {
            System.out.println("View Transactions Button pressed");
            System.out.println("IMPLEMENT - View Transactions screen");
            //menu.setVisible(false);
            //ViewTransactionsController transactions = new ViewTransactionsController();
            //System.out.println("view trans");
        });

        logoutButton.addActionListener((ActionEvent e) -> {
            int userLogout = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to logout of PC Part Piecer?",
                    "Logout", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (userLogout == JOptionPane.YES_NO_OPTION) {
                System.out.println("USER LOGOUT - Implement");
            }
        });
    }
}
