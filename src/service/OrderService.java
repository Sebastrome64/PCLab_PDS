package service;

import java.util.List;
import java.util.ArrayList;

import observer.OrderObserver;

public class OrderService {

    private List<OrderObserver> observers;

    public OrderService() {

        observers = new ArrayList<>();
    }

    public void addObserver(OrderObserver observer) {

        observers.add(observer);
    }

    public void notifyObservers(String message) {

        for(OrderObserver observer : observers) {

            observer.update(message);
        }
    }

    public void confirmOrder(double total) {

        System.out.println("\nCompra confirmada por S/ " + total);

        notifyObservers("Compra realizada");
    }
}
