package main.beasts;

import main.clients.Client;

import java.util.ArrayList;
import java.util.Random;

public class Mermaid extends WaterBeast{
    private String hairColor;
    private ArrayList<Client> kidnappedClients=new ArrayList<>();

    public Mermaid( int age, int maxDepth, String hairColor) {
        super("Mermaid", age, true, maxDepth);
        this.hairColor = hairColor;
    }

    @Override
    public BeastSubType getBeastSubType() {
        return BeastSubType.MERMAID;
    }
    @Override
    public double giveShowPrice() {
        return 60;
    }

    @Override
    public boolean makeShow(Client client) {
        System.out.println("I am beautiful mermaid. Listen to my song");
        int chance = new Random().nextInt(100);
        if(chance<10){
            System.out.println("La La La .. one client was taken in the depths by mermaid");
            this.kidnappedClients.add(client);
            park.incrementSwallowedClients();
            return false;
        }
        return true;
    }

    public ArrayList<Client> getKidnappedClients() {
        return kidnappedClients;
    }
}
