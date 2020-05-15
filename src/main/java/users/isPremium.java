package users;

public class isPremium implements AppliesDiscount{

    @Override
    public double appliesDiscount(double price) {
        return price - (price * 0.15);
    }
}
