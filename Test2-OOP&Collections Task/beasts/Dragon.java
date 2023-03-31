package main.beasts;

import main.clients.Client;

import java.util.ArrayList;
import java.util.Random;

public class Dragon extends AirBeast{
    private String treasure;
    private ArrayList<Client> burnedHumans=new ArrayList<>();

    public Dragon( int age, int maxFlyingSpeed) {
        super("Dragon", age, true, maxFlyingSpeed);
        this.treasure="gems and gold";
    }

    @Override
    public BeastSubType getBeastSubType() {
        return BeastSubType.DRAGON;
    }

    @Override
    public double giveShowPrice() {
        return 80;
    }

    @Override
    public boolean makeShow(Client client) {
        System.out.println("I am the mighty dragon! I will give you are a gem");
        int chance = new Random().nextInt(100);
        if(chance<10){
            System.out.println("DRAKARIS! One client burned from Dragon.");
            this.burnedHumans.add(client);
            park.incrementSwallowedClients();
            return false;
        }
        return true;
    }

    public ArrayList<Client> getBurnedHumans() {
        return burnedHumans;
    }
}
