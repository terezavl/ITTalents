package main.clients;

import main.attraction.Attraction;

public class Adult extends Client{
    private boolean hasReturnedFromAttraction=true;

    public Adult(String name, int age, Gender gender) {
        super(name, age, gender, ClientType.ADULT);
    }

    @Override
    public double getPriceForAttraction(Attraction attraction) {
        return attraction.getPrice();
    }
}
