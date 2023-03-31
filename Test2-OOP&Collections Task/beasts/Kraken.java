package main.beasts;

import main.clients.Client;

public class Kraken extends WaterBeast{
    private int pipala;

    public Kraken(int age, int maxDepth, int pipala) {
        super("Kraken", age, false, maxDepth);
        this.pipala = pipala;
    }

    @Override
    public BeastSubType getBeastSubType() {
        return BeastSubType.KRAKEN;
    }
    @Override
    public double giveShowPrice() {
        return 90;
    }

    @Override
    public boolean makeShow(Client client) {
        System.out.println("I am the Kraken. Here you are a perl");
        return true;
    }
}
