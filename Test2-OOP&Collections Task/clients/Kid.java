package main.clients;

import main.attraction.Attraction;

import java.util.ArrayList;
import java.util.List;

public class Kid extends Client{

    public Kid(String name, int age, Gender gender) {
        super(name, age, gender, ClientType.KID);
    }

    @Override
    public double getPriceForAttraction(Attraction attraction) {
        if(attraction.getType().equals(Attraction.AttractionType.NORMAL)){
            return attraction.getPrice()*0.5;
        }
        System.out.println("can't visit this attraction");
        return 0;
    }


}
