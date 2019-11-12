package Users;

public class PremiumUser extends User{

    private int monthsPremiumRemaining;

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
