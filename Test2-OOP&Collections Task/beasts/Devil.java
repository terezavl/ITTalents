package main.beasts;

import main.clients.Client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Devil extends GroundBeast {
    private boolean makeWish = true;
    private ArrayList<Client> souls = new ArrayList<>();

    public Devil(int age) {
        super("Devil", age, true);
    }

    @Override
    public BeastSubType getBeastSubType() {
        return BeastSubType.DEVIL;
    }

    @Override
    public double giveShowPrice() {
        return 100;
    }

    @Override
    public boolean makeShow(Client client) {
        System.out.println("I am the Devil! I will make your wish come true!");
        int chance = new Random().nextInt(100);
        if (chance < 10) {
            System.out.println("Oops the devil took a soul.");
            this.souls.add(client);
            park.incrementSwallowedClients();
            return false;
        }
        return true;
    }

    public ArrayList<Client> getSouls() {
        return souls;

    }


}
