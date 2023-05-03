package main;

import java.util.List;

public class Crane extends Thread{
    public static Port port;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true){
            try {
                Dock dock = port.getDockForOffload();
                if (dock != null) {
                    List<Package> packages = dock.takePackage();
                    packages.stream().forEach(p -> p.setCrane(this));
                    Thread.sleep(packages.size() * 2000L);
                    port.addToStorage(packages);
                }
            }catch (InterruptedException e){
                System.out.println("opa");
            }
        }
    }
}
