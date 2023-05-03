package main;

import java.util.ArrayList;
import java.util.List;

public class Dock {
    private int id;
    private static final int MAX_CAPACITY=1;
    private int currentCapacity=0;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private List<Package> packages=new ArrayList<>();
    public synchronized void offload(List<Package> packages){
        while (currentCapacity>=MAX_CAPACITY){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("opa");
            }
        }
        this.currentCapacity++;
        this.packages.addAll(packages);
        notifyAll();
    }

    public synchronized List<Package> takePackage(){
        while (currentCapacity<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("male");
            }
        }
        this.currentCapacity--;
        notifyAll();
        System.out.println("Packages are taken from dock");
        List<Package> temp=this.packages;
        this.packages=new ArrayList<>();
        return temp;
    }

    public int getPackages() {
        return packages.size();
    }
}
