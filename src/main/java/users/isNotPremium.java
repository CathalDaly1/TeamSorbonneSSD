package users;

public class isNotPremium implements AppliesDiscount {
    @Override
    public double appliesDiscount(double price) {
        return price;
    }
}
