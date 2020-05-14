package ui.controller;
import rest_api_handlers.GetHandler;
import rest_api_handlers.PostHandler;
import users.CurrentUser;
import users.User;
import RestAPIHandlers.Command.Command;
import RestAPIHandlers.Command.GetHandlerCommands.GetPartIdWithNameCommand;
import RestAPIHandlers.Command.PostHandlerCommands.InsertAdvertCommand;
import RestAPIHandlers.Command.RestParameters;
import RestAPIHandlers.Command.RestResponse;
import rest_api_handlers.GetHandler;
import rest_api_handlers.PostHandler;
import users.CurrentUser;
import users.User;
import ui.view.SellPCParts;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class SellPartsController extends BaseFrameController {

    private  SellPCParts sell;
    private JButton backButton;
    private JButton placeAdvert;
    private JTextField advertName;
    private JComboBox nameComboBox;
    private JTextField advertPrice;
    private GetHandler getHandler;
    private PostHandler postHandler;

    public SellPartsController() {
        getHandler = new GetHandler();
        postHandler = new PostHandler();
    }

    public void ControlSellParts() {

        sell = new SellPCParts();
        SellPCParts sell1 = new SellPCParts();
        nameComboBox = sell.getPartName();
        placeAdvert = sell.getPlaceAdvert();
        backButton = sell.getBackButton();
        advertPrice = sell.getAdvertPrice();
        addListeners();
        sell.setVisible(true);
    }

    public void addListeners() {

        placeAdvert.addActionListener((ActionEvent e) -> {
            String partName = (String) nameComboBox.getSelectedItem();
            createAdvert(partName, advertPrice.getText());
            System.out.println("Place advert");
            sell.setVisible(false);
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("register");
            sell.setVisible(false);
            sell.dispose();
        });
    }

    private void createAdvert(String partName,String advertPrice) {

        Command getUserWithNameCommand = new GetPartIdWithNameCommand();
        HashMap<String,Object> map = new HashMap<>();
        map.put("name",partName);
        RestParameters restParameters = new RestParameters(map);
        RestResponse response = getUserWithNameCommand.execute(restParameters);
        String partId = (String) response.getValueReturned();

        User currentUser = CurrentUser.getInstance();


        Command insertAdvertCommand = new InsertAdvertCommand();
        map = new HashMap<>();
        map.put("uid",String.valueOf(currentUser.getuId()));
        map.put("pid",partId);
        map.put("price",advertPrice);
        restParameters = new RestParameters(map);
        insertAdvertCommand.execute(restParameters);
    }
}
