package main.beasts;

import main.Park;
import main.clients.Client;

import java.util.Objects;

public abstract class Beast {

    public static Park park;
    public static int uniqueId=1;
    public enum BeastType{
            WATER_BEAST, AIR_BEAST, GROUND_BEAST
    }

    public enum BeastSubType{ MERMAID, KRAKEN,DRAGON, GRYPHON,DWARF, DEVIL}
    private String name;
    private int age;
    private double incomes=0;
    private boolean isDangerous;
    private BeastType type;
    private int id;

    public Beast(String name, int age, boolean isDangerous, BeastType type) {
        this.name = name;
        this.age = age;
        this.isDangerous = isDangerous;
        this.type = type;
        this.id=uniqueId++;
    }

    public abstract BeastSubType getBeastSubType();
    public abstract double giveShowPrice();

    public abstract boolean makeShow(Client client);


    public void makeMoney(double price){
        this.incomes+=price;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public BeastType getType() {
        return type;
    }

    public double getIncomes() {
        return incomes;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beast beast = (Beast) o;
        return id == beast.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
