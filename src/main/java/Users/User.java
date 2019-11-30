package Users;

import Auctions.Advert;
import Auctions.Subject;

import java.util.ArrayList;

public class User implements Observer{
    private String username;
    private int uId;
    private String email;
    private String password;
    private  boolean userType;
    public ArrayList<Advert> wishlist = new ArrayList<Advert>();

    public User(){}


    public User(int uId, String username, String email, String password, boolean userType) {
        this.uId = uId;
        this.username = username;
        this.email = email;
        this.password=password;
        this.userType=userType;
    }

    public boolean getUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public void addAdvertToWishlist(Advert ad){
        wishlist.add(ad);
    }

    public void removeAdvertFromWishlist(Advert ad){
        wishlist.remove(ad);
    }

    public void update(Advert ad){
        System.out.println();
    }

    @Override
    public void update(Subject s) {
        //todo add watchlisat table with notification field
    }
}
