package main;

public class Demo {
    public static void main(String[] args) {
        MusicShop shop=new MusicShop("Music Shop");
        Supplier supplier=new Supplier(shop,"Supplier");
        supplier.start();
        Client client=new Client(shop,"Client");
        client.start();
    }
}
