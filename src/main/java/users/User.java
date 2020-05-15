package users;

import auctions.Advert;


public class User {
    private String username;
    private int uId;
    private String email;
    private String password;
    private  boolean userType;
    private AppliesDiscount isPremium;

    public users.UserInterface userTypeNow;

    public User(){}

    public User(int uId, String username, String email, String password, boolean userType) {
        this.uId = uId;
        this.username = username;
        this.email = email;
        this.password=password;
        this.userType=userType;

        if(userType == true){
            this.setIsPremium(new isPremium());
        }
        else {
            this.setIsPremium(new isNotPremium());
        }
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

    public void update(Advert ad){
        System.out.println();
    }

    public User tryGetUser() {
        System.out.println("Type of User: " + userType);
        return userTypeNow.addNewUser(uId, username, email, password, userType);
    }

    public void setUserAbility(users.UserInterface newUserType) {
        userTypeNow = newUserType;
    }

    public double tryToApplyDiscount(double price){
        return isPremium.appliesDiscount(price);
    }

    public void setIsPremium(AppliesDiscount appliesDiscount){
        isPremium = appliesDiscount;
    }
}