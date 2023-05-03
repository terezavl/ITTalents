package main;

import java.util.ArrayList;
import java.util.Objects;

public class Waiter {
    public static Restaurant restaurant;
    public static int uniqueId;
    private String name;
    private double tips;
    private int id;
    private ArrayList<Order> orders=new ArrayList<>();

    public Waiter(String name) {
        this.name = name;
        this.tips = 0;
        id=uniqueId++;
    }

    public String getName() {
        return name;
    }

    public double getTips() {
        return tips;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return id == waiter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void acceptOrder(Order order) {
        this.orders.add(order);
    }

    public void giveInfoForOrder(Order order) {
        System.out.println(order);
    }

    public void acceptTip(double tip) {
        this.tips+=tip;
    }
}
