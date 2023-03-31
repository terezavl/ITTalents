package main.beasts;

import main.clients.Client;

public class Gryphon extends AirBeast{
    private String color;
    private int wingsSize;

    public Gryphon( int age, int maxFlyingSpeed, String color, int wingsSize) {
        super("Gryphon", age, false, maxFlyingSpeed);
        this.color = color;
        this.wingsSize = wingsSize;
    }

    @Override
    public BeastSubType getBeastSubType() {
        return BeastSubType.GRYPHON;
    }

    @Override
    public double giveShowPrice() {
        return 40;
    }

    @Override
    public boolean makeShow(Client client) {
        System.out.println("I am the gryphon! Let's go on a ride!");
        return true;
    }
}
