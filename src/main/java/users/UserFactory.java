package users;

public class UserFactory {
    public UserFactory(){
        /*
            This is empty to allow for CurrentUser to implement Singleton
         */
    }

    public User addNewUser(int uId, String username, String email, String password, boolean userType){
        if(!userType){
            return new User(uId, username, email, password, userType);
        }
        else{
            return new PremiumUser(uId, username, email, password, userType);
        }

    }
}
