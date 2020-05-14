package ui.model;

public class UserLoginModel {

    private String username;
    private String password;

    public boolean login() {
//        return UIController.getInstance().logIn(username, password);
        return  true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
