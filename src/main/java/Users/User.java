package Users;

public class User {
    private String username;
    private int uId;

    public User(){}


    public User(int uId, String username) {
        this.uId = uId;
        this.username = username;
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
}
