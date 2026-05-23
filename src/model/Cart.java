package model;

import java.util.ArrayList;
import java.util.List;

import strategy.DiscountStrategy;
import strategy.NoDiscountStrategy;

public class Cart {

    private List<Product> products;
    private DiscountStrategy discountStrategy;

    public Cart() {
        products = new ArrayList<>();
        discountStrategy = new NoDiscountStrategy();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal() {

        double total = 0;

        for(Product product : products) {
            total += product.getPrice();
        }

        return discountStrategy.applyDiscount(total);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void showProducts() {

        System.out.println("\nPRODUCTOS EN CARRITO:");

        for(Product product : products) {

            System.out.println(product.getName()
                    + " - S/ " + product.getPrice());
        }
    }
}