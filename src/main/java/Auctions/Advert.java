package Auctions;

import CompatibilityChecker.Parts.CompositePart;
import CompatibilityChecker.Parts.Part;
import Users.User;

import java.util.ArrayList;

public class Advert extends Subject {
    private ArrayList<User> observers = new ArrayList<User>();
    private double price;
    private int userId;
    private int pid;
    private Part partSelling;

    public Advert(double price, int userId,int pid, Part partSelling) {
        this.pid = pid;
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


    public Part getPartSelling() {
        return partSelling;
    }

    public void setPartSelling(Part partSelling) {
        this.partSelling = partSelling;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
