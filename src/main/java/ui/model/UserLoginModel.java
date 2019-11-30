package ui.model;

public class UserLoginModel {

    private String username;
    private String password;

    public UserLoginModel() {
    }

    public boolean login() {
        return UIController.getInstance().logIn(username, password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
