package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship extends Thread{
    private String name;
    private List<Package> packages=new ArrayList<>();
    public static Port port;
    public Ship(String name){
        setName(name);
        for (int i = 0; i < new Random().nextInt(4)+1; i++) {
            Package p=new Package();
            packages.add(p);
            p.setShip(this);
        }
    }

    @Override
    public void run() {
        while (true){
            try {
                Dock dock = port.getRandomDock();
                for (Package p : this.packages){
                    p.setDock(dock);
                }
                dock.offload(this.packages);
                System.out.println(Thread.currentThread().getName()+" has entered dock ");
                Thread.sleep(packages.size() * 2000);
            }
            catch (InterruptedException e){
                System.out.println("ops");
            }
        }
    }
}
