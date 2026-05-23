import model.Cart;
import model.Product;

public class Main {

    public static void main(String[] args) {

        Product p1 = new Product(1, "Laptop", 2500);
        Product p2 = new Product(2, "Mouse", 80);

        Cart cart = new Cart();

        cart.addProduct(p1);
        cart.addProduct(p2);

        System.out.println("Total: S/ " + cart.calculateTotal());
    }
}