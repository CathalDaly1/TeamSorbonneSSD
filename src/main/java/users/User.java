package users;

import auctions.Advert;
import rest_api_handlers.GetHandler;

public class User {
    private String username;
    private int uId;
    private String email;
    private String password;
    private  boolean userType;
    private GetHandler getHandler;

    public User(){
        /*
            This is empty to allow for CurrentUser to implement Singleton
         */
    }

    public User(int uId, String username, String email, String password, boolean userType) {
        getHandler = new GetHandler();
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

    public void update(Advert ad){
        System.out.println();
    }

}
