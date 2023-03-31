package main.clients;

import main.Park;
import main.attraction.Attraction;

import java.util.Random;

public abstract class Client {
    public static Park park;
    public enum ClientType{ KID, ADULT, RETIRED}
    public enum Gender{ MALE, FEMALE}
    private String name;
    private int age;
    private Gender gender;
    private ClientType type;
    private double money;


    public Client(String name, int age, Gender gender, ClientType type) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.type = type;
        this.money=new Random().nextInt(200)+100;
    }

    public abstract double getPriceForAttraction(Attraction attraction);

    public ClientType getType() {
        return type;
    }

    public void pay(double price){
        if(this.money>=price) {
            this.money -= price;
        }
    }

    public void visitAttraction(){
        Attraction attraction=park.getRandomAttraction();
        attraction.addClient(this);
        attraction.startAttraction();
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
