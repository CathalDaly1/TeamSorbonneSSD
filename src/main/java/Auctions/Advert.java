package Auctions;

import CompatibilityChecker.Parts.CompositePart;
import Users.User;

import java.util.ArrayList;

public class Advert extends Subject {
    private ArrayList<User> observers = new ArrayList<User>();
    private double price;
    private int userId;
    private CompositePart partSelling;

    public Advert(double price, int userId, CompositePart partSelling) {
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
        if(this.price > price){
            notifyObservers();
        }
        this.price = price;
    }


}
