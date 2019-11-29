package ui.controller;
import ui.view.SellPCParts;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SellPartsController extends BaseFrameController {

    private  SellPCParts sell;
    private JButton backButton;
    private JButton placeAdvert;
    private JTextField advertName;
    private JComboBox partType;
    private JTextField advertPrice;
    private JLabel selectImageButton;

    public SellPartsController() {

    }

    public void ControlSellParts() {

        sell = new SellPCParts();
        SellPCParts sell1 = new SellPCParts();
        placeAdvert = sell.getPlaceAdvert();
        backButton = sell.getBackButton();
        selectImageButton = sell.getAdvertImage();
        advertPrice = sell.getAdvertPrice();
        partType = sell.getPartType();
        advertName = sell.getPartName();
        addListeners();
        sell.setVisible(true);
    }

    public void addListeners() {

        placeAdvert.addActionListener((ActionEvent e) -> {
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
}
