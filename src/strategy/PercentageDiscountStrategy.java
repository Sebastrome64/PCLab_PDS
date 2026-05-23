package strategy;

public class PercentageDiscountStrategy implements DiscountStrategy{

    @Override
    public double applyDiscount(double total) {
        return total * 0.90;
    }
}
