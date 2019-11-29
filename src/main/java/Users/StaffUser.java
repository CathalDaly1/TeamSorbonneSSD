package Users;

public class StaffUser extends User {

    public StaffUser(int uId, String username, String email, String password, int userType) {
        this.setuId(uId);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setUserType(userType);
    }

    public void removeAdvert(){
        //promotion code
    }

    public void removeUser(){
        //remove reported user
    }

    public void approveAdvert(){
        //approve pending advert
    }


}

