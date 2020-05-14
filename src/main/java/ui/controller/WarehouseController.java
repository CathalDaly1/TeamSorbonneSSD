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
    private JButton addPartButton;
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
        WarehouseScreen warehouse = new WarehouseScreen();
        nameComboBox = warehouse.getPartName();
        backButton = warehouse.getBackButton();
        addPartButton = warehouse.getPartButton();
        addListeners();
        warehouse.setVisible(true);
    }

    public void addListeners() {

        addPartButton.addActionListener((ActionEvent e) -> {
            String partName = (String) nameComboBox.getSelectedItem();
            warehouse.setVisible(false);
        });

        backButton.addActionListener((ActionEvent e) -> {
            warehouse.setVisible(false);
            warehouse.dispose();
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });
    }

    private void addToWarehouse(String partName) {
        String partId = getHandler.getPartIdWithName(partName);

        User currentUser = CurrentUser.getInstance();

        // Post handler
    }
}
