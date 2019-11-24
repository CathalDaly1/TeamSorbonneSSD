package Users;

public class UserFactory {
    public UserFactory(){}

    public User addNewUser(int uId, String username, String email, String password, int userType){
        if(userType==0){
            return new User(uId, username, email, password, userType);
        }
        else if(userType==1){
            return new PremiumUser(uId, username, email, password, userType);
        }
        else if(userType==2){
            return new StaffUser(uId, username, email, password, userType);
        }
        else{
            return null;
        }
    }
}
