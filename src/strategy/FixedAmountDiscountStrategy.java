package strategy;

public class FixedAmountDiscountStrategy implements DiscountStrategy{

    @Override
    public double applyDiscount(double total) {
        return total - 20;
    }
}
