import observer.InventoryObserver;
import observer.EmailNotificationObserver;
import observer.AdminNotificationObserver;
import service.OrderService;
import adapter.CreditCardPaymentProcessor;
import adapter.ExternalPayPalService;
import adapter.PayPalAdapter;
import adapter.PaymentProcessor;
import model.Cart;
import model.Product;
import strategy.PercentageDiscountStrategy;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== TIENDA VIRTUAL =====");
        System.out.println("--------------------------");

        Product p1 = new Product(1, "Laptop", 2500);
        Product p2 = new Product(2, "Mouse", 80);

        Cart cart = new Cart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.showProducts();
        System.out.println("--------------------------");
        cart.setDiscountStrategy(new PercentageDiscountStrategy());
        System.out.println("Descuento: 10%");
        System.out.println("Total: S/ " + cart.calculateTotal());
        PaymentProcessor paymentProcessor;
        paymentProcessor =
                new PayPalAdapter(new ExternalPayPalService());
        paymentProcessor.pay(cart.calculateTotal());
        System.out.println("--------------------------");
        OrderService orderService = new OrderService();
        orderService.addObserver(new EmailNotificationObserver());
        orderService.addObserver(new InventoryObserver());
        orderService.addObserver(new AdminNotificationObserver());
        orderService.confirmOrder(cart.calculateTotal());
    }
}