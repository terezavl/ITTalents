package main;

import java.util.Random;

public class Client extends Thread{
    private MusicShop shop;
    private String name;
    public Client (MusicShop shop, String name){
        this.shop=shop;
        this.name=name;
    }

    @Override
    public void run() {
        while (true){
            MusicInsrument.InstrumentType type=MusicInsrument.getRandomInstrType();
            int quantity=new Random().nextInt(3)+1;
            System.out.println("Client wants "+quantity+" "+type);
            this.shop.sellInstrument(type,quantity);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("opa");
            }
        }
    }
}
