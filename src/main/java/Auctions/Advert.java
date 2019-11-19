package Auctions;

import CompatibilityChecker.Parts.CompositeEquipment;

public class Advert {

    private double price;
    private int userId;
    private CompositeEquipment partSelling;

    public Advert(double price, int userId, CompositeEquipment partSelling) {
        this.price = price;
        this.userId = userId;
        this.partSelling = partSelling;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //Part
}
