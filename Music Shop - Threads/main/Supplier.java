package main;

public class Supplier extends Thread{
    private MusicShop shop;
    private String name;

    public Supplier(MusicShop shop, String name){
        this.shop=shop;
        this.name=name;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("ops");
            }
            this.shop.deliverInstrument();
        }
    }
}
