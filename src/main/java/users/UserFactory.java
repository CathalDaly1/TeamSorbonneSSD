package users;

public class UserFactory implements UserInterface {

    public UserFactory(){
    }

    public User addNewUser(int uId, String username, String email, String password, boolean userType) {
        return new User(uId, username, email, password, userType);
    }
}
