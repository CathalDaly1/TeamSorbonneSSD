package Users;
public class User {
    private String username;
    private int uId;
    private String email;
    private String password;
    private  int userType;

    public User(){}


    public User(int uId, String username, String email, String password, int userType) {
        this.uId = uId;
        this.username = username;
        this.email = email;
        this.password=password;
        this.userType=userType;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
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
}
