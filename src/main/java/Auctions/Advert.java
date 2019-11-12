package Auctions;

public class Advert {

    private double price;
    private int userId;

    public Advert(double price, int userId) {
        this.price = price;
        this.userId = userId;
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
