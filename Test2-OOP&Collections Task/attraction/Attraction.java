package main.attraction;

import main.Park;
import main.beasts.Beast;
import main.clients.Client;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Attraction {
    public static Park park;
    public enum AttractionType{ NORMAL, DANGEROUS }

    private String name;
    private double price;
    private Queue<Client> clients=new LinkedList<>();

    private Beast beast;
    private AttractionType type;

    public Attraction(String name, Beast beast, AttractionType type) {
        this.name = name;
        this.price = beast.giveShowPrice();
        if(isBeastValid(beast)) {
            this.beast = beast;
        }
        this.type = type;

    }
    public abstract boolean isBeastValid(Beast beast);

    public AttractionType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void addClient(Client client){
        double price=client.getPriceForAttraction(this);
        client.pay(price);
        this.beast.makeMoney(price);
        park.receiveIncomes(price);
        this.clients.offer(client);
    }

    public void startAttraction(){
        for(Client client: this.clients){
            beast.makeShow(client);

        }
    }

    public Beast getBeast() {
        return beast;
    }
    public int getNumberOfClients(){
        return this.clients.size();
    }

    public String getName() {
        return name;
    }
}
