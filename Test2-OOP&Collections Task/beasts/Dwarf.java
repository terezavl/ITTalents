package main.beasts;

import main.clients.Client;

public class Dwarf extends GroundBeast{

    public Dwarf( int age) {
        super("Dwarf", age, false);
    }

    private void createJewelry(){
        System.out.println("creating jewelry");
    }

    @Override
    public BeastSubType getBeastSubType() {
        return BeastSubType.DWARF;
    }
    @Override
    public double giveShowPrice() {
        return 60;
    }

    @Override
    public boolean makeShow(Client client) {
        System.out.println("I am the Dwarf! I will make you a ring!");
        this.createJewelry();
        return true;
    }
}
