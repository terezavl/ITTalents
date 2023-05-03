package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Port {

    private List<Dock> docks=new ArrayList<>();
    private BlockingQueue<Package> storage1=new ArrayBlockingQueue<>(1000);
    private BlockingQueue<Package> storage2=new ArrayBlockingQueue<>(1000);

    public Port(){
        for (int i = 0; i < 5; i++) {
            docks.add(new Dock());
        }
    }

    public Dock getRandomDock() {
        return this.docks.get(new Random().nextInt(this.docks.size()));
    }

    public Dock getDockForOffload(){
       Optional<Dock> dock=(this.docks.stream()
                .filter(d -> d.getPackages() > 0).findFirst());
        return dock.orElse(null);
    }

    public void addToStorage(List<Package> packages) {
        try {
            if (new Random().nextBoolean()) {
                for (int i = 0; i < packages.size(); i++) {
                    storage1.put(packages.get(i));
                    packages.get(i).setOffLoadTime(LocalDateTime.now());
                }

            } else {
                for (int i = 0; i < packages.size(); i++) {
                    storage2.put(packages.get(i));
                    packages.get(i).setOffLoadTime(LocalDateTime.now());
                }
            }
            System.out.println("Added all packages to storage");
        }catch (InterruptedException e){
            System.out.println("ale male");
        }
    }

    public void removeFromStorage(){
        try {
            if (new Random().nextBoolean()) {
                this.storage1.take();

            } else {
                this.storage2.take();
            }
            System.out.println("Taken from storage");
        }catch (InterruptedException e){
            System.out.println("ale male");
        }
    }
}
