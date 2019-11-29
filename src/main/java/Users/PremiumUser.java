package Users;

public class PremiumUser extends User{

    private int monthsPremiumRemaining;

    public PremiumUser(int uId, String username, String email, String password, int userType) {
        this.setuId(uId);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setUserType(userType);
    }

    public void promoteAdvert(){
        //promotion code
    }

    public int getMonthsPremiumRemaining() {
        return monthsPremiumRemaining;
    }

    public void setMonthsPremiumRemaining(int monthsPremiumRemaining) {
        this.monthsPremiumRemaining = monthsPremiumRemaining;
    }
}
