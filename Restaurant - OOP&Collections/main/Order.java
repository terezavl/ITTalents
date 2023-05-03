package main;

import main.clients.Client;
import main.products.Product;

import java.util.ArrayList;

public class Order {
    public static int uniqueNumber=1;
    private Client client;

    private int number;
    private ArrayList<Product> products=new ArrayList<>();

    public Order(Client client) {
        this.client = client;
        this.number=uniqueNumber++;
    }

    public void addToOrder(Product product){
        this.products.add(product);
    }

    public int getOrderPrice(){
        return products.stream()
                .map(product -> product.getPrice())
                .reduce(0,(total,number) -> total+number);
    }

    @Override
    public String toString() {
        return "Order number: "+number+", client "+client.getName()+" \n\tproducts: "+products+ " \n\t TOTAL PRICE: "+getOrderPrice();
    }
}
