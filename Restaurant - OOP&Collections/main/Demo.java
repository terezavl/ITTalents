package main;

import main.clients.Client;
import main.clients.Gangster;
import main.clients.Student;
import main.clients.Vegan;
import main.products.Alcohol;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        Restaurant restaurant=new Restaurant("Pesho Talanta","Sofia",1000);
        Waiter.restaurant=restaurant;
        Client.restaurant=restaurant;

        for (int i = 0; i < 5; i++) {
            Waiter waiter=new Waiter("Waiter "+(i+1));
            restaurant.hireWaiter(waiter);
        }

        for (int i = 0; i < 15; i++) {
            Client client;
            int chance = new Random().nextInt(100);
            if(chance<20){
                client=new Vegan("Vegan "+(i+1));
            }
            else{
                if(chance<50){
                    client=new Student("Student "+(i+1));
                }
                else{
                    client=new Gangster("Gangster "+(i+1));
                }
            }
            restaurant.acceptClient(client);
        }

        restaurant.printMenu();
        restaurant.startDay();
        restaurant.printCurrentMoney();
        restaurant.printWaitersByTips();
        restaurant.printMostRichWaiter();
        restaurant.printMenu();

    }
}
