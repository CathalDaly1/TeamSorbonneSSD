package ui.controller;
import RestAPIHandlers.GetHandler;
import RestAPIHandlers.PostHandler;
import Users.CurrentUser;
import Users.User;
import ui.view.SellPCParts;
import javax.swing.*;
import java.awt.event.ActionEvent;

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
            AppMenuScreenController menu = new AppMenuScreenController();
            menu.controlMenu();
        });
    }

    private void createAdvert(String partName,String advertPrice) {
        String partId = getHandler.getPartIdWithName(partName);

        User currentUser = CurrentUser.getInstance();

        postHandler.insertAdvert(partId,String.valueOf(currentUser.getuId()),advertPrice);
    }
}
