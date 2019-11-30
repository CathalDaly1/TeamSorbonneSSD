package Users;

public class PremiumUser extends User{

    private int monthsPremiumRemaining;

    public PremiumUser(int uId, String username, String email, String password, boolean userType) {
        super(uId,username,email,password,userType);
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
