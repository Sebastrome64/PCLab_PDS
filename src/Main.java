import adapter.CreditCardPaymentProcessor;
import adapter.ExternalPayPalService;
import adapter.PayPalAdapter;
import adapter.PaymentProcessor;
import model.Cart;
import model.Product;
import strategy.PercentageDiscountStrategy;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product(1, "Laptop", 2500);
        Product p2 = new Product(2, "Mouse", 80);

        Cart cart = new Cart();

        cart.addProduct(p1);
        cart.addProduct(p2);

        cart.applyDiscountStrategy(new PercentageDiscountStrategy());

        System.out.println("Total: S/ " + cart.calculateTotal());

        PaymentProcessor paymentProcessor;
        paymentProcessor = new PayPalAdapter(new ExternalPayPalService());
        paymentProcessor.pay(cart.calculateTotal());
    }
}