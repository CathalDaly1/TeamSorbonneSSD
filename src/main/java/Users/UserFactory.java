package Users;

public class UserFactory {
    public UserFactory(){}

    public User addNewUser(int uId, String username, String email, String password, boolean userType){
        if(!userType){
            return new User(uId, username, email, password, userType);
        }
        else{
            return new PremiumUser(uId, username, email, password, userType);
        }

    }
}
