package ui.controller;

import rest_api_handlers.GetHandler;
import rest_api_handlers.PostHandler;
import rest_api_handlers.DeleteHandler;
import users.CurrentUser;
import users.User;
import ui.view.WarehouseScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class WarehouseController extends BaseFrameController {

    private WarehouseScreen warehouse;
    private JButton backButton;
    private JButton addPart;
    private JComboBox nameComboBox;
    private GetHandler getHandler;
    private PostHandler postHandler;
    private DeleteHandler deleteHandler;

    public WarehouseController() {
        getHandler = new GetHandler();
        deleteHandler = new DeleteHandler();
        postHandler = new PostHandler();
    }

    public void warehouseScreen() {
        warehouse = new WarehouseScreen();
        WarehouseScreen warehouse1 = new WarehouseScreen();
        nameComboBox = warehouse1.getPartName();
        backButton = warehouse1.getBackButton();
        addPart = warehouse1.getAddPart();
        addListeners();
        warehouse.setVisible(true);
    }

    public void addListeners() {

        addPart.addActionListener((ActionEvent e) -> {
            System.out.println("testnowwww2123");
            String partName = (String) nameComboBox.getSelectedItem();
            warehouse.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("testnowwww");
            warehouse.setVisible(false);
            warehouse.dispose();
        });
    }

    private void addToWarehouse(String partName) {
        String partId = getHandler.getPartIdWithName(partName);

        User currentUser = CurrentUser.getInstance();

        // Post handler
    }
}
