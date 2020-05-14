package users;

public class isPremium implements UserInterface {

    public isPremium(){
    }

    public User addNewUser(int uId, String username, String email, String password, boolean userType) {
        return new User(uId, username, email, password, userType);
    }
}
