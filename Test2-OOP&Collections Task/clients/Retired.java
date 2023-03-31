package main.clients;

import main.attraction.Attraction;

public class Retired extends Client{
    private boolean hasReturnedFromAttraction=true;

    public Retired(String name, int age, Gender gender) {
        super(name, age, gender, ClientType.RETIRED);
    }

    @Override
    public double getPriceForAttraction(Attraction attraction) {
        return attraction.getPrice();
    }
}
