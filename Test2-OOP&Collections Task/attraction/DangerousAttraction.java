package main.attraction;

import main.beasts.Beast;
import main.clients.Client;

public class DangerousAttraction extends Attraction{

    public DangerousAttraction(String name, Beast beast) {
        super(name, beast, AttractionType.DANGEROUS);
    }

    @Override
    public boolean isBeastValid(Beast beast) {
        return beast.isDangerous();
    }

    @Override
    public void addClient(Client client) {
        if(!client.getType().equals(Client.ClientType.KID)) {
            super.addClient(client);
        }
        else{
            System.out.println("Cannot enter this attraction");
        }
    }
}
